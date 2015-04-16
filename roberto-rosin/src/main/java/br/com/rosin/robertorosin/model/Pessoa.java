package br.com.rosin.robertorosin.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="testedsl.pessoa")
public class Pessoa implements Serializable {
	
	private static final long serialVersionUID = -894288862515384111L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idpessoa")
	private Long codigo;
	
	@Column(length=100)
	private String nome;
	
	@Column(name="datanascimento")
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	private String cpf;

	public Pessoa() {
	}

	public Pessoa(Long codigo, String nome, Date dataNascimento, String cpf) {
		this.codigo = codigo;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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
		Pessoa other = (Pessoa) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
