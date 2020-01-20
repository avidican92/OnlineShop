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

import com.fasttrackit.DAO.ClientiDAO;
import com.fasttrackit.pojo.Clienti;

@Controller
public class ClientiController {
	@RequestMapping(value="clienti.htm")
	public ModelAndView getClienti() throws SQLException {
		ModelMap model = new ModelMap();
		ClientiDAO cdao = new ClientiDAO();
		ArrayList <Clienti> clienti = cdao.getClienti();
		model.put("clienti", clienti);
		
		return new ModelAndView("clienti/clienti","model", model);
	}
	
	@RequestMapping(value="clientiAdd.htm")
	public ModelAndView displayAddForm(Model model) {
		Clienti c = new Clienti();
		model.addAttribute("clientiForm", c);
		return new ModelAndView("clienti/add", "model", model);
	}
	
	@RequestMapping(value="addClienti.htm", method=RequestMethod.POST)
	public ModelAndView addClienti(@ModelAttribute("clientiForm") Clienti clienti, ModelMap model, BindingResult result) {
		
		try {
			ClientiDAO cdao = new ClientiDAO();
			cdao.createClienti(clienti);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return new ModelAndView("redirect:/clienti.htm");
	}
	
	@RequestMapping(value="clientiEdit/{clientiId}")
	public ModelAndView displayClientiForm(@PathVariable String clientiId, Model model) throws SQLException {
		
		ClientiDAO cdao = new ClientiDAO();
		Clienti c = cdao.getClientiById(clientiId);
		model.addAttribute("clientiForm", c );
		return new ModelAndView("clienti/edit", "model", model);
	}
	
	@RequestMapping(value="editClienti.htm", method=RequestMethod.POST)
	public ModelAndView editClienti(@ModelAttribute("clientiEdit") Clienti clienti, ModelMap model, 
			BindingResult result) {
		try {
			ClientiDAO cdao = new ClientiDAO();
			cdao.updateClienti(clienti);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return new ModelAndView("redirect:/clienti.htm");
	}
	
	@RequestMapping(value="deleteClienti/{clientiId}")
	public ModelAndView deleteClienti(@PathVariable String clientiId,@ModelAttribute("addClientiForm") Clienti clienti,
			ModelMap model, BindingResult result) {
		try {
			ClientiDAO cdao = new ClientiDAO();
			cdao.deleteClienti(cdao.getClientiById(clientiId));
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return new ModelAndView("redirect:/clienti.htm");
	}
}
