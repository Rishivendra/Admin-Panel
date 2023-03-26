package com.huru.utility;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

import com.huru.dto.ProductDto;

import com.huru.exception.NotFoundException;

import com.huru.exception.ErrorCode;

import com.huru.exception.InvalidFieldException;
import com.huru.repos.IProductRepository;

public class ProductValidator {

	public static void validateCreateProduct(ProductDto productDto) {

		if (StringUtils.isEmpty(productDto.getName())) {
			throw new InvalidFieldException(ErrorCode.EMPTY_OR_NULL_NAME);
		}

		if (StringUtils.isEmpty(productDto.getDescription())) {
			throw new InvalidFieldException(ErrorCode.EMPTY_OR_NULL_DESCRIPTION);
		}

		if (StringUtils.isEmpty(productDto.getImageUrl())) {
			throw new InvalidFieldException(ErrorCode.EMPTY_OR_NULL_IMAGE);
		}

		if (productDto.getQuantity() <= 0) {
			throw new InvalidFieldException(ErrorCode.QUANTITY_NOT_ZERO);
		}

		if (StringUtils.isEmpty(productDto.getTermsAndConditions())) {
			throw new InvalidFieldException(ErrorCode.EMPTY_OR_NULL_TERMS_AND_CONDITIONS);
		}

	}

	public static void validateUpdateProduct(long id, ProductDto pDto, IProductRepository productRepository) {
		if (Objects.isNull(productRepository.findById(id).orElse(null))) {
			throw new InvalidFieldException(ErrorCode.INVALID_PRODUCT_REQUEST);
		}

		if (StringUtils.isEmpty(pDto.getName())) {
			throw new InvalidFieldException(ErrorCode.EMPTY_OR_NULL_NAME);
		}

		if (StringUtils.isEmpty(pDto.getDescription())) {
			throw new InvalidFieldException(ErrorCode.EMPTY_OR_NULL_DESCRIPTION);
		}
		if (StringUtils.isEmpty(pDto.getImageUrl())) {
			throw new InvalidFieldException(ErrorCode.EMPTY_OR_NULL_IMAGE);
		}

		if (pDto.getQuantity() <= 0) {
			throw new InvalidFieldException(ErrorCode.QUANTITY_NOT_ZERO);
		}

		if (StringUtils.isEmpty(pDto.getTermsAndConditions())) {
			throw new InvalidFieldException(ErrorCode.EMPTY_OR_NULL_TERMS_AND_CONDITIONS);
		}

	}

	public static void validateDeleteProduct(long id, IProductRepository productRepository) {
		if (productRepository.findById(id).isEmpty()) {
			throw new InvalidFieldException(ErrorCode.INVALID_PRODUCT_REQUEST);
		}
	}

	public static void validateGetProductById(long id, IProductRepository productRepository) {

		if (!productRepository.existsById(id)) {
			throw new NotFoundException(ErrorCode.PRODUCT_NOT_FOUND);
		}
	}
}
