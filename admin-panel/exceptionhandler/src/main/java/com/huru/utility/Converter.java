package com.huru.utility;

import com.huru.dto.ProductDto;
import com.huru.dto.UserDto;
import com.huru.entity.ProductEntity;
import com.huru.entity.UserEntity;

public class Converter {

	public static UserDto toUserDto(UserEntity user) {
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setEmail(user.getEmail());
		userDto.setPassword(user.getPassword());
		userDto.setGender(user.getGender());
		userDto.setMobno(user.getMobno());
		return userDto;
	}

	public static UserEntity toUserEntity(UserDto user) {
		UserEntity saveUser = new UserEntity();
		saveUser.setId(user.getId());
		saveUser.setName(user.getName());
		saveUser.setEmail(user.getEmail());
		saveUser.setPassword(user.getPassword());
		saveUser.setGender(user.getGender());
		saveUser.setMobno(user.getMobno());
		return saveUser;
	}

	public static ProductDto toProductDto(ProductEntity product) {
		ProductDto productDto = new ProductDto();
		productDto.setId(product.getId());
		productDto.setName(product.getName());
		productDto.setDescription(product.getDescription());
		productDto.setImageUrl(product.getImageUrl());
		productDto.setQuantity(product.getQuantity());
		productDto.setAmount(product.getAmount());
		productDto.setTermsAndConditions(product.getTermsAndConditions());
		return productDto;
	}

	public static ProductEntity toEntity(ProductDto productDTO) {
		ProductEntity product = new ProductEntity();
		product.setId(productDTO.getId());
		product.setName(productDTO.getName());
		product.setDescription(productDTO.getDescription());
		product.setImageUrl(productDTO.getImageUrl());
		product.setAmount(productDTO.getAmount());
		product.setQuantity(productDTO.getQuantity());
		product.setTermsAndConditions(productDTO.getTermsAndConditions());
		return product;
	}

	public static ProductEntity toExistingProduct(ProductEntity existingProduct, long id, ProductDto pDto) {
		existingProduct.setName(pDto.getName());
		existingProduct.setDescription(pDto.getDescription());
		existingProduct.setImageUrl(pDto.getImageUrl());
		existingProduct.setAmount(pDto.getAmount());
		existingProduct.setQuantity(pDto.getQuantity());
		existingProduct.setTermsAndConditions(pDto.getTermsAndConditions());
		return existingProduct;
	}

}
