package br.com.rosin.robertorosin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.rosin.robertorosin.api.CRUDController;
import br.com.rosin.robertorosin.api.CRUDService;
import br.com.rosin.robertorosin.model.Livro;

@Controller
@RequestMapping("/livro")
public class LivroController extends CRUDController<Livro> {
	
	public LivroController(CRUDService<Livro> service) {
		super(service, "/livro");
	}
}
