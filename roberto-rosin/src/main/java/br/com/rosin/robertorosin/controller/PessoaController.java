package br.com.rosin.robertorosin.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.rosin.robertorosin.model.Pessoa;
import br.com.rosin.robertorosin.service.PessoaService;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {
	
	private static final String INDEX = "/pessoa/index";
	private static final String FORM = "/pessoa/form";
	
	@Autowired
	private PessoaService service;
	
	@RequestMapping(value="/")
	public String index(Model model) {
		model.addAttribute("pessoas", service.findAll());
		return INDEX;
	}
	
	@RequestMapping(value="/novo")
	public String novo() {
		return FORM;
	}
	
	@RequestMapping(value="/{codigo}", method=RequestMethod.GET)
	public String editar(@PathVariable Long codigo, Model model) {
		model.addAttribute("pessoa", service.find(codigo));
		
		return FORM;
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String salvar(@Valid Pessoa pessoa, BindingResult erros, Model model) {
		if (erros.hasErrors()) {
			return FORM;
		}
		service.salvar(pessoa);
		
		model.addAttribute("mensagem", "Pessoa salva com sucesso!");
		
		return FORM;
	}
	
	@RequestMapping(value="/{codigo}/excluir", method=RequestMethod.GET)
	public String excluir(@PathVariable Long codigo, Model model){
		service.delete(codigo);
		return "redirect:/pessoa/";
	}
}
