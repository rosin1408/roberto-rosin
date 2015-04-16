package br.com.rosin.robertorosin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rosin.robertorosin.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
