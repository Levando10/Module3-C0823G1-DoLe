package com.example.duan.model;

public class NhanVien {
  private int idNhanVien;
  private String tenNhanVien;
  private String soDienThoaiNhanVien;
  private TaiKhoan maTaiKhoan;

  public NhanVien(int idNhanVien) {
    this.idNhanVien = idNhanVien;
  }

  public NhanVien(int idNhanVien, String tenNhanVien, String soDienThoaiNhanVien, TaiKhoan maTaiKhoan) {
    this.idNhanVien = idNhanVien;
    this.tenNhanVien = tenNhanVien;
    this.soDienThoaiNhanVien = soDienThoaiNhanVien;
    this.maTaiKhoan = maTaiKhoan;
  }

  public NhanVien(String tenNhanVien, String soDienThoaiNhanVien, TaiKhoan maTaiKhoan) {
    this.tenNhanVien = tenNhanVien;
    this.soDienThoaiNhanVien = soDienThoaiNhanVien;
    this.maTaiKhoan = maTaiKhoan;
  }

  public int getIdNhanVien() {
    return idNhanVien;
  }

  public void setIdNhanVien(int idNhanVien) {
    this.idNhanVien = idNhanVien;
  }

  public String getTenNhanVien() {
    return tenNhanVien;
  }

  public void setTenNhanVien(String tenNhanVien) {
    this.tenNhanVien = tenNhanVien;
  }

  public String getSoDienThoaiNhanVien() {
    return soDienThoaiNhanVien;
  }

  public void setSoDienThoaiNhanVien(String soDienThoaiNhanVien) {
    this.soDienThoaiNhanVien = soDienThoaiNhanVien;
  }

  public TaiKhoan getMaTaiKhoan() {
    return maTaiKhoan;
  }

  public void setMaTaiKhoan(TaiKhoan maTaiKhoan) {
    this.maTaiKhoan = maTaiKhoan;
  }
}