package com.example.duan.repository.impl;

import com.example.duan.model.BangSuDung;
import com.example.duan.model.MayTinh;
import java.util.List;

public interface IMayTinhRepository {
  List<MayTinh>getListMayTinh();

  MayTinh getComputer(int id);

  void startTimeCompany(BangSuDung bangSuDung);
}