package com.huru.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huru.dto.ProductDto;
import com.huru.entity.ProductEntity;

import com.huru.repos.IProductRepository;
import com.huru.response.GetProductResponse;
import com.huru.services.IProductService;
import com.huru.utility.Converter;
import com.huru.utility.ProductValidator;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	IProductRepository productRepository;

	public ProductServiceImpl(IProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public GetProductResponse createProduct(ProductDto pDto) {

		ProductValidator.validateCreateProduct(pDto);

		ProductEntity product = Converter.toEntity(pDto);
		ProductEntity savedProduct = productRepository.save(product);
		ProductDto productDto = Converter.toProductDto(savedProduct);
		GetProductResponse productResponse = new GetProductResponse();
		productResponse.setProductDto(productDto);
		return productResponse;
	}

	@Override

	public GetProductResponse updateProduct(long id, ProductDto pDto) {

		ProductValidator.validateUpdateProduct(id, pDto, productRepository);
		ProductEntity existingProduct = productRepository.findById(id).get();
		ProductEntity saveProduct = Converter.toExistingProduct(existingProduct, id, pDto);
		ProductEntity updatedProduct = productRepository.save(saveProduct);
		ProductDto productDto = Converter.toProductDto(updatedProduct);
		GetProductResponse productResponse = new GetProductResponse();
		productResponse.setProductDto(productDto);
		return productResponse;
	}

	@Override
	public List<GetProductResponse> getAllProducts() {
		List<ProductEntity> products = productRepository.findAll();
		List<GetProductResponse> responses = new ArrayList<>();
		for (ProductEntity product : products) {
			ProductDto productDto = Converter.toProductDto(product);
			GetProductResponse response = new GetProductResponse();
			response.setProductDto(productDto);
			responses.add(response);
		}
		return responses;
	}

	@Override
	public void deleteProductByID(long id) {
		ProductValidator.validateDeleteProduct(id, productRepository);
		productRepository.deleteById(id);
	}

	@Override
	public GetProductResponse getProductById(long id) {
		ProductValidator.validateGetProductById(id, productRepository);
		ProductEntity product = productRepository.findById(id).get();
		ProductDto productDto = Converter.toProductDto(product);
		GetProductResponse productResponse = new GetProductResponse();
		productResponse.setProductDto(productDto);
		return productResponse;

	}

}
