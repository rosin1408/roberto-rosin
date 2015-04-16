package br.com.rosin.robertorosin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.rosin.robertorosin.api.CRUDService;
import br.com.rosin.robertorosin.model.Livro;

@Service
public class LivroService extends CRUDService<Livro> {	
	
	@Autowired
	public LivroService(JpaRepository<Livro, Long> repository) {
		super(repository);
	}

}
