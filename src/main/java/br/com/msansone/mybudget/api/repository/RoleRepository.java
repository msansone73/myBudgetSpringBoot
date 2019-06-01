package br.com.msansone.mybudget.api.repository;

import br.com.msansone.mybudget.api.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role,Long> {

    List<Role> findByName(String name);

}
