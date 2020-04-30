package br.com.qintess.formulario.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.qintess.formulario.dao.UsuarioDao;
import br.com.qintess.formulario.modelos.Usuario;

@Controller
public class RelatorioController {
	
	@Autowired
	UsuarioDao usuarioDao;
	
	@RequestMapping("/relatorio")
	public String carrega(Model model) {
		List<Usuario> usuarios = null;
		model.addAttribute("dados", usuarios);
		return "relatorio";
	}
}
