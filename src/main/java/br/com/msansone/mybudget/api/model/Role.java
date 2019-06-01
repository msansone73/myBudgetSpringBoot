package br.com.msansone.mybudget.api.model;

import javax.persistence.*;

@Entity
public class Role {

    @Id
    @GeneratedValue(generator = "role_generator")
    @SequenceGenerator(
            name = "role_generator",
            sequenceName = "role_sequence",
            initialValue = 1000
    )
    private Long id;

    private String name;
    private String description;

    @Enumerated(EnumType.STRING)
    private StatusRole status;

    public Role() {
    }

    public Role(String name, String description, StatusRole status) {
        this.name = name;
        this.description = description;
        this.status= status;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StatusRole getStatus() {
        return status;
    }

    public void setStatus(StatusRole status) {
        this.status = status;
    }
}
