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

    public Category() {
    }

    public Category(String name, CategoryType type) {
        this.name = name;
        this.type = type;

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

}
