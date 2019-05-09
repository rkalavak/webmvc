package com.kalavakuri.webmvc.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kalavakuri.webmvc.business.service.FamilyService;
import com.kalavakuri.webmvc.business.valueobject.FamilyVO;

@Controller
public class FamilyController {

	@Autowired
	private FamilyService familyService;

	@PostMapping(value = "/registerFamilyMember")
	public String registerFamilyMember(@ModelAttribute FamilyVO family) {

		familyService.saveFamilyMember(family);

		return "redirect:/";
	}
}
