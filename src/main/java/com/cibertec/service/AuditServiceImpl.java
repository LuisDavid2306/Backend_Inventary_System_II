package com.cibertec.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.cibertec.entity.AuditLog;
import com.cibertec.repository.AuditLogRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuditServiceImpl implements AuditService {
	
	private final AuditLogRepository repository;

    @Override
    public void saveLog(
            String username,
            String action,
            Long productId) {

        AuditLog log = AuditLog.builder()
                .username(username)
                .action(action)
                .productId(productId)
                .createdAt(LocalDateTime.now())
                .build();

        repository.save(log);
    }
}
