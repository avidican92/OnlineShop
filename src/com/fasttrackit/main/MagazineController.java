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

import com.fasttrackit.DAO.MagazineDAO;
import com.fasttrackit.pojo.Magazine;

@Controller
public class MagazineController {

	@RequestMapping(value="magazine.htm")
	public ModelAndView getMagazine() throws SQLException {
		ModelMap model = new ModelMap();
		MagazineDAO mdao = new MagazineDAO();
		ArrayList <Magazine> magazine = mdao.getMagazine();
		model.put("magazine", magazine);
		
		return new ModelAndView("magazine/magazine","model", model);
	}
	
	@RequestMapping(value="magazineAdd.htm")
	public ModelAndView displayAddForm(Model model) {
		Magazine m = new Magazine();
		model.addAttribute("magazineForm", m);
		return new ModelAndView("magazine/add", "model", model);
	}
	
	@RequestMapping(value="addMagazine.htm", method=RequestMethod.POST)
	public ModelAndView addMagazine(@ModelAttribute("magazineForm") Magazine magazine, ModelMap model, BindingResult result) {
		
		try {
			MagazineDAO mdao = new MagazineDAO();
			mdao.createMagazine(magazine);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return new ModelAndView("redirect:/magazine.htm");
	}
	
	@RequestMapping(value="magazineEdit/{magazineId}")
	public ModelAndView displayEditForm(@PathVariable String magazineId, Model model) throws SQLException {
		
		MagazineDAO mdao = new MagazineDAO();
		Magazine m = mdao.getMagazineById(magazineId);
		model.addAttribute("magazineForm", m );
		return new ModelAndView("magazine/edit", "model", model);
	}
	
	@RequestMapping(value="editMagazine.htm", method=RequestMethod.POST)
	public ModelAndView editMagazine(@ModelAttribute("magazineEdit") Magazine magazine, ModelMap model, 
			BindingResult result) {
		try {
			MagazineDAO mdao = new MagazineDAO();
			mdao.updateMagazine(magazine);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return new ModelAndView("redirect:/magazine.htm");
	}
	
	@RequestMapping(value="deleteMagazine/{magazineId}")
	public ModelAndView deleteMagazine(@PathVariable String magazineId,@ModelAttribute("addMagazineForm") Magazine magazine,
			ModelMap model, BindingResult result) {
		try {
			MagazineDAO mdao = new MagazineDAO();
			mdao.delete(mdao.getMagazineById(magazineId));
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return new ModelAndView("redirect:/magazine.htm");
	}	
}
