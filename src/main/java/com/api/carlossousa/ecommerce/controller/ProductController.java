package com.api.carlossousa.ecommerce.controller;

import com.api.carlossousa.ecommerce.model.product.ProductDetailsDTO;
import com.api.carlossousa.ecommerce.model.product.ProductMinDTO;
import com.api.carlossousa.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/details/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDetailsDTO getDetailsProductById(@PathVariable Long id){
        return productService.getDetailsProductById(id);
    }
    @GetMapping
    public ResponseEntity<Page<ProductMinDTO>> findAllProducts(
            @RequestParam(name = "name", defaultValue = "") String name,
            @RequestParam(name = "category", defaultValue = "") String category,
            @PageableDefault(size = 20) Pageable pageable)
    {
        Page<ProductMinDTO> productMinDTOS = productService.findAllProducts(name, category, pageable);

        return ResponseEntity.ok(productMinDTOS);
    }
}
