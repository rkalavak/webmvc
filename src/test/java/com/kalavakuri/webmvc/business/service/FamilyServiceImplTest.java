package com.kalavakuri.webmvc.business.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kalavakuri.webmvc.business.dao.FamilyDAO;
import com.kalavakuri.webmvc.business.valueobject.FamilyAddress;
import com.kalavakuri.webmvc.business.valueobject.FamilyVO;
import com.kalavakuri.webmvc.init.ApplicationInitializer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationInitializer.class })
@PropertySource("classpath:webmvc_test.properties")
public class FamilyServiceImplTest {

	@InjectMocks
	private FamilyServiceImpl familyServiceImpl;

	@Mock
	private FamilyDAO familyDAO;

	@Autowired
	private Environment environment;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void saveFamilyMember() {

		FamilyVO familyVO = new FamilyVO();
		familyVO.setFamilyMemberName("Ramachandrappa Kalavakuri");
		familyVO.setFamilyMemberAge(36);
		FamilyAddress familyAddress = new FamilyAddress();
		familyAddress.setAddress(
				"Flat no: 305, 2nd Floor, Prakasa Pride Apartments, Opp To J.P.Morgan, Kadubesinahalli, Bangalore - 560087");
		familyVO.setFamilyAddress(familyAddress);

		Mockito.when(familyDAO.familyCount()).thenReturn(7);
		Mockito.when(familyDAO.addressCount()).thenReturn(7);
		Mockito.doNothing().when(familyDAO).saveFamilyMember(familyVO);
		Mockito.doNothing().when(familyDAO).saveAddress(familyVO);

		familyServiceImpl.saveFamilyMember(familyVO);

	}

	@Test
	public void getAllFamilyMembers() {

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

		Mockito.when(familyDAO.getAllFamilyMembers()).thenReturn(familyVOs);

		FamilyVO allFamilyMembers = familyServiceImpl.getAllFamilyMembers();

		Assert.assertNotNull(allFamilyMembers);
		Assert.assertEquals(1, allFamilyMembers.getFamilyVOs().size());
	}

}
