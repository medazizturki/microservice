package com.example.sportyspace.repository;

import com.example.sportyspace.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProductRepository extends JpaRepository<Product, Integer>{
}
