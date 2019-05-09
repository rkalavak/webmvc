<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="welcomeMessage" /></title>
</head>
<body>
	<center>
		<h1>
			<spring:message code="welcomeMessage" />
		</h1>
	</center>
	<center>
		<form:form action="registerFamilyMember" modelAttribute="family"
			method="post">
			<table>
				<tr>
					<td><spring:message code="familyMemberName" /></td>
					<td><form:input path="familyMemberName" /></td>
				</tr>
				<tr>
					<td><spring:message code="familyMemberAge" /></td>
					<td><form:select path="familyMemberAge"
							items="${familyMemberAges}" /></td>
				</tr>
				<tr>
					<td><spring:message code="familyAddress" /></td>
					<td><form:textarea path="familyAddress.address" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Register"></td>
				</tr>
			</table>
		</form:form>
	</center>
	<br />
	<br />
	<br />
	<center>
		<c:if test="${fn:length(family.familyVOs) gt 0}">
			<table width="50%" style="text-align: left;">
				<tr>
					<th width="25%"><spring:message code="familyMemberId" /></th>
					<th width="25%"><spring:message code="familyMemberName" /></th>
					<th width="25%"><spring:message code="familyMemberAge" /></th>
					<th width="25%"><spring:message code="familyAddress" /></th>
				</tr>
				<c:forEach items="${family.familyVOs}" var="familiMember">
					<tr>
						<td width="25%"><c:out value="${familiMember.familyId}"></c:out></td>
						<td width="25%"><c:out
								value="${familiMember.familyMemberName}"></c:out></td>
						<td width="25%"><c:out
								value="${familiMember.familyMemberAge}"></c:out></td>
						<td width="25%"><c:out
								value="${familiMember.familyAddress.address}"></c:out></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</center>
</body>
</html>