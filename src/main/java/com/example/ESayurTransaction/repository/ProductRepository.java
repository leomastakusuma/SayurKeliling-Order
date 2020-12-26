package com.example.ESayurTransaction.repository;

import com.example.ESayurTransaction.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long>,ProductRepositoryCustom {


}
