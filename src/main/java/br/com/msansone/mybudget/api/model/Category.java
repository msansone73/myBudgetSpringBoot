package br.com.msansone.mybudget.api.model;

import javax.persistence.*;

@Entity
public class Category {

    @Id
    @GeneratedValue(generator = "category_generator")
    @SequenceGenerator(
            name = "category_generator",
            sequenceName = "category_sequence",
            initialValue = 1000
    )
    private Long id;
    private  String name;
    @Enumerated(EnumType.STRING)
    private CategoryType type;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private SubCategory subCategory;

    public Category() {
    }

    public Category(String name, CategoryType type, SubCategory subCategory) {
        this.name = name;
        this.type = type;
        this.subCategory = subCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryType getType() {
        return type;
    }

    public void setType(CategoryType type) {
        this.type = type;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }
}
