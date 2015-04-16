package br.com.rosin.robertorosin.service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import br.com.rosin.robertorosin.model.Emprestimo;
import br.com.rosin.robertorosin.model.Livro;
import br.com.rosin.robertorosin.model.Pessoa;
import br.com.rosin.robertorosin.repository.EmprestimoRepository;
import br.com.rosin.robertorosin.repository.LivroRepository;
import br.com.rosin.robertorosin.repository.PessoaRepository;

@Service
public class EmprestimoService {
	
	@Autowired
	private EmprestimoRepository repository;
	
	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	public void salvar(Emprestimo emprestimo) {
		if (emprestimo.getDataEmprestimo() == null) {
			emprestimo.setDataEmprestimo(new Date());
		}
		
		repository.save(emprestimo);
	}

	public Emprestimo find(Long codigo) {
		return repository.findOne(codigo);
	}

	public List<Emprestimo> findAll() {
		return repository.findAll();
	}

	public void delete(Long codigo) {
		repository.delete(codigo);
	}

	public void devolver(Long codigo) {
		Emprestimo emprestimo = repository.findOne(codigo);
		emprestimo.setDataHoraDevolucao(new Date());
		repository.save(emprestimo);
	}
	
	public boolean isValid(Emprestimo emprestimo, Model model) {
		Livro livro = livroRepository.findOne(emprestimo.getLivro().getCodigo());
		
		List<Emprestimo> emprestimosLivro = repository.findByLivroAndDataHoraDevolucaoIsNull(livro);
		if (emprestimosLivro.size() > 0) {
			model.addAttribute("mensagem", "O Livro está emprestado para " + emprestimosLivro.get(0).getPessoa().getNome());
			return false;
		}
		
		Pessoa pessoa = pessoaRepository.findOne(emprestimo.getPessoa().getCodigo());
		List<Emprestimo> emprestimosPessoa = repository.findByPessoaAndDataHoraDevolucaoIsNull(pessoa);
		if (emprestimosPessoa.size() >= 2) {
			model.addAttribute("mensagem", "Essa pessoa já possui dois livros emprestados");
			return false;
		}
		
		if (calculaIdade(pessoa.getDataNascimento()) < livro.getClassificacao()) {
			model.addAttribute("mensagem", "A idade da pessoa está abaixo da classificação do livro");
			return false;
		}
		
		
		return true;
	}
	
	public int calculaIdade(Date dataNasc) {
		Calendar dataNascimento = new GregorianCalendar();
		dataNascimento.setTime(dataNasc);
		
		Calendar hoje = Calendar.getInstance();
		
		int idade = hoje.get(Calendar.YEAR) - dataNascimento.get(Calendar.YEAR);

		dataNascimento.add(Calendar.YEAR, idade);

		if (hoje.before(dataNascimento)) {

			return idade--;

		}

		return idade;

	}

}
