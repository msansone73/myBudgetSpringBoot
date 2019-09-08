package br.com.msansone.mybudget.api;

import br.com.msansone.mybudget.api.model.*;
import br.com.msansone.mybudget.api.repository.*;
import br.com.msansone.mybudget.api.service.SecurityRTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import sun.security.krb5.internal.ccache.CredentialsCache;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
@Transactional(propagation = Propagation.REQUIRED)
public class Initializer implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        createData();

    }

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ExpenseRepository expenseRepository;

    @Autowired
    SecurityRTService securityRTService;

    private void createData(){

        this.createSecurityData();
        this.createExpenseData();
        //this.testTransaction();

    }

    private void createExpenseData() {


        categoryRepository.save(new Category("Mercado",CategoryType.Expense));
        categoryRepository.save(new Category("Mercado",CategoryType.Expense));
        categoryRepository.save(new Category("Saúde",CategoryType.Expense));

        //Expense expense = new Expense("tasnque cheio",new Date(),new BigDecimal(20.2),userRepository.findById(3l).get(),categoryRepository.findById(7l).get());
        //expenseRepository.save(expense);

    }


    private void createSecurityData(){

        Role roleAdmin = new Role("Admin","Admin profile", StatusRole.ACTIVE);
        Role roleUser = new Role("Usuario","Usuario profile", StatusRole.ACTIVE);

        roleRepository.save(roleAdmin);
        roleRepository.save(roleUser);

        List<Role> roles= new ArrayList<>();
        roles.add(roleAdmin);
        roles.add(roleUser);

        userRepository.save(new Usuario("Marcio Sansone", "msansone@gmail.com", "123",roles));
        userRepository.save(new Usuario("José da Silva", "jose@gmail.com", "123", Arrays.asList(roleUser)));

    }

    private void testTransaction(){

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
