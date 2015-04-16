package br.com.rosin.robertorosin.api;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public abstract class CRUDController<T> {
	
	private final CRUDService<T> service;
	private final String initFormParam;
	
	public CRUDController(CRUDService<T> service, String initFormParam) {
		this.service = service;
		this.initFormParam = initFormParam;
	}
	
	@RequestMapping(value="/")
	public String index(Model model) {
		model.addAttribute("livros", service.findAll());
		return initFormParam + "/index";
	}
	
	@RequestMapping(value="/novo")
	public String novo() {
		return initFormParam + "/form";
	}
	
	@RequestMapping(value="/{codigo}", method=RequestMethod.GET)
	public String editar(@PathVariable Long codigo, Model model) {
		model.addAttribute("livro", service.find(codigo));
		
		return initFormParam + "/form";
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String salvar(@Valid T entidade, BindingResult erros, Model model) {
		if (erros.hasErrors()) {
			return initFormParam + "/form";
		}
		service.salvar(entidade);
		
		model.addAttribute("mensagem", "Registro salvo com sucesso!");
		
		return initFormParam + "/form";
	}
	
	@RequestMapping(value="/{codigo}/excluir", method=RequestMethod.GET)
	public String excluir(@PathVariable Long codigo, Model model){
		service.delete(codigo);
		return "redirect:" + initFormParam;
	}
}
