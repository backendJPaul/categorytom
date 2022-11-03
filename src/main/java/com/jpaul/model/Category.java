package com.jpaul.model;

public class Category {
    private Integer idCategory;
    private String name;

    public Category(Integer idCategory, String name) {
        this.idCategory = idCategory;
        this.name = name;
    }

    public Category() {
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
