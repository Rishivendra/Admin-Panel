package com.huru.request;

import com.huru.dto.ProductDto;

public class GetProductRequest extends AbstractProductRequest {

	private ProductDto productDto;

	public ProductDto getProductDto() {
		return productDto;
	}

	public void setProductDto(ProductDto productDto) {
		this.productDto = productDto;
	}

}
