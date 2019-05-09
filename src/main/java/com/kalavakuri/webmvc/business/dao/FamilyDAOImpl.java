package com.kalavakuri.webmvc.business.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kalavakuri.webmvc.business.constant.BusinessConstants;
import com.kalavakuri.webmvc.business.util.BusinessUtil;
import com.kalavakuri.webmvc.business.valueobject.FamilyVO;

@Repository
public class FamilyDAOImpl implements FamilyDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public void saveFamilyMember(FamilyVO familyVO) {

		jdbcTemplate.update(BusinessConstants.FAMILY_INSERT_QUERY, BusinessUtil.createInsertFamily(familyVO));
	}

	@Override
	public List<FamilyVO> getAllFamilyMembers() {

		return jdbcTemplate.query(BusinessConstants.FAMILY_SELECT_QUERY, this::familyRowMapper);
	}

	private FamilyVO familyRowMapper(ResultSet resultSet, int rowNum) throws SQLException {

		FamilyVO familyVO = new FamilyVO();
		familyVO.setFamilyId(resultSet.getInt(BusinessConstants.FAMILY_FAMILY_ID));
		familyVO.setFamilyMemberName(resultSet.getString(BusinessConstants.FAMILY_FAMILY_MEMBER_NAME));
		familyVO.setFamilyMemberAge(resultSet.getInt(BusinessConstants.FAMILY_FAMILY_MEMBER_AGE));

		return familyVO;
	}
}
