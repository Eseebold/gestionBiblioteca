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

import com.ipartek.formacion.dao.persistence.Ejemplar;
import com.ipartek.formacion.service.interfaces.EjemplarService;
@Controller
@RequestMapping(value = "/ejemplares")
public class EjemplaresController extends MultiActionController {

	private static final Logger logger = LoggerFactory.getLogger(LibrosController.class);
	@Autowired
	private EjemplarService ejeService = null;
	private ModelAndView mav = null;
	@Autowired
	@Qualifier("ejemplarValidator")
	private Validator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy"), false, 10));
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll() {
		mav = new ModelAndView("/ejemplares/listado");
		mav.addObject("listaEjemplares", ejeService.getAll());
		return mav;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ModelAndView getById(@PathVariable("id") int id) {
		mav = new ModelAndView("/ejemplares/ejemplar");
		mav.addObject("ejemplar", ejeService.getById(id));
		return mav;
	}

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.DELETE }, value = "/{id}")
	public String delete(@PathVariable("id") int id) {
		ejeService.delete(id);
		return "redirect:ejemplares";
	}

	@RequestMapping(value = "/addEjemplar", method = RequestMethod.GET)
	public String addEjemplar(Model model) {
		model.addAttribute("ejemplar", new Ejemplar());
		return "/ejemplares/ejemplar";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveEjemplar(@ModelAttribute("ejemplar") @Validated Ejemplar ejemplar, BindingResult bindingResult, Model model) {
		String destino = "";

		if (bindingResult.hasErrors()) {
			logger.info("El ejemplar tiene errores");
			destino = "/ejemplares/ejemplar";
		} else {
			logger.info("ejemplar correcto");
			destino = "redirect:/ejemplares";
			if (ejemplar.getCodigo() > 0) {
				ejeService.update(ejemplar);
			} else {
				ejeService.create(ejemplar);
			}
		}
		return destino;
	}

	@RequestMapping(value = "/restclients", method = RequestMethod.GET)
	public String restRedirect(Model model) {
		return "/ejemplares/listado_rest";
	}
}