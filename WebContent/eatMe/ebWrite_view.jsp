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
		<form action="${conPath }/ebWrite.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="cId" value="${cId }">
		<div id="writing">
		<table id="text">
			<tr><th>작성자</th>
				<td>${cId }</td>
			</tr>
			<tr><th>제목</th>
				<td><input type="text" name="ebSubject" required = "required" class="subject"></td>
			</tr>
			<tr>
				<th colspan="2">본문</th>
			</tr>
			<tr>	
				<td colspan="2"><textarea rows="5" cols="32" name="ebContent" required="required" class="context"></textarea></td>
			</tr>
		</table>
		
		<table id= "files">
			<tr>
				<td colspan="2">사진은 최소 한장이상 첨부 하셔야 합니다</td>
			</tr>
			<tr>
				<td colspan="2"  class="fileInput"><input type="file" name="ebFileName01" required="required">필수!</td>
			</tr>
			<tr>
				<td colspan="2"><input type="file" name="ebFileName02" class="fileInput"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="file" name="ebFileName03"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="file" name="ebFileName04"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="file" name="ebFileName05"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="file" name="ebFileName06"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="file" name="ebFileName07"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="file" name="ebFileName08"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="file" name="ebFileName09"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="file" name="ebFileName10"></td>
			</tr>
		</table>
		
		<table id="Buttons">	
			<tr id="Botton"><td colspan="2">
				<input type="reset" value="다시쓰기" class="Btn">
				<input type="button" value="목록" onclick="location.href='${conPath }/eatMeView.do'" class="Btn">
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