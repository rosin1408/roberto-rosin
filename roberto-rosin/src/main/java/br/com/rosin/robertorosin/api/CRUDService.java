package br.com.rosin.robertorosin.api;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public class CRUDService<T> {
	
	protected final JpaRepository<T, Long> repository;
	
	public CRUDService(JpaRepository<T, Long> repository) {
		this.repository = repository;
	}
	
	public void salvar(T entidade) {
		repository.save(entidade);
	}

	public T find(Long codigo) {
		return repository.findOne(codigo);
	}

	public List<T> findAll() {
		return repository.findAll();
	}

	public void delete(Long codigo) {
		repository.delete(codigo);
	}
}
