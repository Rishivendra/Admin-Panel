package com.huru.services;

import java.util.List;

import com.huru.dto.ProductDto;
import com.huru.response.GetProductResponse;

public interface IProductService {

	public List<GetProductResponse> getAllProducts();

	public void deleteProductByID(long id);

	public GetProductResponse getProductById(long id);

	public GetProductResponse updateProduct(long id, ProductDto pDto);

	public GetProductResponse createProduct(ProductDto pDto);

}
