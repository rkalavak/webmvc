package com.kalavakuri.webmvc.business.constant;

public class BusinessConstants {

	public static final String FAMILY_INSERT_QUERY = "INSERT INTO FAMILY(FAMILY_ID, FAMILY_MEMBER_NAME, FAMILY_MEMBER_AGE) VALUES (?,?,?)";
	public static final String FAMILY_SELECT_QUERY = "SELECT FAMILY_ID, FAMILY_MEMBER_NAME, FAMILY_MEMBER_AGE FROM FAMILY";
	public static final String FAMILY_FAMILY_ID = "FAMILY_ID";
	public static final String FAMILY_FAMILY_MEMBER_NAME = "FAMILY_MEMBER_NAME";
	public static final String FAMILY_FAMILY_MEMBER_AGE = "FAMILY_MEMBER_AGE";
}
