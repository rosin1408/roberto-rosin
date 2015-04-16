package br.com.rosin.robertorosin.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.rosin.robertorosin.model.Emprestimo;
import br.com.rosin.robertorosin.service.EmprestimoService;
import br.com.rosin.robertorosin.service.LivroService;
import br.com.rosin.robertorosin.service.PessoaService;

@Controller
@RequestMapping("/emprestimo")
public class EmprestimoController {
	
	private static final String INDEX = "/emprestimo/index";
	private static final String FORM = "/emprestimo/form";
	
	@Autowired
	private EmprestimoService service;
	
	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private LivroService livroService;
	
	@RequestMapping(value="/")
	public String index(Model model) {
		model.addAttribute("emprestimos", service.findAll());
		return INDEX;
	}
	
	@RequestMapping(value="/novo")
	public String novo(Model model) {
		carregaDados(model);
		return FORM;
	}
	
	@RequestMapping(value="/{codigo}/devolver", method=RequestMethod.GET)
	public String devolver(@PathVariable Long codigo, Model model) {
		service.devolver(codigo);
		model.addAttribute("mensagem", "Devolução efetuada com sucesso!");
		
		return "redirect:/emprestimo/";
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String salvar(@Valid Emprestimo emprestimo, BindingResult erros, Model model) {
		if (erros.hasErrors()) {
			return FORM;
		}
		if (service.isValid(emprestimo, model)) {
			service.salvar(emprestimo);
			model.addAttribute("mensagem", "Emprestimo salvo com sucesso!");
		}
		carregaDados(model);
		
		return FORM;
	}
	
	@RequestMapping(value="/{codigo}/excluir", method=RequestMethod.GET)
	public String excluir(@PathVariable Long codigo, Model model){
		service.delete(codigo);
		return "redirect:/emprestimo/";
	}
	
	private void carregaDados(Model model) {
		model.addAttribute("pessoas", pessoaService.findAll());
		model.addAttribute("livros", livroService.findAll());
	}
}
