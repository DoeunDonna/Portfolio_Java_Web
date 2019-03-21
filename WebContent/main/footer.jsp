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
<style>
	footer #footer_img img{
		width:100%;
	}
</style>
</head>
<body>
	<footer>
		<div id="footer_img">
			<img src="${conPath }/SourceImg/FOOTER.png">
		</div>
	</footer>
</body>
</html>