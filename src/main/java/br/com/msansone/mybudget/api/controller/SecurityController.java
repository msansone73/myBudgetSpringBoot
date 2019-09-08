package br.com.msansone.mybudget.api.controller;

import br.com.msansone.mybudget.api.model.Usuario;
import br.com.msansone.mybudget.api.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/mybudget/security")
public class SecurityController {


	
    @Autowired
    SecurityService securityService;

    @GetMapping("/user")
    public List<Usuario> getAll(){

        return securityService.findAllUsuarios();
    }
    
    @GetMapping("/user/{id}")
    public Usuario getUserById(@PathVariable Long id) {
        return securityService.findUserById(id);
    }

    @PostMapping(path = "/user/" )
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario insertUser(@RequestBody Usuario usuario){

        return securityService.inserir(usuario);

    }

    @PutMapping("/user/")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Usuario updateUser(@RequestBody Usuario usuario){
        return securityService.atualizar(usuario);
    }

    @DeleteMapping("/user/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteUser(@PathVariable Long id){
        securityService.deleteUser(id);
    }

    @PostMapping("/user/login/")
    public Usuario login(@RequestBody Usuario usuario){
    	System.out.println("usuario.getEmail()="+usuario.getEmail());
       	System.out.println("usuario.getPassword()="+usuario.getPassword());
               return securityService.login(usuario.getEmail(),usuario.getPassword());
    }

}
