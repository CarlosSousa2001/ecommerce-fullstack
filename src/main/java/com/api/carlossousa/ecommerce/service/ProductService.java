package com.api.carlossousa.ecommerce.service;

import com.api.carlossousa.ecommerce.model.product.Product;
import com.api.carlossousa.ecommerce.model.product.ProductDetailsDTO;
import com.api.carlossousa.ecommerce.model.product.ProductMinDTO;
import com.api.carlossousa.ecommerce.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional(readOnly = true)
    public ProductDetailsDTO getDetailsProductById(Long id){
        Product product = productRepository.findByIdWithDetails(id).orElseThrow(() -> new EntityNotFoundException("teste"));

        return new ProductDetailsDTO(product);

    }
    @Transactional(readOnly = true)
    public Page<ProductMinDTO> findAllProducts(String name, String category, Pageable pageable) {
        return productRepository.searchByNameProduct(name, category, pageable);
    }
}
