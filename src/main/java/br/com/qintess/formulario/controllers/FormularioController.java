package br.com.qintess.formulario.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.qintess.formulario.dao.ComportamentaisDao;
import br.com.qintess.formulario.dao.FormacaoDao;
import br.com.qintess.formulario.dao.IdiomaDao;
import br.com.qintess.formulario.dao.OffTopicDao;
import br.com.qintess.formulario.dao.UsuarioDao;
import br.com.qintess.formulario.modelos.Comportamentais;
import br.com.qintess.formulario.modelos.FormacaoAcademica;
import br.com.qintess.formulario.modelos.Idioma;
import br.com.qintess.formulario.modelos.OffTopic;
import br.com.qintess.formulario.modelos.Usuario;

@Controller
public class FormularioController {
	
	@Autowired
	UsuarioDao usuarioDao;
	
	
	@Autowired
	FormacaoDao formacaoDao;
	
	@Autowired
	IdiomaDao idiomaDao;
	
	@Autowired
	ComportamentaisDao comportamentaisDao;
	
	@Autowired
	OffTopicDao offTopicDao;
	
	private List<FormacaoAcademica> retornaFormacoes() {
		List<FormacaoAcademica> formacoes = new ArrayList<>();
		FormacaoAcademica f1 = new FormacaoAcademica(1, "Ensino Medio Completo");
		FormacaoAcademica f2 = new FormacaoAcademica(2, "Ensino Superior Incompleto");
		FormacaoAcademica f3 = new FormacaoAcademica(3, "Ensino Superior Completo");
		FormacaoAcademica f4 = new FormacaoAcademica(4, "Pos-graduacao ou MBA");
		FormacaoAcademica f5 = new FormacaoAcademica(5, "Mestrado");
		FormacaoAcademica f6 = new FormacaoAcademica(5, "Doutorado");
		FormacaoAcademica f7 = new FormacaoAcademica(5, "Pos-doutorado (PHD)");
		
		formacoes.add(f1);
		formacoes.add(f2);
		formacoes.add(f3);
		formacoes.add(f4);
		formacoes.add(f5);
		formacoes.add(f6);
		formacoes.add(f7);
		
		return formacoes;
	}
	
	private List<Idioma> retornaIdiomas() {
		
		List<Idioma> idiomas = new ArrayList<>();
		
		Idioma i1 = new Idioma(1, "Inglês");
		Idioma i2 = new Idioma(2, "Espanhol");
		Idioma i3 = new Idioma(3, "Francês");
		Idioma i4 = new Idioma(4, "Alemão");
		Idioma i5 = new Idioma(5, "Chinês");
		Idioma i6 = new Idioma(6, "Japonês");
		Idioma i7 = new Idioma(7, "Outros");
		
		idiomas.add(i1);
		idiomas.add(i2);
		idiomas.add(i3);
		idiomas.add(i4);
		idiomas.add(i5);
		idiomas.add(i6);
		idiomas.add(i7);
		
		return idiomas;
	}
	
	@RequestMapping("/")
	public String carrega(Model model) {
		model.addAttribute("formacoes", retornaFormacoes());
		model.addAttribute("idiomas", retornaIdiomas());
		model.addAttribute("comportamentais", comportamentaisDao.buscaOrdenadoComportamentais());
		model.addAttribute("offtopics", offTopicDao.buscaOrdenadoOffTopic());
		model.addAttribute("usuario", new Usuario()); 
		return "formulario";
	}
	
	@RequestMapping("/salva")
	public String salva(@ModelAttribute Usuario usuario) {
		usuarioDao.save(usuario);
		return "redirect:/";
	}
	
	@RequestMapping("/limpar")
	public String limpar() {
		return "redirect:/";
	}
}
