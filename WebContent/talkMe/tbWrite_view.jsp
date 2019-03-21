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
<link href="${conPath }/css/ebWrite.css" rel="stylesheet">
</head>
<body>
<div id="writeForm">
	<jsp:include page="../main/headerLogo.jsp"/>
		<form action="${conPath }/tbWrite.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="cId" value="${cId }">
		<div id="writing">
		<table id="text">
			<tr><th>작성자</th>
				<td>${cId }</td>
			</tr>
			<tr><th>제목</th>
				<td><input type="text" name="tbSubject" required = "required" class="subject"></td>
			</tr>
			<tr>
				<th colspan="2">본문</th>
			</tr>
			<tr>	
				<td colspan="2"><textarea rows="5" cols="32" name="tbContent" required="required" class="context"></textarea></td>
			</tr>
			</table>
		
			<table id= "files">
			<tr>
				<td><input type="file" name="tbFileName01"></td>
			</tr>
			<tr>
				<td><input type="file" name="tbFileName02"></td>
			</tr>
			<tr>
				<td><input type="file" name="tbFileName03"></td>
			</tr>
			<tr>
				<td><input type="file" name="tbFileName04"></td>
			</tr>
			<tr>
				<td><input type="file" name="tbFileName05"></td>
			</tr>
			</table>
		
			<table id="Buttons">
			<tr id="Button"><td colspan="2">
				<input type="button" value="목록" onclick="location.href='${conPath }/talkMeView.do'" class="Btn">
				<input type="reset" value="다시쓰기" class="Btn">
				<input type="submit" value="글쓰기" class="Btn">				
		</table>
		</div>
	</form>
	<div id="button">
	<jsp:include page="../main/headerButton.jsp"/>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</div>
</body>
</html>