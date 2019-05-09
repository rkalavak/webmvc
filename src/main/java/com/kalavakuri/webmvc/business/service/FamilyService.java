package com.kalavakuri.webmvc.business.service;

import com.kalavakuri.webmvc.business.valueobject.FamilyVO;

public interface FamilyService {

	public void saveFamilyMember(FamilyVO familyVO);

	public FamilyVO getAllFamilyMembers();
}
