package br.com.rosin.robertorosin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.rosin.robertorosin.api.CRUDService;
import br.com.rosin.robertorosin.model.Pessoa;

@Service
public class PessoaService extends CRUDService<Pessoa> {
	
	@Autowired
	public PessoaService(JpaRepository<Pessoa, Long> repository) {
		super(repository);
	}
}
