package com.ipartek.formacion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ipartek.formacion.dao.persistence.Usuario;
import com.ipartek.formacion.service.interfaces.UsuarioService;

@RequestMapping("/usuarios")
@Controller
public class UsuarioController {
	@Autowired
	private UsuarioService as;
	private ModelAndView mav;

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ModelAndView getById(@PathVariable("id") int id) {
		mav = new ModelAndView("/usuarios/usuario");
		mav.addObject("usuario", as.getAll());
		return mav;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		as.delete(id);
		return "redirect:/usuarios";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/addUsuario")
	public ModelAndView createUsuario() {
		mav = new ModelAndView("/usuarios/usuario");
		mav.addObject("usuario", new Usuario());
		return mav;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveAlumno(@ModelAttribute("usuario") Usuario usuario, Model model) {
		String destino = "";
		// destino = "/alumnos/alumno";
		destino = "redirect:/alumnos";
		// logger.info("alumno correcto");
		if (usuario.getCodUsuario() > 0) {
			as.update(usuario);
		} else {
			as.create(usuario);
		}
		return destino;
	}
}
