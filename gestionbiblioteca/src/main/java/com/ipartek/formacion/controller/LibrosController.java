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

import com.ipartek.formacion.dao.persistence.Libro;
import com.ipartek.formacion.service.interfaces.LibroService;
@Controller
@RequestMapping(value = "/libros")
public class LibrosController extends MultiActionController {

	private static final Logger logger = LoggerFactory.getLogger(LibrosController.class);
	@Autowired
	private LibroService libService = null;
	private ModelAndView mav = null;
	@Autowired
	@Qualifier("libroValidator")
	private Validator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy"), false, 10));
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll() {
		mav = new ModelAndView("/libros/listado");
		mav.addObject("listaLibros", libService.getAll());
		return mav;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ModelAndView getById(@PathVariable("id") int id) {
		mav = new ModelAndView("/libros/libro");
		mav.addObject("libro", libService.getById(id));
		return mav;
	}

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.DELETE }, value = "/{id}")
	public String delete(@PathVariable("id") int id) {
		libService.delete(id);
		return "redirect:libros";
	}

	@RequestMapping(value = "/addLibro", method = RequestMethod.GET)
	public String addLibro(Model model) {
		model.addAttribute("libro", new Libro());
		return "/libros/libro";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveLibro(@ModelAttribute("libro") @Validated Libro libro, BindingResult bindingResult, Model model) {
		String destino = "";

		if (bindingResult.hasErrors()) {
			logger.info("El libro tiene errores");
			destino = "/libros/libro";
		} else {
			logger.info("libro correcto");
			destino = "redirect:/libros";
			if (libro.getCodigo() > 0) {
				libService.update(libro);
			} else {
				libService.create(libro);
			}
		}
		return destino;
	}

	@RequestMapping(value = "/restclients", method = RequestMethod.GET)
	public String restRedirect(Model model) {
		return "/libros/listado_rest";
	}
}