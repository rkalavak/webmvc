package com.kalavakuri.webmvc.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kalavakuri.webmvc.business.dao.FamilyDAO;
import com.kalavakuri.webmvc.business.valueobject.FamilyVO;

@Service
public class FamilyServiceImpl implements FamilyService {

	@Autowired
	private FamilyDAO familyDAO;

	@Override
	@Transactional
	public void saveFamilyMember(FamilyVO familyVO) {

		familyVO.setFamilyId(familyDAO.familyCount());
		familyVO.getFamilyAddress().setAddressId(familyDAO.addressCount());
		familyDAO.saveFamilyMember(familyVO);
		familyDAO.saveAddress(familyVO);

	}

	@Override
	public FamilyVO getAllFamilyMembers() {

		FamilyVO familyVO = new FamilyVO();

		List<FamilyVO> allFamilyMembers = familyDAO.getAllFamilyMembers();
		familyVO.setFamilyVOs(allFamilyMembers);

		return familyVO;
	}

}
