package com.cibertec.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findByActiveTrue();
	Optional<Product> findByIdAndActiveTrue(Long id);
}
