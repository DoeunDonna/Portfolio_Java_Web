<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css?family=Cute+Font" rel="stylesheet">
<link href="${conPath }/css/cusModify.css" rel="stylesheet">
</head>
<body>
<div id="cusModify">
	<jsp:include page="../main/headerLogo.jsp"/>
	<div id="all">
	<form action="${conPath }/aCusModify.do" method="post">
		<input type="hidden" name="cId" value="${aCus_level.cId }">
		
		<table id="member">
			<tr><th id="caption">${aCus_level.cNick }님 (${aCus_level.cId})</tr>
			<tr><th>레벨 변경</th></tr>
			<tr><td><input type="radio" name="lNum" value="2" required="required">배고픈 앨리스 (LEVEL 2)</td></tr>
			<tr><td><input type="radio" name="lNum" value="3">만찬중 앨리스 (LEVEL 3)</td></tr>
			<tr><td><input type="radio" name="lNum" value="4">배부른 앨리스 (LEVEL 4)</td></tr>
			<tr><td><input type="radio" name="lNum" value="1">양아치 앨리스 (LEVEL 1)</td></tr>
			<tr><td><input type="radio" name="lNum" value="5">돌아간 앨리스 (LEVEL 5)</td></tr>
		</table>
		<table id="Buttons">	
			<tr><td>
				<input type="reset" value="이전" onclick="history.go(-1)" class="Btn">
				<input type="submit" value="레벨 변경" class="Btn">
			</td>
		</table>
	</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</div>
</body>
</html>