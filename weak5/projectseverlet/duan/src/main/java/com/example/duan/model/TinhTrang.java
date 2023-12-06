package com.example.duan.model;

public class TinhTrang {
  private int idTinhTrang;
  private String nameTinhTrang;

  public TinhTrang(int idTinhTrang, String nameTinhTrang) {
    this.idTinhTrang = idTinhTrang;
    this.nameTinhTrang = nameTinhTrang;
  }

  public TinhTrang(String nameTinhTrang) {
    this.nameTinhTrang = nameTinhTrang;
  }
}