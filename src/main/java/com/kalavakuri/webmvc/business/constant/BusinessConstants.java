package com.kalavakuri.webmvc.business.constant;

public class BusinessConstants {

	public static final String FAMILY_INSERT_QUERY = "INSERT INTO FAMILY(FAMILY_ID, FAMILY_MEMBER_NAME, FAMILY_MEMBER_AGE) VALUES (?,?,?)";
	public static final String FAMILY_SELECT_QUERY = "SELECT FAMILY_ID, FAMILY_MEMBER_NAME, FAMILY_MEMBER_AGE FROM FAMILY ORDER BY FAMILY_ID";
	public static final String FAMILY_MEMBER_COUNT = "SELECT NVL(MAX(FAMILY_ID),0) + 1 AS FAMILY_MEMBER_COUNT FROM FAMILY";
	public static final String FAMILY_FAMILY_ID = "FAMILY_ID";
	public static final String FAMILY_FAMILY_MEMBER_NAME = "FAMILY_MEMBER_NAME";
	public static final String FAMILY_FAMILY_MEMBER_AGE = "FAMILY_MEMBER_AGE";
}
