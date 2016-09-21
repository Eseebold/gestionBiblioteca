package com.ipartek.formacion.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/**
 * @author Turbo
 */
/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

  private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

  /**
   * Simply selects the home view to render by returning its name.
   */

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public ModelAndView home(Locale locale, Model model) {
    ModelAndView mav = null;
    mav = new ModelAndView("home");
    logger.info("carga la página web");
    return mav;
  }

}