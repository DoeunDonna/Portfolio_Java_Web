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
	<c:if test="${not empty errorMsg }">
		<script>
			alert('${errorMsg}');
			history.back();
		</script>
	</c:if>
	<c:if test="${not empty msg }">
		<script>
			alert('${msg}');
		</script>
	</c:if>
	
	<jsp:include page="../main/headerLogo.jsp"/>
	
	<form action="${conPath }/login.do" method="post">
		<table id="InformInput">
			<tr><th colspan="2">로 그 인</th></tr>
			<tr><th>아 이 디</th>
				<td><input type="text" class="loginCus" name="cId" value="${cId }" required="required"></td>
			</tr>
			<tr><th>비 밀 번 호</th>
				<td><input type="password" class="loginCus" name="cPw" required="required"></td>
			</tr>
			<tr><td colspan="2" id="loginBtn">
				<input type="button" value="회 원 가 입" class="lBtn" onclick="location.href='${conPath}/joinView.do'">
				<input type="submit" value="로 그 인" class="lBtn">
		</table>
	</form>
	
	<jsp:include page="../main/footer.jsp"/>
</div>
</body>
</html>