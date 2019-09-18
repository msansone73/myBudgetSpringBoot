package br.com.msansone.mybudget.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.msansone.mybudget.api.model.Despesa;
import br.com.msansone.mybudget.api.service.DespesaService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/mybudget/")
public class DespesaController {

	@Autowired
	DespesaService despesaService; 
	
	@GetMapping("/despesa")
	public List<Despesa> listar(){
		return despesaService.listarTudo();
	}
	
	@GetMapping("/despesa/{id}")
	public Despesa getBYId(@PathVariable Long id) {
		return despesaService.getDespesaById(id);
	}
	
	@PostMapping("/despesa")
	public Despesa insertDespesa(@RequestBody Despesa despesa) {
		return despesaService.inserir(despesa);
	}
	
	
}
