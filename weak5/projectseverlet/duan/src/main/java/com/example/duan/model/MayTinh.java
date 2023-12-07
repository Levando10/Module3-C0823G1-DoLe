package com.example.duan.model;

public class MayTinh {
  private int idMayTinh;
  private String tenMayTinh;
  private String ramMayTinh;
  private String chip;
  private String hang;
  private TinhTrang maTinhTrang;
  private boolean isDelete;
  private boolean status;
  public MayTinh(int idMayTinh){
    this.idMayTinh = idMayTinh;
  }

  public MayTinh(int idMayTinh, String tenMayTinh, String ramMayTinh, String chip, String hang, boolean isDelete, boolean status) {
    this.idMayTinh = idMayTinh;
    this.tenMayTinh = tenMayTinh;
    this.ramMayTinh = ramMayTinh;
    this.chip = chip;
    this.hang = hang;
    this.isDelete = isDelete;
    this.status = status;
  }

  public MayTinh(int idMayTinh, String tenMayTinh, String ramMayTinh, String chip, String hang, TinhTrang maTinhTrang, boolean isDelete,boolean status) {
    this.idMayTinh = idMayTinh;
    this.tenMayTinh = tenMayTinh;
    this.ramMayTinh = ramMayTinh;
    this.chip = chip;
    this.hang = hang;
    this.maTinhTrang = maTinhTrang;
    this.isDelete = isDelete;
    this.status = status;
  }

  public MayTinh(String tenMayTinh, String ramMayTinh, String chip, String hang, TinhTrang maTinhTrang, boolean isDelete, boolean status) {
    this.tenMayTinh = tenMayTinh;
    this.ramMayTinh = ramMayTinh;
    this.chip = chip;
    this.hang = hang;
    this.maTinhTrang = maTinhTrang;
    this.isDelete = isDelete;
    this.status = status;
  }

  public MayTinh(int idMayTinh, String ramMayTinh, String chip, String hang, TinhTrang maTinhTrang,
      boolean isDelete, boolean status) {
    this.idMayTinh = idMayTinh;
    this.ramMayTinh = ramMayTinh;
    this.chip = chip;
    this.hang = hang;
    this.maTinhTrang = maTinhTrang;
    this.isDelete = isDelete;
    this.status = status;
  }

  public MayTinh(int idMayTinh, String tenMayTinh, String ramMayTinh, String chip, String hang, Boolean isDelete) {
    this.idMayTinh = idMayTinh;
    this.tenMayTinh = tenMayTinh;
    this.ramMayTinh = ramMayTinh;
    this.chip = chip;
    this.hang = hang;
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

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
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