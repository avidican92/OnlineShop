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

import com.fasttrackit.DAO.BranduriDAO;
import com.fasttrackit.pojo.Branduri;


@Controller
public class BranduriController {
	
	@RequestMapping(value="branduri.htm")
	public ModelAndView getBranduri() throws SQLException {
		ModelMap model = new ModelMap();
		BranduriDAO bdao = new BranduriDAO();
		ArrayList <Branduri> branduri = bdao.getBranduri();
		model.put("branduri", branduri);
		
		return new ModelAndView("branduri/branduri","model", model);
	}
	
	@RequestMapping(value="branduriAdd.htm")
	public ModelAndView displayAddForm(Model model) {
		Branduri b = new Branduri();
		model.addAttribute("branduriForm", b);
		return new ModelAndView("branduri/add", "model", model);
	}
	
	@RequestMapping(value="addBranduri.htm", method=RequestMethod.POST)
	public ModelAndView addBranduri(@ModelAttribute("branduriForm") Branduri branduri, ModelMap model, BindingResult result) {
		
		try {
			BranduriDAO bdao = new BranduriDAO();
			bdao.createBranduri(branduri);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return new ModelAndView("redirect:/branduri.htm");
	}
	
	@RequestMapping(value="branduriEdit/{branduriId}")
	public ModelAndView displayEditForm(@PathVariable String branduriId, Model model) throws SQLException {
		
		BranduriDAO bdao = new BranduriDAO();
		Branduri b = bdao.getBranduriById(branduriId);
		model.addAttribute("branduriForm", b );
		return new ModelAndView("branduri/edit", "model", model);
	}
	
	@RequestMapping(value="editBranduri.htm", method=RequestMethod.POST)
	public ModelAndView editBranduri(@ModelAttribute("branduriEdit") Branduri branduri, ModelMap model, 
			BindingResult result) {
		try {
			BranduriDAO bdao = new BranduriDAO();
			bdao.updateBranduri(branduri);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return new ModelAndView("redirect:/branduri.htm");
	}
	
	@RequestMapping(value="deleteBranduri/{branduriId}")
	public ModelAndView deleteBranduri(@PathVariable String branduriId,@ModelAttribute("addBranduriForm") Branduri branduri,
			ModelMap model, BindingResult result) {
		try {
			BranduriDAO bdao = new BranduriDAO();
			bdao.deleteBranduri(bdao.getBranduriById(branduriId));
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return new ModelAndView("redirect:/branduri.htm");
	}
}







