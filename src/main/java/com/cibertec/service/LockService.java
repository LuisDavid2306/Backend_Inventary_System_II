package com.cibertec.service;

public interface LockService {
	
	void lockProduct(Long productId, String username);
    void unlockProduct(Long productId);
    boolean isLocked(Long productId);
    String getLockedBy(Long productId);
    
}
