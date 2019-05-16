package com.kalavakuri.webmvc.web.controller;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.kalavakuri.webmvc.business.service.FamilyService;
import com.kalavakuri.webmvc.business.valueobject.FamilyAddress;
import com.kalavakuri.webmvc.business.valueobject.FamilyVO;
import com.kalavakuri.webmvc.init.ApplicationInitializer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationInitializer.class })
@PropertySource("classpath:webmvc_test.properties")
public class WelcomeControllerTest {

	@Mock
	private FamilyService familyService;

	@InjectMocks
	private WelcomeController welcomeController;

	@Autowired
	private Environment environment;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(welcomeController).build();
	}

	@Test
	public void welcomePage() throws Exception {

		FamilyVO allFamilyMembers = getAllFamilyMembers();

		when(familyService.getAllFamilyMembers()).thenReturn(allFamilyMembers);
		mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("Index"))
				.andExpect(model().attribute("family", allFamilyMembers))
				.andExpect(model().attribute("family", hasProperty("familyVOs", hasSize(1))))
				.andExpect(model().attribute("family",
						hasProperty("familyVOs",
								hasItem(allOf(hasProperty("familyId", is(1)),
										hasProperty("familyMemberName", is("Ramachandrappa Kalavakuri")),
										hasProperty("familyMemberAge", is(36)))))));
	}

	/**
	 * @return
	 */
	private FamilyVO getAllFamilyMembers() {

		FamilyVO allFamilyMembers = new FamilyVO();
		FamilyVO familyVO = new FamilyVO();
		familyVO.setFamilyId(1);
		familyVO.setFamilyMemberName("Ramachandrappa Kalavakuri");
		familyVO.setFamilyMemberAge(36);

		FamilyAddress familyAddress = new FamilyAddress();
		familyAddress.setAddress(
				"Flat no: 305, 2nd Floor, Prakasa Pride Apartments, Opp To J.P.Morgan, Kadubesinahalli, Bangalore - 560087");
		familyVO.setFamilyAddress(familyAddress);

		List<FamilyVO> familyVOs = new ArrayList<FamilyVO>();
		familyVOs.add(familyVO);

		allFamilyMembers.setFamilyVOs(familyVOs);
		return allFamilyMembers;
	}
}
