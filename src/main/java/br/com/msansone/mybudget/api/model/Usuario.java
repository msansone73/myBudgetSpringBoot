package br.com.msansone.mybudget.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
public class Usuario {


    @Id
    @GeneratedValue(generator = "Usuario_generator")
    @SequenceGenerator(
            name = "Usuario_generator",
            sequenceName = "Usuario_sequence",
            initialValue = 1000
    )
    private Long Id;

    @NotEmpty
    private String name;
    private String email;
    private String password;


    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<Role> roles;

    public Usuario() {
    }

    public Usuario(String name, String email, String password, List<Role> roles) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
