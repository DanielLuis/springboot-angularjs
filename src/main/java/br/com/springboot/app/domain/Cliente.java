package br.com.springboot.app.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Classe Cliente.
 */
@Entity
@Table(name = "TB_CLIENTE")
public class Cliente implements Serializable {

	@Transient
	private static final long serialVersionUID = 8184977682804322708L;

	

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CD_CLIENTE")
    private Long id;

    @NotNull(message = "erro.cliente.nome.obrigatorio")
    @Size(max = 2, message = "erro.cliente.nome.tamanho")
    @Column(name = "NM_CLIENTE")
    private String nome;


    public Cliente() {
    	super();
	}

    public Cliente(Long id,String nome) {
    	super();
    	this.id = id;
    	this.nome = nome;
	}
    public Cliente(String nome) {
    	super();
    	this.nome = nome;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


    public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Cliente cliente = (Cliente) o;

        if (!Objects.equals(id, cliente.id))
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", descricao='" + nome + "'}'";
    }
}
