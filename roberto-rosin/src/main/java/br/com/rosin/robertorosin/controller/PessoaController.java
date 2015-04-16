package br.com.rosin.robertorosin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.rosin.robertorosin.api.CRUDController;
import br.com.rosin.robertorosin.api.CRUDService;
import br.com.rosin.robertorosin.model.Pessoa;

@Controller
@RequestMapping("/pessoa")
public class PessoaController extends CRUDController<Pessoa> {
	
	@Autowired
	public PessoaController(CRUDService<Pessoa> service) {
		super(service, "/pessoa");
	}
}
