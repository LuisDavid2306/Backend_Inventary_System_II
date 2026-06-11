package com.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.entity.AuditLog;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long>{
}
