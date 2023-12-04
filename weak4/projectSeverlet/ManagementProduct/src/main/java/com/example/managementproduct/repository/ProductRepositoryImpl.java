package com.example.managementproduct.repository;

import com.example.managementproduct.model.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository{

  private static List<Product> productList = new ArrayList<>();
  static {
    productList.add(new Product("1","Xe Đạp",400000L,"xe đạp chạy nhanh nhất quê"));
    productList.add(new Product("2","Xe Máy",355055052L,"xe máy tên lửa chay nhanh"));
    productList.add(new Product("3","Xe Ô tô",34587623L,"xe oto chạy cực kì nhanh"));
  }

  @Override
  public List<Product> listProduct() {
    return productList;
  }

  @Override
  public Product findProductById(String id) {
    for (Product temp : productList){
      if (temp.getId().equals(id)){
        return temp;
      }
    }
    return null;
  }

  @Override
  public void updateProduct(String id, Product product) {
    for (Product temp : productList){
      if (temp.getId().equals(id)){
        temp.setNameProduct(product.getNameProduct());
        temp.setPrice(product.getPrice());
        temp.setDescription(product.getDescription());
        break;
      }
    }
  }

  @Override
  public void deleteProduct(String id) {
    for (Product temp : productList){
      if (temp.getId().equals(id)){
        productList.remove(temp);
        break;
      }
    }
  }

  @Override
  public void saveProduct(Product product) {
    productList.add(product);
  }

  @Override
  public List<Product> searchListProduct(String name) {
    List<Product> searList = new ArrayList<>();
    for (Product temp : productList ){
      if (name != null && temp.getNameProduct().toLowerCase().contains(name.toLowerCase())){
        searList.add(temp);
      }
    }
    return searList;
  }

}
