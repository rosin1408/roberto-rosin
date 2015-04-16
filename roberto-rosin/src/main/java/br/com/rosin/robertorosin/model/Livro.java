package br.com.rosin.robertorosin.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="testedsl.livro")
public class Livro implements Serializable {
	
	private static final long serialVersionUID = 4277192388577228474L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idlivro")
	private Long codigo;
	
	@NotEmpty(message="Nome obrigatório")
	@Column(length=100)
	private String nome;
	
	@NotEmpty(message="Escritor obrigatório")
	@Column(length=100)
	private String escritor;
	
	@NotNull(message="Ano Edição obrigatório")
	@Column(name="anoedicao")
	private Integer anoEdicao;
	
	@NotNull(message="Classificacao obrigatório")
	private Integer classificacao;

	public Livro() {
	}

	public Livro(Long codigo, String nome, String escritor, Integer anoEdicao, Integer classificacao) {
		this.codigo = codigo;
		this.nome = nome;
		this.escritor = escritor;
		this.anoEdicao = anoEdicao;
		this.classificacao = classificacao;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEscritor() {
		return escritor;
	}

	public void setEscritor(String escritor) {
		this.escritor = escritor;
	}

	public Integer getAnoEdicao() {
		return anoEdicao;
	}

	public void setAnoEdicao(Integer anoEdicao) {
		this.anoEdicao = anoEdicao;
	}

	public Integer getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(Integer classificacao) {
		this.classificacao = classificacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
