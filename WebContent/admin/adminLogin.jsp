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
<link href="${conPath }/css/login.css" rel="stylesheet">

</head>
<body>
<div id="loginForm">
	<jsp:include page="../main/headerLogo.jsp"/>
	
	<form action="${conPath }/adminlogin.do" method="post">
		<table id="InformInput">
			<tr><th colspan="2">관 리 자 로 그 인</th></tr>
			<tr><th>관리자 아이디</th>
				<td><input type="text"  class="loginCus" name="aId" value="${aId }" required="required"></td>
			</tr>
			<tr><th>관리자 비밀번호</th>
				<td><input type="password"  class="loginCus" name="aPw" required="required"></td>
			</tr>
			<tr><td colspan="2" id="loginBtn">
				<input type="submit" value="로그인" class="lBtn">
			</td></tr>
		</table>
	</form>
	
	<jsp:include page="../main/footer.jsp"/>
</div>
</body>
</html>