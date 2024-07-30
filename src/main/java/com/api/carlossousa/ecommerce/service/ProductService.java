package com.api.carlossousa.ecommerce.service;

import com.api.carlossousa.ecommerce.model.attribute.Attribute;
import com.api.carlossousa.ecommerce.model.attribute.AttributeDTO;
import com.api.carlossousa.ecommerce.model.attribute.AttributeValue;
import com.api.carlossousa.ecommerce.model.category.Category;
import com.api.carlossousa.ecommerce.model.product.Product;
import com.api.carlossousa.ecommerce.model.product.ProductDetailsDTO;
import com.api.carlossousa.ecommerce.model.product.ProductMinDTO;
import com.api.carlossousa.ecommerce.model.product.ProductRequestDTO;
import com.api.carlossousa.ecommerce.repository.AttributeRepository;
import com.api.carlossousa.ecommerce.repository.AttributeValueRepository;
import com.api.carlossousa.ecommerce.repository.CategoryRepository;
import com.api.carlossousa.ecommerce.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final static Logger logger = LoggerFactory.getLogger(ProductService.class);

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final AttributeRepository attributeRepository;
    private final  AttributeValueRepository attributeValueRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository, AttributeRepository attributeRepository, AttributeValueRepository attributeValueRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.attributeRepository = attributeRepository;
        this.attributeValueRepository = attributeValueRepository;
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


    @Transactional
    public ProductDetailsDTO createProduct(ProductRequestDTO request){

        if(request.getTags().size() > 3){
            logger.warn("Quantidade de tags superior a três");
        }

        List<Category> categories = validateCategories(request.getCategoryIds());

        Product product = new Product();

        if(request.getAttributes() != null){
            logger.warn("Preciso verificar se ja existe dentro da lista");
            List<AttributeValue> attributeValues = insertProductAttributes(product, request.getAttributes());
            product.getAttributes().addAll(attributeValues);
        }

        product.setProductOwner("Carlos Sousa - authenticated");
        product.setTitle(request.getTitle());
        product.setShortDescription(request.getShortDescription());
        product.setLongDescription(request.getLongDescription());
        product.setPrice(request.getPrice());
        product.setQuantity(request.getQuantity());
        product.setStatus(true);
        product.setCod(request.getCod());
        product.setPhotoUrl(request.getPhotoUrl());
        product.getCategories().addAll(categories);
        product.setTags(request.getTags());

        return new ProductDetailsDTO(product);
    }

    private List<Category> validateCategories(List<Long> categoriesID){

        List<Category> categories = categoryRepository.findAllById(categoriesID);

        if(categoriesID.size() != categories.size()){
            logger.warn("Quantidade de categories id diferertes da classe category");
        }

        return categories;
    }

    private List<AttributeValue> insertProductAttributes(Product product, List<AttributeDTO> dto) {

        List<AttributeValue> attributeValues = dto.stream()
                .map(attributeDTO -> createAttributeValue(product, attributeDTO))
                .collect(Collectors.toList());

        return attributeValues;
    }

    private AttributeValue createAttributeValue(Product product, AttributeDTO attributeDTO) {
        // Encontra ou cria o atributo correspondente
        Attribute attribute = attributeRepository.findByName(attributeDTO.getName())
                .orElseGet(() -> {
                    Attribute newAttribute = new Attribute();
                    newAttribute.setName(attributeDTO.getName());
                    return attributeRepository.save(newAttribute);
                });

        // Cria e retorna o AttributeValue
        AttributeValue attributeValue = new AttributeValue();
        attributeValue.setProduct(product);
        attributeValue.setAttribute(attribute);
        attributeValue.setValue(attributeDTO.getValue());
        return attributeValue;
    }
}
