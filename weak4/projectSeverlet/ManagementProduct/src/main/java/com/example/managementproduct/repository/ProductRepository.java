package com.example.managementproduct.repository;

import com.example.managementproduct.model.Product;
import java.util.List;

public interface ProductRepository {
  List<Product> listProduct();

  Product findProductById(String id);

  void updateProduct(String id, Product product);

  void deleteProduct(String id);

  void saveProduct(Product product);

  List<Product> searchListProduct(String name);
}
