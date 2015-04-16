package br.com.rosin.robertorosin.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="testedsl.emprestimo")
public class Emprestimo implements Serializable {
	
	private static final long serialVersionUID = 6603198667911463305L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idemprestimo")
	private Long codigo;
	
	@Column(name="datahoradevolucao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHoraDevolucao;
	
	@Column(name="dataemprestimo")
	@Temporal(TemporalType.DATE)
	private Date dataEmprestimo;
	
	@ManyToOne
	@JoinColumn(name="idpessoa")
	private Pessoa pessoa;
	
	@ManyToOne
	@JoinColumn(name="idlivro")
	private Livro livro;
	
	public Emprestimo(Long codigo, Date dataEmprestimo, Pessoa pessoa, Livro livro, Date dataHoraDevolucao) {
		this.codigo = codigo;
		this.dataEmprestimo = dataEmprestimo;
		this.pessoa = pessoa;
		this.livro = livro;
		this.dataHoraDevolucao = dataHoraDevolucao;
	}

	public Emprestimo() {
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Date getDataHoraDevolucao() {
		return dataHoraDevolucao;
	}

	public void setDataHoraDevolucao(Date dataHoraDevolucao) {
		this.dataHoraDevolucao = dataHoraDevolucao;
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
		Emprestimo other = (Emprestimo) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
}
