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


import com.fasttrackit.DAO.ProduseDAO;
import com.fasttrackit.pojo.Produse;

@Controller
public class ProduseController {

	@RequestMapping(value="produse.htm")
	public ModelAndView getProduse() throws SQLException{
		ModelMap model = new ModelMap();
		ProduseDAO pdao = new ProduseDAO();
		ArrayList <Produse> produse = pdao.getProduse();
		model.put("produse", produse);
		
		return new ModelAndView("produse/produse","model", model);
	}
	
	@RequestMapping(value="produseAdd.htm")
	public ModelAndView displayAddForm(Model model) {
		Produse p = new Produse();
		model.addAttribute("produseForm", p);
		return new ModelAndView("produse/add", "model", model);
	}
	
	@RequestMapping(value="addProduse.htm", method=RequestMethod.POST)
	public ModelAndView addProduse(@ModelAttribute("produseForm") Produse produse, ModelMap model, BindingResult result) {
		try {
			ProduseDAO pdao = new ProduseDAO();
			pdao.createProduse(produse);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return new ModelAndView("redirect:/produse.htm");
	}
	
	@RequestMapping(value="produseEdit/{produseId}")
	public ModelAndView displayEditForm(@PathVariable String produseId, Model model) throws SQLException {
		
		ProduseDAO pdao = new ProduseDAO();
		Produse p = pdao.getProduseById(produseId);
		model.addAttribute("produseForm", p );
		return new ModelAndView("produse/edit", "model", model);
	}
	
	@RequestMapping(value="editProduse.htm", method=RequestMethod.POST)
	public ModelAndView editProduse(@ModelAttribute("produseEdit") Produse produse, ModelMap model, 
			BindingResult result) {
		try {
			ProduseDAO pdao = new ProduseDAO();
			pdao.updateProduse(produse);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return new ModelAndView("redirect:/produse.htm");
	}
	
	@RequestMapping(value="deleteProduse/{produseId}")
	public ModelAndView deleteProduse(@PathVariable String produseId,@ModelAttribute("addProduseForm") Produse produse,
			ModelMap model, BindingResult result) {
		try {
			ProduseDAO pdao = new ProduseDAO();
			pdao.delete(pdao.getProduseById(produseId));
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return new ModelAndView("redirect:/produse.htm");
	}
}
