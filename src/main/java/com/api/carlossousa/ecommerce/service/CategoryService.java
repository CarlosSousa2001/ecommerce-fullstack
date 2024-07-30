package com.api.carlossousa.ecommerce.service;

import com.api.carlossousa.ecommerce.model.category.Category;
import com.api.carlossousa.ecommerce.model.category.CategoryDTO;
import com.api.carlossousa.ecommerce.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryDTO createCategoryService(CategoryDTO categoryDTO) {

        Category category = new Category();

        category.setCategory(categoryDTO.getCategory());

        var savedCategory  = categoryRepository.save(category);

        return  new CategoryDTO(savedCategory.getId(), savedCategory.getCategory());
    }

    @Transactional(readOnly = true)
    public CategoryDTO getCategoryByIdService(Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);

        if(categoryOptional.isEmpty()){
            throw new EntityNotFoundException();
        }

        return new CategoryDTO(categoryOptional.get().getId(), categoryOptional.get().getCategory());
    }

    @Transactional(readOnly = true)
    public List<CategoryDTO> getCategoryList(){
        List<Category> categoryList = categoryRepository.findAll();

        List<CategoryDTO> categoryDTOList = new ArrayList<>();

        for(Category item : categoryList){
            CategoryDTO categoryDTO = new CategoryDTO(item.getId() ,item.getCategory());
            categoryDTOList.add(categoryDTO);
        }

        return categoryDTOList;
    }

    public CategoryDTO updateCategoryService(Long id, CategoryDTO categoryDTO){

        Category categoryOptional = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());

        categoryOptional.setCategory(categoryDTO.getCategory());

        var savedCategory = categoryRepository.save(categoryOptional);

        return  new CategoryDTO(savedCategory.getId(), savedCategory.getCategory());
    }


    public void deleteCategoryByIdService(Long id){
        categoryRepository.deleteById(id);
    }
}
