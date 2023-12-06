package com.example.duan.model;

public class MayTinh {
  private int idMayTinh;
  private String tenMayTinh;
  private String ramMayTinh;
  private String chip;
  private String hang;
  private TinhTrang maTinhTrang;
  private boolean isDelete;
  public MayTinh(int idMayTinh){
    this.idMayTinh = idMayTinh;
  }

  public MayTinh(int idMayTinh, String tenMayTinh, String ramMayTinh, String chip, String hang, boolean isDelete) {
    this.idMayTinh = idMayTinh;
    this.tenMayTinh = tenMayTinh;
    this.ramMayTinh = ramMayTinh;
    this.chip = chip;
    this.hang = hang;
    this.isDelete = isDelete;
  }

  public MayTinh(int idMayTinh, String tenMayTinh, String ramMayTinh, String chip, String hang, TinhTrang maTinhTrang, boolean isDelete) {
    this.idMayTinh = idMayTinh;
    this.tenMayTinh = tenMayTinh;
    this.ramMayTinh = ramMayTinh;
    this.chip = chip;
    this.hang = hang;
    this.maTinhTrang = maTinhTrang;
    this.isDelete = isDelete;
  }

  public MayTinh(String tenMayTinh, String ramMayTinh, String chip, String hang, TinhTrang maTinhTrang, boolean isDelete) {
    this.tenMayTinh = tenMayTinh;
    this.ramMayTinh = ramMayTinh;
    this.chip = chip;
    this.hang = hang;
    this.maTinhTrang = maTinhTrang;
    this.isDelete = isDelete;
  }

  public int getIdMayTinh() {
    return idMayTinh;
  }

  public void setIdMayTinh(int idMayTinh) {
    this.idMayTinh = idMayTinh;
  }

  public String getTenMayTinh() {
    return tenMayTinh;
  }

  public void setTenMayTinh(String tenMayTinh) {
    this.tenMayTinh = tenMayTinh;
  }

  public String getRamMayTinh() {
    return ramMayTinh;
  }

  public void setRamMayTinh(String ramMayTinh) {
    this.ramMayTinh = ramMayTinh;
  }

  public String getChip() {
    return chip;
  }

  public void setChip(String chip) {
    this.chip = chip;
  }

  public String getHang() {
    return hang;
  }

  public void setHang(String hang) {
    this.hang = hang;
  }

  public TinhTrang getMaTinhTrang() {
    return maTinhTrang;
  }

  public void setMaTinhTrang(TinhTrang maTinhTrang) {
    this.maTinhTrang = maTinhTrang;
  }

  public boolean isDelete() {
    return isDelete;
  }

  public void setDelete(boolean delete) {
    isDelete = delete;
  }

  @Override
  public String toString() {
    return "MayTinh{" +
        "idMayTinh=" + idMayTinh +
        ", tenMayTinh='" + tenMayTinh + '\'' +
        ", ramMayTinh='" + ramMayTinh + '\'' +
        ", chip='" + chip + '\'' +
        ", hang='" + hang + '\'' +
        ", isDelete=" + isDelete +
        '}';
  }
}