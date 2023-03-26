package com.huru.response;

import com.huru.dto.ProductDto;

public class GetProductResponse extends AbstractProductResponse {
	private ProductDto productDto;

	public ProductDto getProductDto() {
		return productDto;
	}

	public void setProductDto(ProductDto productDto) {
		this.productDto = productDto;
	}
}
