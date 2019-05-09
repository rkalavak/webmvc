package com.kalavakuri.webmvc.business.valueobject;

import java.util.List;

public class FamilyVO extends ValueObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int familyId;
	private String familyMemberName;
	private int familyMemberAge;
	private List<FamilyVO> familyVOs;
	private FamilyAddress familyAddress;

	/**
	 * @return the familyId
	 */
	public int getFamilyId() {
		return familyId;
	}

	/**
	 * @param familyId
	 *            the familyId to set
	 */
	public void setFamilyId(int studenrId) {
		this.familyId = studenrId;
	}

	/**
	 * @return the familyMemberName
	 */
	public String getFamilyMemberName() {
		return familyMemberName;
	}

	/**
	 * @param familyMemberName
	 *            the familyMemberName to set
	 */
	public void setFamilyMemberName(String studentName) {
		this.familyMemberName = studentName;
	}

	/**
	 * @return the familyMemberAge
	 */
	public int getFamilyMemberAge() {
		return familyMemberAge;
	}

	/**
	 * @param familyMemberAge
	 *            the familyMemberAge to set
	 */
	public void setFamilyMemberAge(int familyMemberAge) {
		this.familyMemberAge = familyMemberAge;
	}

	/**
	 * @return the familyVOs
	 */
	public List<FamilyVO> getFamilyVOs() {
		return familyVOs;
	}

	/**
	 * @param familyVOs
	 *            the familyVOs to set
	 */
	public void setFamilyVOs(List<FamilyVO> familyVOs) {
		this.familyVOs = familyVOs;
	}

	/**
	 * @return the familyAddress
	 */
	public FamilyAddress getFamilyAddress() {
		return familyAddress;
	}

	/**
	 * @param familyAddress
	 *            the familyAddress to set
	 */
	public void setFamilyAddress(FamilyAddress familyAddress) {
		this.familyAddress = familyAddress;
	}

}
