<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="welcomeMessage"/> </title>
</head>
<body>
<center><h1><spring:message code="welcomeMessage"/> </h1></center>
<center>
	<table border="1">
		<c:forEach items="${family.familyVOs}" var="familiMember">
			<tr>
				<td width="25%"><c:out value="${familiMember.familyId}"></c:out></td>
				<td width="50%"><c:out value="${familiMember.familyMemberName}"></c:out></td>
				<td width="25%"><c:out value="${familiMember.familyMemberAge}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
</center>
</body>
</html>