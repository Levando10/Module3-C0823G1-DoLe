package com.example.managementproduct.service;

import com.example.managementproduct.model.Product;
import com.example.managementproduct.repository.ProductRepository;
import com.example.managementproduct.repository.ProductRepositoryImpl;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService{
  private ProductRepository productRepository = new ProductRepositoryImpl();


  @Override
  public List<Product> listProduct() {
    return productRepository.listProduct();
  }

  @Override
  public Product findProductById(String id) {
    return productRepository.findProductById(id);
  }

  @Override
  public void updateProduct(String id, Product product) {
    productRepository.updateProduct(id,product);
  }

  @Override
  public void deleteProduct(String id) {
    productRepository.deleteProduct(id);
  }

  @Override
  public void saveProduct(Product product) {
    productRepository.saveProduct(product);
  }

  @Override
  public List<Product> searchListProduct(String name) {
    return productRepository.searchListProduct(name);
  }
}
