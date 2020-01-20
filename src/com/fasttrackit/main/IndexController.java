package com.fasttrackit.main;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

import com.fasttrackit.DAO.BranduriDAO;
import com.fasttrackit.pojo.Branduri;

@Controller
public class IndexController {

	@RequestMapping(value="index.htm")
	public ModelAndView getBranduri() throws SQLException {
		ModelMap model = new ModelMap();
		BranduriDAO bdao = new BranduriDAO();
		ArrayList <Branduri> branduri = bdao.getBranduri();
		model.put("branduri", branduri);
		
		return new ModelAndView("index","model", model);
	}
}
