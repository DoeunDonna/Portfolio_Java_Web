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
		<form action="${conPath }/diWrite.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="aId" value="${aId }">
		<div id="writing">
		<table id="text">
			<tr><th>작성자</th>
				<td>${aId }</td>
			</tr>
			<tr><th>제목</th>
				<td><input type="text" name="diSubject" required = "required" class="subject"></td>
			</tr>
			<tr>
				<th colspan="2">본문</th>
			</tr>
			<tr>	
				<td colspan="2"><textarea rows="5" cols="32" name="diContent" required="required" class="context"></textarea></td>
			</tr>
			</table>
		
			<table id= "files">
			<tr>
				<td>사진은 최소 한장이상 첨부 하셔야 합니다</td>
			</tr>
			<tr>
				<td><input type="file" name="diFileName01" required="required">필수!</td>
			</tr>
			<tr>
				<td><input type="file" name="diFileName02"></td>
			</tr>
			<tr>
				<td><input type="file" name="diFileName03"></td>
			</tr>
			<tr>
				<td><input type="file" name="diFileName04"></td>
			</tr>
			<tr>
				<td><input type="file" name="diFileName05"></td>
			</tr>
			</table>
		
			<table id="Buttons">
			<tr id="Button"><td colspan="2">
				<input type="button" value="목록" onclick="location.href='${conPath }/dessertInformView.do'" class="Btn">
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