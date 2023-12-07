package com.example.duan.model;

public class DichVuDiKem {
  private int idDichVuDiKem;
  private String tenDichVuDiKem;
  private double giaDichVuDiKem;
  private LoaiDichVu maLoaiDichVu;

  public DichVuDiKem(int idDichVuDiKem, String tenDichVuDiKem, double giaDichVuDiKem, LoaiDichVu maLoaiDichVu) {
    this.idDichVuDiKem = idDichVuDiKem;
    this.tenDichVuDiKem = tenDichVuDiKem;
    this.giaDichVuDiKem = giaDichVuDiKem;
    this.maLoaiDichVu = maLoaiDichVu;
  }

  public DichVuDiKem(String tenDichVuDiKem, double giaDichVuDiKem, LoaiDichVu maLoaiDichVu) {
    this.tenDichVuDiKem = tenDichVuDiKem;
    this.giaDichVuDiKem = giaDichVuDiKem;
    this.maLoaiDichVu = maLoaiDichVu;
  }

  public int getIdDichVuDiKem() {
    return idDichVuDiKem;
  }

  public void setIdDichVuDiKem(int idDichVuDiKem) {
    this.idDichVuDiKem = idDichVuDiKem;
  }

  public String getTenDichVuDiKem() {
    return tenDichVuDiKem;
  }

  public void setTenDichVuDiKem(String tenDichVuDiKem) {
    this.tenDichVuDiKem = tenDichVuDiKem;
  }

  public double getGiaDichVuDiKem() {
    return giaDichVuDiKem;
  }

  public void setGiaDichVuDiKem(double giaDichVuDiKem) {
    this.giaDichVuDiKem = giaDichVuDiKem;
  }

  public LoaiDichVu getMaLoaiDichVu() {
    return maLoaiDichVu;
  }

  public void setMaLoaiDichVu(LoaiDichVu maLoaiDichVu) {
    this.maLoaiDichVu = maLoaiDichVu;
  }

  @Override
  public String toString() {
    return "DichVuDiKem{" +
        "idDichVuDiKem=" + idDichVuDiKem +
        ", tenDichVuDiKem='" + tenDichVuDiKem + '\'' +
        ", giaDichVuDiKem=" + giaDichVuDiKem +
        ", maLoaiDichVu=" + maLoaiDichVu +
        '}';
  }
}