package com.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
