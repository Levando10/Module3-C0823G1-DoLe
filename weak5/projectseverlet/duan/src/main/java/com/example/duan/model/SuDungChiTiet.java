package com.example.duan.model;

public class SuDungChiTiet {
  private int idSuDungChiTiet;
  private DichVuDiKem maDichVuDiKem;
  private BangSuDung maBangSuDung;
  private int soLuong;

  public SuDungChiTiet(int idSuDungChiTiet, DichVuDiKem maDichVuDiKem, BangSuDung maBangSuDung, int soLuong) {
    this.idSuDungChiTiet = idSuDungChiTiet;
    this.maDichVuDiKem = maDichVuDiKem;
    this.maBangSuDung = maBangSuDung;
    this.soLuong = soLuong;
  }

  public SuDungChiTiet(DichVuDiKem maDichVuDiKem, BangSuDung maBangSuDung, int soLuong) {
    this.maDichVuDiKem = maDichVuDiKem;
    this.maBangSuDung = maBangSuDung;
    this.soLuong = soLuong;
  }

  public int getIdSuDungChiTiet() {
    return idSuDungChiTiet;
  }

  public void setIdSuDungChiTiet(int idSuDungChiTiet) {
    this.idSuDungChiTiet = idSuDungChiTiet;
  }

  public DichVuDiKem getMaDichVuDiKem() {
    return maDichVuDiKem;
  }

  public void setMaDichVuDiKem(DichVuDiKem maDichVuDiKem) {
    this.maDichVuDiKem = maDichVuDiKem;
  }

  public BangSuDung getMaBangSuDung() {
    return maBangSuDung;
  }

  public void setMaBangSuDung(BangSuDung maBangSuDung) {
    this.maBangSuDung = maBangSuDung;
  }

  public int getSoLuong() {
    return soLuong;
  }

  public void setSoLuong(int soLuong) {
    this.soLuong = soLuong;
  }
}