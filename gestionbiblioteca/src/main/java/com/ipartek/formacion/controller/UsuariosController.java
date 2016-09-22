package com.ipartek.formacion.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.ipartek.formacion.dao.persistence.Usuario;
import com.ipartek.formacion.service.interfaces.UsuarioService;
//@EnableAspectJAutoProxy(proxyTargetClass = true) 
@Controller
@RequestMapping(value = "/usuarios")
public class UsuariosController extends MultiActionController {

	private static final Logger logger = LoggerFactory.getLogger(UsuariosController.class);
	@Autowired
	private UsuarioService usuService;
	private ModelAndView mav = null;
	@Autowired
	@Qualifier("usuarioValidator")
	private Validator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy"), false, 10));
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll() {
		mav = new ModelAndView("/usuarios/listado");
		mav.addObject("listaUsuarios", usuService.getAll());
		return mav;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ModelAndView getById(@PathVariable("id") int id) {
		mav = new ModelAndView("/usuarios/usuario");
		mav.addObject("usuario", usuService.getById(id));
		return mav;
	}

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.DELETE }, value = "/{id}")
	public String delete(@PathVariable("id") int id) {
		usuService.delete(id);
		return "redirect:../usuarios";
	}

	@RequestMapping(value = "/addUsuario", method = RequestMethod.GET)
	public String addUsuario(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "/usuarios/usuario";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveUsuario(@ModelAttribute("usuario") @Validated Usuario usuario, BindingResult bindingResult, Model model) {
		String destino = "";

		if (bindingResult.hasErrors()) {
			logger.info("El usuario tiene errores");
			destino = "/usuarios/usuario";
		} else {
			logger.info("usuario correcto");
			destino = "redirect:/usuarios";
			if (usuario.getCodigo() > 0) {
				usuService.update(usuario);
			} else {
				usuService.create(usuario);
			}
		}
		return destino;
	}

	@RequestMapping(value = "/restclients", method = RequestMethod.GET)
	public String restRedirect(Model model) {
		return "/usuarios/listado_rest";
	}
}