package com.cibertec.service;

public interface AuditService {
	void saveLog(
            String username,
            String action,
            Long productId);
}
