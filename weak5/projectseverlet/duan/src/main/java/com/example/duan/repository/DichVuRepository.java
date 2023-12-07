package com.example.duan.repository;

import com.example.duan.model.DichVuDiKem;
import com.example.duan.model.LoaiDichVu;
import com.example.duan.repository.impl.IDichVuRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DichVuRepository implements IDichVuRepository {
    private final String SELECT_ALL_DICH_VU = "select*\n"
        + "from dich_vu_di_kem;";
  @Override
  public List<DichVuDiKem> getListDichVu() {
    Connection connection = BaseRepository.getConnection();
    List<DichVuDiKem> list = new ArrayList<>();
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DICH_VU);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()){
        int idDichVu = resultSet.getInt("id_dich_vu_di_kem");
        String nameDichVu = resultSet.getString("ten_dich_vu_di_kem");
        double price = resultSet.getDouble("gia_dich_vu_di_kem");
        LoaiDichVu loaiDichVu = new LoaiDichVu(resultSet.getInt("id_loai_dich_vu"));
        DichVuDiKem dichVuDiKem = new DichVuDiKem(idDichVu,nameDichVu,price,loaiDichVu);
        list.add(dichVuDiKem);
      }


    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return list;
  }
}
