package br.com.msansone.mybudget.api.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Entity
public class Despesa {
	
	@Id
	@GeneratedValue(generator  = "despesa_generator")
	@SequenceGenerator(
			name = "despesa_generator",
			sequenceName = "despesa_sequence",
			initialValue = 1000
	)
	private Long id;
	@NotNull
	private String nome;
	private String descricao;
	private String local;
	@NotNull
	private LocalDate data;
	@NotNull
	private float valor;
	@NotNull
	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	private Usuario usuario;

	public Despesa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Despesa(@NotNull String name, String descricao, String local, @NotNull LocalDate data, @NotNull float valor,
			@NotNull Usuario usuario) {
		super();
		this.nome = name;
		this.descricao = descricao;
		this.local = local;
		this.data = data;
		this.valor = valor;
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return nome;
	}

	public void setName(String name) {
		this.nome = name;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
	
	

}
