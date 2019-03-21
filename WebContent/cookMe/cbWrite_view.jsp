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
<link href="${conPath }/css/cbWrite.css" rel="stylesheet">
</head>
<body>
<div id="writeForm">
	<jsp:include page="../main/headerLogo.jsp"/>
		<form action="${conPath }/cbWrite.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="cId" value="${cId }">
	<div id="writing">
		<table id="text">
			<tr><th>작성자</th>
				<td>${cId }</td>
			</tr>
			<tr><th>제목</th>
				<td><input type="text" name="cbSubject" required = "required" class="subject"></td>
			</tr>
		</table>
		<table id="files">
			<tr>
				<td colspan="2">사진은 최소 세장이상 첨부하셔야 합니다</td>
			</tr>
			<tr>
				<td><input type="file" name="cbFileName01" required="required">필수!</td>
				<td><textarea rows="5" cols="32" name="cbContent01" required="required" class="context">어떤디저트를 만들어볼까요?</textarea></td>
			</tr>
			<tr>
				<td><input type="file" name="cbFileName02" required="required">필수!</td>
				<td><textarea rows="5" cols="32" name="cbContent02" required="required" class="context">필요한 준비물</textarea></td>
			</tr>
			<tr>
				<td><input type="file" name="cbFileName03" required="required">필수!</td>
				<td><textarea rows="5" cols="32" name="cbContent03" required="required" class="context">요리법</textarea></td>
			</tr>
			<tr>
				<td><input type="file" name="cbFileName04"></td>
				<td><textarea rows="5" cols="32" name="cbContent04" class="context"></textarea></td>
			</tr>
			<tr>
				<td><input type="file" name="cbFileName05"></td>
				<td><textarea rows="5" cols="32" name="cbContent05" class="context"></textarea></td>
			</tr>
			<tr>
				<td><input type="file" name="cbFileName06"></td>
				<td><textarea rows="5" cols="32" name="cbContent06" class="context"></textarea></td>
			</tr>
			<tr>
				<td><input type="file" name="cbFileName07"></td>
				<td><textarea rows="5" cols="32" name="cbContent07" class="context"></textarea></td>
			</tr>
			<tr>
				<td><input type="file" name="cbFileName08"></td>
				<td><textarea rows="5" cols="32" name="cbContent08" class="context"></textarea></td>
			</tr>
			<tr>
				<td><input type="file" name="cbFileName09"></td>
				<td><textarea rows="5" cols="32" name="cbContent09" class="context"></textarea></td>
			</tr>
			<tr>
				<td><input type="file" name="cbFileName10"></td>
				<td><textarea rows="5" cols="32" name="cbContent10" class="context"></textarea></td>
			</tr>
		</table>
		<table id="Buttons">
			<tr id="Button"><td colspan="2">
				<input type="reset" value="다시쓰기" class="Btn">
				<input type="button" value="목록" onclick="location.href='${conPath }/eatMeView.do'" class="Btn">
				<input type="submit" value="글쓰기" class="Btn">
			</td></tr>
		</table>
		</div>
	</form>
	
	<jsp:include page="../main/headerButton.jsp"/>
	<jsp:include page="../main/footer.jsp"/>
</div>
</body>
</html>