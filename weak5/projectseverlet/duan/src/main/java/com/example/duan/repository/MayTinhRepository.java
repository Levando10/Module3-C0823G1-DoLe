package com.example.duan.repository;

import com.example.duan.model.BangSuDung;
import com.example.duan.model.MayTinh;
import com.example.duan.repository.impl.IMayTinhRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MayTinhRepository implements IMayTinhRepository {
  private final String START_TIME = "INSERT INTO bang_su_dung (thoi_gian_bat_dau, ma_may_tinh, id_nhan_vien) VALUES(?,?,?)";
  private final String SELECT_ALL_COMPUTER = "select mt.ma_may_tinh,mt.ten_may_tinh,mt.ram, mt.chip,mt.hang,ttct.mo_ta_tinh_trang,mt.is_delete from may_tinh mt join tinh_trang_chi_tiet ttct on mt.ma_tinh_trang = ttct.ma_tinh_trang;";

  private final String SELECT_COMPUTER = "select*\n"
      + "from may_tinh mt\n"
      + "where   ma_may_tinh = ? And is_delete = ?;";
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

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return mayTinh;
  }

  @Override
  public void startTimeCompany(BangSuDung bangSuDung) {
    Connection connection = BaseRepository.getConnection();
    

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


}