package com.kalavakuri.webmvc.web.controller;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import com.kalavakuri.webmvc.business.valueobject.FamilyVO;
import com.kalavakuri.webmvc.init.ApplicationInitializer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationInitializer.class })
@PropertySource("classpath:webmvc_test.properties")
public class FamilyControllerTest {

	@Mock
	private FamilyService familyService;

	@InjectMocks
	private FamilyController familyController;

	@Autowired
	private Environment environment;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(familyController).build();
	}

	@Test
	public void registerFamilyMember() throws Exception {

		FamilyVO family = new FamilyVO();

		doNothing().when(familyService).saveFamilyMember(family);

		mockMvc.perform(post("/registerFamilyMember").flashAttr("family", family))
				.andExpect(status().is3xxRedirection());
	}

}
