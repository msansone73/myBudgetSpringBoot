package br.com.msansone.mybudget.api.service;


import br.com.msansone.mybudget.api.exception.LoginException;
import br.com.msansone.mybudget.api.model.Role;
import br.com.msansone.mybudget.api.model.Usuario;
import br.com.msansone.mybudget.api.repository.RoleRepository;
import br.com.msansone.mybudget.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class SecurityService {


    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    SecurityRTService securityRTService;


    public List<Usuario> findAllUsuarios() {

        return userRepository.findAll();
    }

    public Usuario inserir(Usuario usuario){
        return this.save(usuario);
    }

    public Usuario atualizar(Usuario usuario) {

        return this.save(usuario);
    }

    public Usuario findUserById(Long id) {
        Optional<Usuario> usuario = userRepository.findById(id);
        return usuario.isPresent()?usuario.get():null;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    private Usuario save(Usuario usuario){

        return userRepository.save(usuario);
    }
    public Usuario login(String email, String password){
        Usuario user = userRepository.findByEmail(email);
        if (user!=null && user.getPassword().equals(password)){
            return user;
        }else{
        	return null;
            //throw new LoginException();
        }
    }

    public void testTransaction(){

        List<Role> roleUser = roleRepository.findByName("User");

        userRepository.save(new Usuario("usuario1", "msansone@gmail.com", "123",roleUser));
        userRepository.save(new Usuario("usuario2", "msansone@gmail.com", "123",roleUser));
        userRepository.save(new Usuario("usuario3", "msansone@gmail.com", "123",roleUser));
        userRepository.save(new Usuario("usuario4", "msansone@gmail.com", "123",roleUser));

        securityRTService.insertNRUser(new Usuario("usuario4.5","msansone@gmail.com", "123",roleUser));

        userRepository.save(new Usuario("usuario5", "msansone@gmail.com", "123",roleUser));
        userRepository.save(new Usuario("", "msansone@gmail.com", "123",roleUser));
        userRepository.save(new Usuario("usuario7", "msansone@gmail.com", "123",roleUser));

    }

}
