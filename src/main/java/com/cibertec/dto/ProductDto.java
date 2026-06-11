package com.cibertec.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProductDto {
	
	private String name;
    private String description;
    private BigDecimal price;
    private Integer stock;
    
}
