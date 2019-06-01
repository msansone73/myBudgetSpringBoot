package br.com.msansone.mybudget.api.model;

import javax.persistence.*;

@Entity
public class SubCategory {

    @Id
    @GeneratedValue(generator = "subCategory_generator")
    @SequenceGenerator(
            name = "subCategory_generator",
            sequenceName = "subCategory_sequence",
            initialValue = 1000
    )
    private Long id;
    private String name;


    public SubCategory() {
    }

    public SubCategory(String name) {
        this.name = name;
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


}
