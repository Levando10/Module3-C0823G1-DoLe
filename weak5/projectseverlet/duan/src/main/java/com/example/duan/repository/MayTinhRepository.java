package com.example.duan.repository;

import com.example.duan.model.BangSuDung;
import com.example.duan.model.MayTinh;
import com.example.duan.model.NhanVien;
import com.example.duan.repository.impl.IMayTinhRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MayTinhRepository implements IMayTinhRepository {
  private final String START_TIME = "INSERT INTO bang_su_dung (thoi_gian_bat_dau, ma_may_tinh, id_nhan_vien) VALUES(?,?,?)";
  private final String SET_STATUS_ON = "update may_tinh set status = ? where ma_may_tinh = ?;";
  private final String SET_STATUS_OFF = "update may_tinh set status = ? where ma_may_tinh = ?;";
  private final String SELECT_ID_SU_DUNG = "SELECT bang_su_dung.id_bang_su_dung\n"
      + "FROM bang_su_dung\n"
      + "WHERE bang_su_dung.ma_may_tinh = ? \n"
      + "ORDER BY bang_su_dung.thoi_gian_bat_dau DESC\n"
      + "LIMIT 1;";
  private final String END_TIME = "update bang_su_dung set thoi_gian_ket_thuc = ? where ma_may_tinh = ? and id_bang_su_dung = ?;";
  private final String SELECT_ALL_COMPUTER = "select mt.ma_may_tinh,mt.ten_may_tinh,mt.ram, mt.chip,mt.hang,mt.is_delete from may_tinh mt";

  private final String SELECT_ALL_COMPUTER_USING = "select mt.ma_may_tinh,mt.ten_may_tinh,mt.ram, mt.chip,mt.hang,mt.is_delete from may_tinh mt"
      + "  where mt.status = 1;";
  private final String SELECT_COMPUTER_NOT_RENTAL = "select mt.ma_may_tinh,mt.ten_may_tinh,mt.ram, mt.chip,mt.hang,mt.is_delete from may_tinh mt"
      + "  where mt.status = 0;";


  private final String SELECT_COMPUTER = "select*\n"
      + "from may_tinh mt\n"
      + "where   ma_may_tinh = ? And is_delete = ?;";
  private final String SELECT_HISTORY_RENTAL = "SELECT bsd.*\n"
      + " FROM bang_su_dung bsd \n"
      + " join may_tinh mt on bsd.ma_may_tinh = mt.ma_may_tinh\n"
      + " where mt.ma_may_tinh = ? and bsd.thoi_gian_ket_thuc is not null ;";
  @Override
  public MayTinh getComputer(int id) {
    MayTinh mayTinh = null;
    Connection connection = BaseRepository.getConnection();
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COMPUTER);
      preparedStatement.setInt(1,id);
      preparedStatement.setInt(2,0);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        int idMayTinh = resultSet.getInt("ma_may_tinh");
        String tenMayTinh = resultSet.getString("ten_may_tinh");
        String ram = resultSet.getString("ram");
        String chip = resultSet.getString("chip");
        String hang = resultSet.getString("hang");
        boolean is_delete = resultSet.getBoolean("is_delete");
        mayTinh = new MayTinh(idMayTinh,tenMayTinh,ram,chip,hang,is_delete);
      }
      // SET_STATUS = "update may_tinh set status = ? where ma_may_tinh = ?;";


    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return mayTinh;
  }

  @Override
  public void endTimeComputer(BangSuDung bangSuDung) {
    Connection connection = BaseRepository.getConnection();
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(END_TIME);
      int idMay = bangSuDung.getMaMayTinh().getIdMayTinh();
      preparedStatement.setObject(1,bangSuDung.getGioKetThuc());
      preparedStatement.setInt(2,idMay);
      preparedStatement.setInt(3,bangSuDung.getIdBangSuDung());
      preparedStatement.executeUpdate();
      System.out.println(bangSuDung.getIdBangSuDung());

      preparedStatement = connection.prepareStatement(SET_STATUS_OFF);
      preparedStatement.setInt(1,0);
      preparedStatement.setInt(2,idMay);
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public int startTimeComputer(BangSuDung bangSuDung) {
    Connection connection = BaseRepository.getConnection();
    System.out.println(bangSuDung.getGioBatDau());
    int id_bang_su_dung = 0;
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(START_TIME);
      preparedStatement.setObject(1,bangSuDung.getGioBatDau());
      int idMay = bangSuDung.getMaMayTinh().getIdMayTinh();
      int idNhanVien = bangSuDung.getMaNhanVien().getIdNhanVien();
      preparedStatement.setInt(2,idMay);
      preparedStatement.setInt(3,idNhanVien);
      preparedStatement.executeUpdate();

     preparedStatement = connection.prepareStatement(SELECT_ID_SU_DUNG);
     preparedStatement.setInt(1,idMay);
     ResultSet resultSet = preparedStatement.executeQuery();

     while (resultSet.next()){
       id_bang_su_dung = resultSet.getInt("id_bang_su_dung");
     }
     //SET_STATUS = "update may_tinh set status = ? where ma_may_tinh = ?;";
      preparedStatement = connection.prepareStatement(SET_STATUS_ON);
      preparedStatement.setInt(1,1);
      preparedStatement.setInt(2,idMay);
      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    System.out.println(id_bang_su_dung);
  return id_bang_su_dung;
  }

  @Override
  public List<MayTinh> getListMayTinh() {
    List<MayTinh> mayTinhList = new ArrayList<>();
    Connection connection = BaseRepository.getConnection();
    Statement statement = null;
    try {
      statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(SELECT_ALL_COMPUTER);
      while (resultSet.next()) {
        int idMayTinh = resultSet.getInt("ma_may_tinh");
        String tenMayTinh = resultSet.getString("ten_may_tinh");
        String ramMayTinh = resultSet.getString("ram");
        String chip = resultSet.getString("chip");
        String hang = resultSet.getString("hang");
        Boolean isDelete = resultSet.getBoolean("is_delete");
        mayTinhList.add(new MayTinh(idMayTinh, tenMayTinh, ramMayTinh, chip, hang, isDelete));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        statement.close();
        connection.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return mayTinhList;
  }

  @Override
  public List<MayTinh> getListAreRental() {
    List<MayTinh> mayTinhList = new ArrayList<>();
    Connection connection = BaseRepository.getConnection();
    Statement statement = null;
    try {
      statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(SELECT_ALL_COMPUTER_USING);
      while (resultSet.next()) {
        int idMayTinh = resultSet.getInt("ma_may_tinh");
        String tenMayTinh = resultSet.getString("ten_may_tinh");
        String ramMayTinh = resultSet.getString("ram");
        String chip = resultSet.getString("chip");
        String hang = resultSet.getString("hang");
        Boolean isDelete = resultSet.getBoolean("is_delete");
        mayTinhList.add(new MayTinh(idMayTinh, tenMayTinh, ramMayTinh, chip, hang, isDelete));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        statement.close();
        connection.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return mayTinhList;
  }

  @Override
  public List<MayTinh> listNotRental() {
    List<MayTinh> mayTinhList = new ArrayList<>();
    Connection connection = BaseRepository.getConnection();
    Statement statement = null;
    try {
      statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(SELECT_COMPUTER_NOT_RENTAL);
      while (resultSet.next()) {
        int idMayTinh = resultSet.getInt("ma_may_tinh");
        String tenMayTinh = resultSet.getString("ten_may_tinh");
        String ramMayTinh = resultSet.getString("ram");
        String chip = resultSet.getString("chip");
        String hang = resultSet.getString("hang");
        Boolean isDelete = resultSet.getBoolean("is_delete");
        mayTinhList.add(new MayTinh(idMayTinh, tenMayTinh, ramMayTinh, chip, hang, isDelete));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        statement.close();
        connection.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return mayTinhList;
  }

  @Override
  public int getIdSuDung(int idMay) {
    Connection connection = BaseRepository.getConnection();
    int id_bang_su_dung = 0;
    try {
      PreparedStatement  preparedStatement = connection.prepareStatement(SELECT_ID_SU_DUNG);
      preparedStatement.setInt(1,idMay);
      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()){
        id_bang_su_dung = resultSet.getInt("id_bang_su_dung");
      }

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return id_bang_su_dung;
  }

  @Override
  public List<BangSuDung> historyRental(int idMay) {
    Connection connection = BaseRepository.getConnection();
    BangSuDung bangSuDung;
    List<BangSuDung> historyRental = new ArrayList<>();
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(SELECT_HISTORY_RENTAL);
      preparedStatement.setInt(1,idMay);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()){
      int id_bang_su_dung = resultSet.getInt("id_bang_su_dung");

        Timestamp timestampStart = resultSet.getTimestamp("thoi_gian_bat_dau");
        LocalDateTime thoi_gian_bat_dau = timestampStart.toLocalDateTime();

        Timestamp timestampEnd = resultSet.getTimestamp("thoi_gian_ket_thuc");
        LocalDateTime thoi_gian_ket_thuc = timestampEnd.toLocalDateTime();
        int idNhanVienNhanVien = resultSet.getInt("id_nhan_vien");
        NhanVien nhanVien = new NhanVien(idNhanVienNhanVien);
        MayTinh mayTinh = new MayTinh(idMay);

         bangSuDung = new BangSuDung(id_bang_su_dung,thoi_gian_bat_dau,thoi_gian_ket_thuc,mayTinh,nhanVien);
        historyRental.add(bangSuDung);
      }

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return historyRental;
  }


}