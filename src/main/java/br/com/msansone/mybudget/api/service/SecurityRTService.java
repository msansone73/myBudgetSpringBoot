package br.com.msansone.mybudget.api.service;

import br.com.msansone.mybudget.api.model.Usuario;
import br.com.msansone.mybudget.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class SecurityRTService {

    @Autowired
    UserRepository userRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insertNRUser(Usuario usuario){

        userRepository.save(usuario);

    }
}
