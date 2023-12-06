package com.example.duan.model;

public class TinhTrangChiTiet {
  private int idTinhTrangChiTiet;
  private String nameTinhTrangChiTiet;
  private TinhTrang maTinhTrang;

  public TinhTrangChiTiet(int idTinhTrangChiTiet, String nameTinhTrangChiTiet, TinhTrang maTinhTrang) {
    this.idTinhTrangChiTiet = idTinhTrangChiTiet;
    this.nameTinhTrangChiTiet = nameTinhTrangChiTiet;
    this.maTinhTrang = maTinhTrang;
  }

  public TinhTrangChiTiet(String nameTinhTrangChiTiet, TinhTrang maTinhTrang) {
    this.nameTinhTrangChiTiet = nameTinhTrangChiTiet;
    this.maTinhTrang = maTinhTrang;
  }
}