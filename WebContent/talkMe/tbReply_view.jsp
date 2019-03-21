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
<link href="${conPath }/css/tbWrite.css" rel="stylesheet">
</head>
<body>
<div id="writeForm">
<jsp:include page="../main/headerLogo.jsp"/>
<div id="writing">
	<form action="${conPath }/tbReply.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="tbNum" value="${tbReply_view.tbNum }">
		<input type="hidden" name="cId" value="${customer.cId }">
		<input type="hidden" name="cNick" value="${customer.cNick }">
 		<input type="hidden" name="tbGroup" value="${tbReply_view.tbGroup }">
		<input type="hidden" name="tbStep" value="${tbReply_view.tbStep }">
		<input type="hidden" name="tbIndent" value="${tbReply_view.tbIndent }">
		<input type="hidden" name="pageNum" value="${tbRaram.pageNum }">
		
		<table id="text">
			<tr><td colspan="2">"${tbReply_view.tbSubject}" 답변쓰기</td></tr>
			<tr><td class="form">제목</td>
				<td><input type="text" name="tbSubject"
							required="required" value="[답]${tbReply_view.tbSubject }" class="subject"></td></tr>
			<tr><td class="form">답변</td>
				<td><textarea name="tbContent" rows="3" 
							required="required" cols="32" class="context"></textarea></td></tr>
			</table>
		
			<table id= "files">
			<tr><td>사진첨부<input type="file" name="tbFileName01"></td></tr>
			<tr><td>사진첨부<input type="file" name="tbFileName02"></td></tr>
			<tr><td>사진첨부<input type="file" name="tbFileName03"></td></tr>
			<tr><td>사진첨부<input type="file" name="tbFileName04"></td></tr>
			<tr><td>사진첨부<input type="file" name="tbFileName05"></td></tr>
			</table>
		
			<table id="Buttons">
			<tr id=""><td colspan="2">
			<input type="button" value="목록"
							onclick="location.href='${conPath}/tbList.do'" class="Btn">	
			<input type="reset" value="다시쓰기" class="Btn">
			<input type="submit" value="답변쓰기" class="Btn">					
		</table>		
	</form>
</div>
<div id="button">
	<jsp:include page="../main/headerButton.jsp"/>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</div>
</body>
</html>