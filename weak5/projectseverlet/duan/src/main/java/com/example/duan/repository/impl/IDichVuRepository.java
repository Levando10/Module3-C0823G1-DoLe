package com.example.duan.repository.impl;

import com.example.duan.model.DichVuDiKem;
import com.example.duan.model.LoaiDichVu;
import java.util.List;

public interface IDichVuRepository {

  List<DichVuDiKem> getListDichVu();
}
