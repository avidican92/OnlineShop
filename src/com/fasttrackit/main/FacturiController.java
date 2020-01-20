package com.fasttrackit.main;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fasttrackit.DAO.FacturiDAO;
import com.fasttrackit.pojo.Facturi;

@Controller
public class FacturiController {
	
	@RequestMapping(value="facturi.htm")
	public ModelAndView getFacturi() throws SQLException {
		ModelMap model = new ModelMap();
		FacturiDAO frdao = new FacturiDAO();
		ArrayList <Facturi> facturi = frdao.getFacturi();
		model.put("facturi", facturi);
		
		return new ModelAndView("facturi/facturi","model", model);
	}
	
	@RequestMapping(value="facturiAdd.htm")
	public ModelAndView displayAddForm(Model model) {
		Facturi fr = new Facturi();
		model.addAttribute("facturiForm", fr);
		return new ModelAndView("facturi/add", "model", model);
	}
	
	@RequestMapping(value="addFacturi.htm", method=RequestMethod.POST)
	public ModelAndView addFacturi(@ModelAttribute("facturiForm") Facturi facturi, ModelMap model, BindingResult result) {
		
		try {
			FacturiDAO fdao = new FacturiDAO();
			fdao.createFacturi(facturi);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return new ModelAndView("redirect:/facturi.htm");
	}
	
	@RequestMapping(value="facturiEdit/{facturiId}")
	public ModelAndView displayEditForm(@PathVariable String facturiId, Model model) throws SQLException {
		
		FacturiDAO fdao = new FacturiDAO();
		Facturi fr = fdao.getFacturiById(facturiId);
		model.addAttribute("facturiForm", fr );
		return new ModelAndView("facturi/edit", "model", model);
	}
	
	@RequestMapping(value="editFacturi.htm", method=RequestMethod.POST)
	public ModelAndView editFacturi(@ModelAttribute("facturiEdit") Facturi facturi, ModelMap model, 
			BindingResult result) {
		try {
			FacturiDAO fdao = new FacturiDAO();
			fdao.updateFacturi(facturi);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return new ModelAndView("redirect:/facturi.htm");
	}
	
	@RequestMapping(value="deleteFacturi/{facturiId}")
	public ModelAndView deleteFacturi(@PathVariable String facturiId,@ModelAttribute("addFacturiForm") Facturi facturi,
			ModelMap model, BindingResult result) {
		try {
			FacturiDAO fdao = new FacturiDAO();
			fdao.delete(fdao.getFacturiById(facturiId));
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return new ModelAndView("redirect:/facturi.htm");
	}
}
