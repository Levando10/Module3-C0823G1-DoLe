package com.example.duan.model;

public class TaiKhoan {
  private int idTaiKhoan;
  private String taiKhoan;
  private String matKhau;
  private String loaiTaiKhoan;

  public TaiKhoan(int idTaiKhoan, String taiKhoan, String matKhau, String loaiTaiKhoan) {
    this.idTaiKhoan = idTaiKhoan;
    this.taiKhoan = taiKhoan;
    this.matKhau = matKhau;
    this.loaiTaiKhoan = loaiTaiKhoan;
  }

  public TaiKhoan(String taiKhoan, String matKhau, String loaiTaiKhoan) {
    this.taiKhoan = taiKhoan;
    this.matKhau = matKhau;
    this.loaiTaiKhoan = loaiTaiKhoan;
  }

  public int getIdTaiKhoan() {
    return idTaiKhoan;
  }

  public void setIdTaiKhoan(int idTaiKhoan) {
    this.idTaiKhoan = idTaiKhoan;
  }

  public String getTaiKhoan() {
    return taiKhoan;
  }

  public void setTaiKhoan(String taiKhoan) {
    this.taiKhoan = taiKhoan;
  }

  public String getMatKhau() {
    return matKhau;
  }

  public void setMatKhau(String matKhau) {
    this.matKhau = matKhau;
  }

  public String getLoaiTaiKhoan() {
    return loaiTaiKhoan;
  }

  public void setLoaiTaiKhoan(String loaiTaiKhoan) {
    this.loaiTaiKhoan = loaiTaiKhoan;
  }
}