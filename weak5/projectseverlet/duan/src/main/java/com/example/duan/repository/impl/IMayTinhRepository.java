package com.example.duan.repository.impl;

import com.example.duan.model.BangSuDung;
import com.example.duan.model.MayTinh;
import java.time.LocalDateTime;
import java.util.List;

public interface IMayTinhRepository {
  List<MayTinh>getListMayTinh();

  MayTinh getComputer(int id);

  int startTimeComputer(BangSuDung bangSuDung);

  void endTimeComputer(BangSuDung bangSuDung);

  List<MayTinh> getListAreRental();

  List<MayTinh> listNotRental();

  int getIdSuDung(int idMay);

  List<BangSuDung> historyRental(int idMay);
}