package com.example.managementproduct.model;

public class Product {
   private String id;
   private String nameProduct;
   private Long price;
   private String description;

   public Product(String id, String nameProduct, Long price, String description) {
      this.id = id;
      this.nameProduct = nameProduct;
      this.price = price;
      this.description = description;
   }

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getNameProduct() {
      return nameProduct;
   }

   public void setNameProduct(String nameProduct) {
      this.nameProduct = nameProduct;
   }

   public Long getPrice() {
      return price;
   }

   public void setPrice(Long price) {
      this.price = price;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   @Override
   public String toString() {
      return "Product{" +
          "id='" + id + '\'' +
          ", nameProduct='" + nameProduct + '\'' +
          ", price=" + price +
          ", description='" + description + '\'' +
          '}';
   }
}
