package com.example.duan.model;


import java.time.LocalDateTime;

public class BangSuDung {
  private int idBangSuDung;
  private LocalDateTime gioBatDau;
  private LocalDateTime gioKetThuc;

  private MayTinh maMayTinh;
  private NhanVien maNhanVien;

  public BangSuDung(int idBangSuDung, LocalDateTime gioBatDau, MayTinh maMayTinh) {
    this.idBangSuDung = idBangSuDung;
    this.gioBatDau = gioBatDau;
    this.maMayTinh = maMayTinh;
  }

  public BangSuDung(int idBangSuDung,MayTinh maMayTinh ,LocalDateTime gioKetThuc ) {
    this.idBangSuDung = idBangSuDung;
    this.gioKetThuc = gioKetThuc;
    this.maMayTinh = maMayTinh;
  }

  public BangSuDung(int idBangSuDung, LocalDateTime gioBatDau, LocalDateTime gioKetThuc, MayTinh maMayTinh, NhanVien maNhanVien) {
    this.idBangSuDung = idBangSuDung;
    this.gioBatDau = gioBatDau;
    this.gioKetThuc = gioKetThuc;
    this.maMayTinh = maMayTinh;
    this.maNhanVien = maNhanVien;
  }

  public BangSuDung(LocalDateTime gioBatDau, MayTinh maMayTinh, NhanVien maNhanVien) {
    this.gioBatDau = gioBatDau;
    this.maMayTinh = maMayTinh;
    this.maNhanVien = maNhanVien;
  }

  public BangSuDung(LocalDateTime gioBatDau, LocalDateTime gioKetThuc, MayTinh maMayTinh, NhanVien maNhanVien) {
    this.gioBatDau = gioBatDau;
    this.gioKetThuc = gioKetThuc;
    this.maMayTinh = maMayTinh;
    this.maNhanVien = maNhanVien;
  }

  public int getIdBangSuDung() {
    return idBangSuDung;
  }

  public void setIdBangSuDung(int idBangSuDung) {
    this.idBangSuDung = idBangSuDung;
  }

  public LocalDateTime getGioBatDau() {
    return gioBatDau;
  }

  public void setGioBatDau(LocalDateTime gioBatDau) {
    this.gioBatDau = gioBatDau;
  }

  public LocalDateTime getGioKetThuc() {
    return gioKetThuc;
  }

  public void setGioKetThuc(LocalDateTime gioKetThuc) {
    this.gioKetThuc = gioKetThuc;
  }

  public MayTinh getMaMayTinh() {
    return maMayTinh;
  }

  public void setMaMayTinh(MayTinh maMayTinh) {
    this.maMayTinh = maMayTinh;
  }

  public NhanVien getMaNhanVien() {
    return maNhanVien;
  }

  public void setMaNhanVien(NhanVien maNhanVien) {
    this.maNhanVien = maNhanVien;
  }

  @Override
  public String toString() {
    return "BangSuDung{" +
        "idBangSuDung=" + idBangSuDung +
        ", gioBatDau=" + gioBatDau +
        ", gioKetThuc=" + gioKetThuc +
        ", maMayTinh=" + maMayTinh +
        ", maNhanVien=" + maNhanVien +
        '}';
  }
}