package br.com.msansone.mybudget.api.controller;

import br.com.msansone.mybudget.api.model.Usuario;
import br.com.msansone.mybudget.api.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mybudget/security")
public class SecurityController {


    @Autowired
    SecurityService securityService;

    @GetMapping("/user")
    public List<Usuario> getAll(){
        return securityService.findAllUsuarios();
    }

    @PostMapping("/user/login/")
    public Usuario login(@RequestBody Usuario usuario){

        return securityService.login(usuario.getEmail(),usuario.getPassword());

    }

    @PostMapping(path = "/user/" )
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario insertUser(@RequestBody Usuario usuario){

        return securityService.inserir(usuario);

    }

    @PutMapping("/user/")
    public Usuario updateUser(@RequestBody Usuario usuario){

        return securityService.atualizar(usuario);

    }

}
