package com.example.duan.service;

import com.example.duan.model.DichVuDiKem;
import com.example.duan.model.LoaiDichVu;
import com.example.duan.repository.DichVuRepository;
import com.example.duan.repository.impl.IDichVuRepository;
import com.example.duan.service.impl.IDichVuService;
import java.util.ArrayList;
import java.util.List;

public class DichVuService implements IDichVuService {
  private final IDichVuRepository iDichVuRepository = new DichVuRepository();

  @Override
  public List<DichVuDiKem> getListDichVu() {
    return iDichVuRepository.getListDichVu();
  }
}
