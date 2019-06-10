package br.com.msansone.mybudget.api.controller;

import br.com.msansone.mybudget.api.model.Usuario;
import br.com.msansone.mybudget.api.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
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

}
