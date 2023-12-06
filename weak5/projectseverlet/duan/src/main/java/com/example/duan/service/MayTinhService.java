package com.example.duan.service;

import com.example.duan.model.BangSuDung;
import com.example.duan.model.MayTinh;
import com.example.duan.repository.MayTinhRepository;
import com.example.duan.repository.impl.IMayTinhRepository;
import com.example.duan.service.impl.IMayTinhService;
import java.util.List;

public class MayTinhService implements IMayTinhService {
  private final IMayTinhRepository computerRepository = new MayTinhRepository();

  @Override
  public List<MayTinh> getListMayTinh() {
    return computerRepository.getListMayTinh();
  }

  @Override
  public MayTinh getComputer(int id) {
    return computerRepository.getComputer(id);
  }

  @Override
  public void startTimeCompany(BangSuDung bangSuDung) {
    computerRepository.startTimeCompany(bangSuDung);
  }
}
