package br.com.msansone.mybudget.api.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Expense {

	@Id
	@GeneratedValue(generator = "expense_generator")
	@SequenceGenerator(
			name = "expense_generator",
			sequenceName = "expens_sequence",
			initialValue = 1000
	)
	private Long id;
	private String name;
	private Date data;
	private BigDecimal value;
	@ManyToOne(cascade = CascadeType.MERGE, fetch=FetchType.EAGER)
	private Usuario usuario;
	@ManyToOne(cascade = CascadeType.MERGE, fetch=FetchType.EAGER)
	private Category category;

	public Expense() {
	}

	public Expense(String name, Date data, BigDecimal value, Usuario usuario, Category category) {
		this.name = name;
		this.data = data;
		this.value = value;
		this.usuario = usuario;
		this.category = category;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
