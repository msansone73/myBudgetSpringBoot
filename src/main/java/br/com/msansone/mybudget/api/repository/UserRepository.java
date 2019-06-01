package br.com.msansone.mybudget.api.repository;

import br.com.msansone.mybudget.api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Usuario,Long> {
}
