package com.cibertec.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import com.cibertec.entity.ProductLock;

import jakarta.transaction.Transactional;

public interface ProductLockRepository extends JpaRepository<ProductLock, Long> {
	
	Optional<ProductLock> findByProductId(Long productId);
    
	boolean existsByProductId(Long productId);

    @Transactional
    @Modifying
    void deleteByProductId(Long productId);
    
}
