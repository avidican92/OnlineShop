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

import com.fasttrackit.DAO.FinantareDAO;
import com.fasttrackit.pojo.Finantare;

@Controller
public class FinantareController {
	@RequestMapping(value="finantare.htm")
	public ModelAndView getFinantare() throws SQLException {
		ModelMap model = new ModelMap();
		FinantareDAO fdao = new FinantareDAO();
		ArrayList <Finantare> finantare = fdao.getFinantare();
		model.put("finantare", finantare);
		
		return new ModelAndView("finantare/finantare","model", model);
	}
	
	@RequestMapping(value="finantareAdd.htm")
	public ModelAndView displayAddForm(Model model) {
		Finantare f = new Finantare();
		model.addAttribute("finantareForm", f);
		return new ModelAndView("finantare/add", "model", model);
	}
	
	@RequestMapping(value="addFinantare.htm", method=RequestMethod.POST)
	public ModelAndView addFinantare(@ModelAttribute("finantareForm") Finantare finantare, ModelMap model, BindingResult result) {
		
		try {
			FinantareDAO fdao = new FinantareDAO();
			fdao.createFinantare(finantare);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return new ModelAndView("redirect:/finantare.htm");
	}
	
	@RequestMapping(value="finantareEdit/{finantareId}")
	public ModelAndView displayEditForm(@PathVariable String finantareId, Model model) throws SQLException {
		
		FinantareDAO fdao = new FinantareDAO();
		Finantare f = fdao.getFinantareById(finantareId);
		model.addAttribute("finantareForm", f );
		return new ModelAndView("finantare/edit", "model", model);
	}
	
	@RequestMapping(value="editFinantare.htm", method=RequestMethod.POST)
	public ModelAndView editFinantare(@ModelAttribute("finantareEdit") Finantare finantare, ModelMap model, 
			BindingResult result) {
		try {
			FinantareDAO fdao = new FinantareDAO();
			fdao.updateFinantare(finantare);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return new ModelAndView("redirect:/finantare.htm");
	}
	
	@RequestMapping(value="deleteFinantare/{finantareId}")
	public ModelAndView deleteFinantare(@PathVariable String finantareId,@ModelAttribute("addFinantareForm") Finantare finantare,
			ModelMap model, BindingResult result) {
		try {
			FinantareDAO fdao = new FinantareDAO();
			fdao.delete(fdao.getFinantareById(finantareId));
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return new ModelAndView("redirect:/finantare.htm");
	}
}
