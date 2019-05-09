package com.kalavakuri.webmvc.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kalavakuri.webmvc.business.dao.FamilyDAO;
import com.kalavakuri.webmvc.business.valueobject.FamilyVO;

@Service
public class FamilyServiceImpl implements FamilyService {

	@Autowired
	private FamilyDAO familyDAO;

	@Override
	public void saveFamilyMember(FamilyVO familyVO) {

		familyDAO.saveFamilyMember(familyVO);

	}

	@Override
	public FamilyVO getAllFamilyMembers() {

		FamilyVO familyVO = new FamilyVO();

		List<FamilyVO> allFamilyMembers = familyDAO.getAllFamilyMembers();
		familyVO.setFamilyVOs(allFamilyMembers);

		return familyVO;
	}

}
