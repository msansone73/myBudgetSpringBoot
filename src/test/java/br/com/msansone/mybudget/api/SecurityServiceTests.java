package br.com.msansone.mybudget.api;

import br.com.msansone.mybudget.api.model.Usuario;
import br.com.msansone.mybudget.api.service.SecurityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SecurityServiceTests {

    @Autowired
    SecurityService securityService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void loadUserByIdTest() {

        Usuario usuario = securityService.findUserById(1000L);

        assertEquals("Marcio Sansone", usuario.getName());
        assertEquals("msansone@gmail.com", usuario.getEmail());

    }

    @Test
    public void CRUDUserTest() {

        Logger logger = Logger.getLogger(this.getClass().getName());
        logger.info("Starting CRUDUserTest ==============================");

        Long MyId;

        Usuario usuario = new Usuario("Jose Teste"
                ,"teste@gmail.com"
                ,"senhateste"
                ,null);

        // Insert test
        securityService.inserir(usuario);

        //login test
        Usuario usuarioLoad = securityService.login("teste@gmail.com"
                ,"senhateste");
        MyId = usuarioLoad.getId();
        assertEquals("Jose Teste", usuario.getName());
        assertEquals("teste@gmail.com", usuario.getEmail());

        //findById test
        usuarioLoad = securityService.findUserById(MyId);
        assertEquals("Jose Teste", usuario.getName());
        assertEquals("teste@gmail.com", usuario.getEmail());

        //Update test
        usuarioLoad.setEmail("teste2@gmail.com");
        usuarioLoad.setPassword("999");
        usuario = securityService.atualizar(usuarioLoad);

        usuarioLoad = securityService.findUserById(MyId);
        assertEquals("Jose Teste", usuario.getName());
        assertEquals("teste2@gmail.com", usuario.getEmail());
        assertEquals("999", usuario.getPassword());

        // delete Test
        securityService.deleteUser(MyId);
        usuarioLoad = securityService.findUserById(MyId);
        assertEquals(null,usuarioLoad);

        logger.info("CRUDUserTest finish. ==============================");


    }



}
