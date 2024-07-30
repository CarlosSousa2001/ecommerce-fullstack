package com.api.carlossousa.ecommerce.model.category;

public class CategoryDTO {


    private Long id;
    private String category;

    public CategoryDTO() {
    }

    public CategoryDTO(Long id, String category) {
        this.id = id;
        this.category = category;
    }

    public CategoryDTO(Category category) {
        this.id = category.getId();
        this.category = category.getCategory();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
