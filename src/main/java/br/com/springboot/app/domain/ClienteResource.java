package br.com.springboot.app.domain;

import org.springframework.hateoas.ResourceSupport;

public class ClienteResource extends ResourceSupport{
	
	private Long idCliente;
	private String nome;

	public ClienteResource(Cliente cliente) {
		super();
		this.idCliente = cliente.getId();
		this.nome = cliente.getNome();
	}

	
	
	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	

}
