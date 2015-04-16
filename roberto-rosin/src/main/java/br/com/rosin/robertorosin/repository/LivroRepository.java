package br.com.rosin.robertorosin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rosin.robertorosin.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
