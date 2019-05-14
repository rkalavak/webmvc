package com.kalavakuri.webmvc.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
	public ModelAndView welcomePage(Map<String, String> map) {

		FamilyVO allFamilyMembers = familyService.getAllFamilyMembers();
		ModelAndView modelAndView = new ModelAndView("Index", "family", allFamilyMembers);

		List<String> familyMemberAges = new ArrayList<String>();

		for (int i = 0; i <= 100; i++) {
			familyMemberAges.add("" + i);
		}

		modelAndView.addObject("familyMemberAges", familyMemberAges);

		System.out.println(map.get("Test"));

		return modelAndView;
	}
}
