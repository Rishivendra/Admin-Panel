package com.huru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.huru.api.response.ApiResponse;
import com.huru.constraints.Constraints;

import com.huru.request.GetProductRequest;
import com.huru.response.GetProductResponse;
import com.huru.services.IProductService;

@RestController
public class ProductController {
	@Autowired
	private IProductService productService;

	@GetMapping(Constraints.ALL_PRODUCTS)

//	public ResponseEntity<List<GetProductResponse>> getAllProducts() {
//		List<GetProductResponse> productResponse = productService.getAllProducts();
//		return ResponseEntity.ok(productResponse);
//	}
	public ApiResponse<List<GetProductResponse>> getAllProducts() {
		List<GetProductResponse> productResponse = productService.getAllProducts();
		return new ApiResponse<>(HttpStatus.OK.value(), Constraints.PRODUCT_RETRIEVED, productResponse);
	}

	@GetMapping(Constraints.PRODUCT_BY_ID)
	public ApiResponse<GetProductResponse> getProductByID(@PathVariable long id) {
		GetProductResponse productResponse = productService.getProductById(id);
		return new ApiResponse<>(HttpStatus.OK.value(), Constraints.PRODUCT_RETRIEVED, productResponse);
	}

	@PostMapping(Constraints.ALL_PRODUCTS)
	public ApiResponse<GetProductResponse> createCourse(@RequestBody GetProductRequest productRequest) {
		GetProductResponse productResponse = productService.createProduct(productRequest.getProductDto());
		return new ApiResponse<>(HttpStatus.OK.value(), Constraints.PRODUCT_CREATED, productResponse);
	}

	@PutMapping(Constraints.PRODUCT_BY_ID)
	public ApiResponse<?> updateProducts(@PathVariable long id, @RequestBody GetProductRequest productRequest) {
		GetProductResponse productResponse = productService.updateProduct(id, productRequest.getProductDto());
		return new ApiResponse<>(HttpStatus.OK.value(), Constraints.PRODUCT_UPDATED, productResponse);
	}

	@DeleteMapping(Constraints.PRODUCT_BY_ID)
	public ApiResponse<String> deleteProduct(@PathVariable long id) {
		productService.deleteProductByID(id);
		return new ApiResponse<>(HttpStatus.OK.value(), Constraints.PRODUCT_DELETED, null);
	}

}
