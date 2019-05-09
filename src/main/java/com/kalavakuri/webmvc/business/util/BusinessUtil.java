package com.kalavakuri.webmvc.business.util;

import com.kalavakuri.webmvc.business.valueobject.FamilyVO;

public class BusinessUtil {

	public static Object[] createInsertFamily(FamilyVO familyVO) {

		return new Object[] { familyVO.getFamilyId(), familyVO.getFamilyMemberName(), familyVO.getFamilyMemberAge() };
	}

	public static Object[] createInsertAddress(FamilyVO familyVO) {

		return new Object[] { familyVO.getFamilyId(), familyVO.getFamilyAddress().getAddressId(),
				familyVO.getFamilyAddress().getAddress() };
	}
}
