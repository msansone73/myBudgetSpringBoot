package br.com.msansone.mybudget.api.controller;

import br.com.msansone.mybudget.api.model.Expense;
import br.com.msansone.mybudget.api.service.ExpenseService;
import br.com.msansone.mybudget.api.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mybudget/")
public class ExpenseController {

    @Autowired
    ExpenseService expenseService;

    @Autowired
    SecurityService securityService;


    @PostMapping( path = "/expense", consumes = "application/json" , produces = "application/json")
    public Expense addExpense(@RequestBody Expense expense){

        return expenseService.AdicionarDespesa(expense);
    }

    @GetMapping("/expense/{id}")
    public Optional<Expense> buscarPorId(@PathVariable Long id){
        return expenseService.listar(id);
    }

    @GetMapping("/expense/")
    public List<Expense> buscarTudo(){
        return expenseService.listarTudo();
    }




    @GetMapping("/carga/")
    public String carga(){
        securityService.testTransaction();

        return "OK";
    }


}
