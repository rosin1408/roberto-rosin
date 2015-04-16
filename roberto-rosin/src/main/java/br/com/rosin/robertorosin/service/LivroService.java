package br.com.rosin.robertorosin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rosin.robertorosin.model.Livro;
import br.com.rosin.robertorosin.repository.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository repository;
	
	public void salvar(Livro livro) {
		repository.save(livro);
	}

	public Livro find(Long codigo) {
		return repository.findOne(codigo);
	}

	public List<Livro> findAll() {
		return repository.findAll();
	}

	public void delete(Long codigo) {
		repository.delete(codigo);
	}

}
