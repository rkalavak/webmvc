package com.kalavakuri.webmvc.business.dao;

import java.util.List;

import com.kalavakuri.webmvc.business.valueobject.FamilyVO;

public interface FamilyDAO {

	public void saveFamilyMember(FamilyVO familyVO);

	public List<FamilyVO> getAllFamilyMembers();

	public int familyCount();
}
