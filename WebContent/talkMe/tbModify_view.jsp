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
<form action="${conPath }/tbModify.do?tbNum=${tbModify_view.tbNum }&pageNum=${param.pageNum}" method="post"  enctype="multipart/form-data">
		<input type="hidden" name="pageNum" value="${param.pageNum }">
		<input type="hidden" name="tbNum" value="${tbModify_view.tbNum }">
		<input type="hidden" name="dbFileName01" value="${tbModify_view.tbFileName01 }">
		<input type="hidden" name="dbFileName02" value="${tbModify_view.tbFileName02 }">
		<input type="hidden" name="dbFileName03" value="${tbModify_view.tbFileName03 }">
		<input type="hidden" name="dbFileName04" value="${tbModify_view.tbFileName04 }">
		<input type="hidden" name="dbFileName05" value="${tbModify_view.tbFileName05 }">
		
<div id="writing">
		<table id="text">
			<tr><th>작성자</th>
				<td>${cId }</td>
			</tr>
			<tr><th>제목</th>
				<td><input type="text" name="tbSubject"  value="${tbModify_view.tbSubject }" required = "required" class="subject"></td>
			</tr>
			<tr>
				<th colspan="2">본문</th>
			</tr>
			<tr>	
				<td colspan="2"><textarea rows="5" cols="32" name="tbContent" required="required" class="context">${tbModify_view.tbContent }"</textarea></td>
			</tr>
			</table>
		
			<table id= "files">
			<tr>
				<td><input type="file" name="tbFileName01" ><br>
					첨부된 파일 : <c:if test="${not empty tbModify_view.tbFileName01 }">
						 			<a href="${conPath }/SourcePicUp/${tbModify_view.tbFileName01}" target="_blank">${tbModify_view.tbFileName01}</a>
						 		</c:if>
						 		<c:if test="${empty tbModify_view.tbFileName01 }">
						 			첨부파일없음
						 		</c:if></td>
			</tr>
			<tr>
				<td><input type="file" name="tbFileName02" ><br>
					첨부된 파일 : <c:if test="${not empty tbModify_view.tbFileName02 }">
						 			<a href="${conPath }/SourcePicUp/${tbModify_view.tbFileName02}" target="_blank">${tbModify_view.tbFileName02}</a>
						 		</c:if>
						 		<c:if test="${empty tbModify_view.tbFileName02 }">
						 			첨부파일없음
						 		</c:if></td>
			</tr>
			<tr>
				<td><input type="file" name="tbFileName03" ><br>
					첨부된 파일 : <c:if test="${not empty tbModify_view.tbFileName03 }">
						 			<a href="${conPath }/SourcePicUp/${tbModify_view.tbFileName03}" target="_blank">${tbModify_view.tbFileName03}</a>
						 		</c:if>
						 		<c:if test="${empty tbModify_view.tbFileName03 }">
						 			첨부파일없음
						 		</c:if></td>
			</tr>
			<tr>
				<td><input type="file" name="tbFileName04" ><br>
					첨부된 파일 : <c:if test="${not empty tbModify_view.tbFileName04 }">
						 			<a href="${conPath }/SourcePicUp/${tbModify_view.tbFileName04}" target="_blank">${tbModify_view.tbFileName04}</a>
						 		</c:if>
						 		<c:if test="${empty tbModify_view.tbFileName04 }">
						 			첨부파일없음
						 		</c:if></td>
			</tr>
			<tr>
				<td><input type="file" name="tbFileName05" ><br>
					첨부된 파일 : <c:if test="${not empty tbModify_view.tbFileName05 }">
						 			<a href="${conPath }/SourcePicUp/${tbModify_view.tbFileName05}" target="_blank">${tbModify_view.tbFileName05}</a>
						 		</c:if>
						 		<c:if test="${empty tbModify_view.tbFileName05 }">
						 			첨부파일없음
						 		</c:if></td>
			</tr>
			</table>
		
			<table id="Buttons">
			<tr id="Button"><td colspan="2">
				<input type="button" value="목록" onclick="location='${conPath }/talkMeView.do?pageNum=${param.pageNum }'" class="Btn">
				<input type="reset" value="취소" onclick="history.back()" class="Btn">
				<input type="submit" value="수정" class="Btn">
				</td>
			</tr>
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