package br.com.rosin.robertorosin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rosin.robertorosin.model.Pessoa;
import br.com.rosin.robertorosin.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repository;
	
	public void salvar(Pessoa pessoa) {
		repository.save(pessoa);
	}

	public Pessoa find(Long codigo) {
		return repository.findOne(codigo);
	}

	public List<Pessoa> findAll() {
		return repository.findAll();
	}

	public void delete(Long codigo) {
		repository.delete(codigo);
	}
}
