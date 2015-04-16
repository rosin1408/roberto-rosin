package br.com.rosin.robertorosin.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.rosin.robertorosin.model.Livro;
import br.com.rosin.robertorosin.service.LivroService;

@Controller
@RequestMapping("/livro")
public class LivroController {
	
	private static final String INDEX = "/livro/index";
	private static final String FORM = "/livro/form";
	
	@Autowired
	private LivroService service;
	
	@RequestMapping(value="/")
	public String index(Model model) {
		model.addAttribute("livros", service.findAll());
		return INDEX;
	}
	
	@RequestMapping(value="/novo")
	public String novo() {
		return FORM;
	}
	
	@RequestMapping(value="/{codigo}", method=RequestMethod.GET)
	public String editar(@PathVariable Long codigo, Model model) {
		model.addAttribute("livro", service.find(codigo));
		
		return FORM;
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String salvar(@Valid Livro livro, BindingResult erros, Model model) {
		if (erros.hasErrors()) {
			return FORM;
		}
		service.salvar(livro);
		
		model.addAttribute("mensagem", "Livro salvo com sucesso!");
		
		return FORM;
	}
	
	@RequestMapping(value="/{codigo}/excluir", method=RequestMethod.GET)
	public String excluir(@PathVariable Long codigo, Model model){
		service.delete(codigo);
		return "redirect:/livro/";
	}
}
