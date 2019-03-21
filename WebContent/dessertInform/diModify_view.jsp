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
<form action="${conPath }/diModify.do?diNum=${diModify_view.diNum }&pageNum=${param.pageNum}" method="post"  enctype="multipart/form-data">
		<input type="hidden" name="pageNum" value="${param.pageNum }">
		<input type="hidden" name="diNum" value="${diModify_view.diNum }">
		<input type="hidden" name="dbFileName01" value="${diModify_view.diFileName01 }">
		<input type="hidden" name="dbFileName02" value="${diModify_view.diFileName02 }">
		<input type="hidden" name="dbFileName03" value="${diModify_view.diFileName03 }">
		<input type="hidden" name="dbFileName04" value="${diModify_view.diFileName04 }">
		<input type="hidden" name="dbFileName05" value="${diModify_view.diFileName05 }">
		<div id="writing">
		<table id="text">
			<tr><th>작성자</th>
				<td>${aId }</td>
			</tr>
			<tr><th>제목</th>
				<td><input type="text" name="diSubject"  value="${diModify_view.diSubject }" required = "required" class="subject"></td>
			</tr>
			<tr>
				<th colspan="2">본문</th>
			</tr>
			<tr>	
				<td colspan="2"><textarea rows="5" cols="32" name="diContent" required="required"  class="context">${diModify_view.diContent }"</textarea></td>
			</tr>
			</table>
		
			<table id= "files">
			<tr>
				<td>사진은 최소 한장이상 첨부 하셔야 합니다</td>
			</tr>
			<tr>
				<td><input type="file" name="diFileName01">필수!<br>
					첨부된 파일: <a href="${conPath }/SourcePicUp/${diModify_view.diFileName01}" target="_blank">${diModify_view.diFileName01}</a></td>
			</tr>
			<tr>
				<td><input type="file" name="diFileName02" ><br>
					첨부된 파일 : <c:if test="${not empty modify_view.diFileName02 }">
						 			<a href="${conPath }/SourcePicUp/${diModify_view.diFileName02}" target="_blank">${diModify_view.diFileName02}</a>
						 		</c:if>
						 		<c:if test="${empty diModify_view.diFileName02 }">
						 			첨부파일없음
						 		</c:if></td>
			</tr>
			<tr>
				<td><input type="file" name="diFileName03" ><br>
					첨부된 파일 : <c:if test="${not empty diModify_view.diFileName03 }">
						 			<a href="${conPath }/SourcePicUp/${diModify_view.diFileName03}" target="_blank">${diModify_view.diFileName03}</a>
						 		</c:if>
						 		<c:if test="${empty diModify_view.diFileName03 }">
						 			첨부파일없음
						 		</c:if></td>
			</tr>
			<tr>
				<td><input type="file" name="diFileName04" ><br>
					첨부된 파일 : <c:if test="${not empty diModify_view.diFileName04 }">
						 			<a href="${conPath }/SourcePicUp/${diModify_view.diFileName04}" target="_blank">${diModify_view.diFileName04}</a>
						 		</c:if>
						 		<c:if test="${empty diModify_view.diFileName04 }">
						 			첨부파일없음
						 		</c:if></td>
			</tr>
			<tr>
				<td><input type="file" name="diFileName05" ><br>
					첨부된 파일 : <c:if test="${not empty diModify_view.diFileName05 }">
						 			<a href="${conPath }/SourcePicUp/${diModify_view.diFileName05}" target="_blank">${diModify_view.diFileName05}</a>
						 		</c:if>
						 		<c:if test="${empty diModify_view.diFileName05 }">
						 			첨부파일없음
						 		</c:if></td>
			</tr>
			</table>
		
			<table id="Buttons">
			<tr id="Button"><td colspan="2">
				<input type="button" value="목록" onclick="location='${conPath }/dessertInformView.do?pageNum=${param.pageNum }'" class="Btn">
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