package com.kalavakuri.webmvc.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kalavakuri.webmvc.business.service.FamilyService;
import com.kalavakuri.webmvc.business.valueobject.FamilyVO;

@Controller
public class WelcomeController {

	@Autowired
	private FamilyService familyService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView welcomePage() {

		FamilyVO allFamilyMembers = familyService.getAllFamilyMembers();
		ModelAndView modelAndView = new ModelAndView("index", "family", allFamilyMembers);

		List<String> familyMemberAges = new ArrayList<String>();

		for (int i = 0; i <= 100; i++) {
			familyMemberAges.add("" + i);
		}

		modelAndView.addObject("familyMemberAges", familyMemberAges);

		return modelAndView;
	}
}
