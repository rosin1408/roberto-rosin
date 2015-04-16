package br.com.rosin.robertorosin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rosin.robertorosin.model.Emprestimo;
import br.com.rosin.robertorosin.model.Livro;
import br.com.rosin.robertorosin.model.Pessoa;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
	
	List<Emprestimo> findByLivroAndDataHoraDevolucaoIsNull(Livro livro);
	
	List<Emprestimo> findByPessoaAndDataHoraDevolucaoIsNull(Pessoa pessoa);
}
