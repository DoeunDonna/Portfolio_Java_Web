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
<form action="${conPath }/lbModify.do?lbNum=${lbModify_view.lbNum }&pageNum=${param.pageNum}" method="post"  enctype="multipart/form-data">
		<input type="hidden" name="pageNum" value="${param.pageNum }">
		<input type="hidden" name="lbNum" value="${lbModify_view.lbNum }">
		<input type="hidden" name="dbFileName01" value="${lbModify_view.lbFileName01 }">
		<input type="hidden" name="dbFileName02" value="${lbModify_view.lbFileName02 }">
		<input type="hidden" name="dbFileName03" value="${lbModify_view.lbFileName03 }">
		
<div id="writing">		
<table id="text">
			<tr><th>작성자</th>
				<td>
					<c:if test="${lbModify_view.cId != null}">
						${cNick }
					</c:if>
					<c:if test="${lbModify_view.aId != null}">
						${aName }
					</c:if>
				</td>
			</tr>
			<tr><th>제목</th>
				<td><input type="text" name="lbSubject"  value="${lbModify_view.lbSubject }" required = "required" class="subject"></td>
			</tr>
			<tr>
				<th colspan="2">본문</th>
			</tr>
			<tr>	
				<td colspan="2"><textarea rows="5" cols="32" name="lbContent" required="required" class="context">${lbModify_view.lbContent }"</textarea></td>
			</tr>
			</table>
			<table id="files">
			<tr>
				<td><input type="file" name="lbFileName01" ><br>
					첨부된 파일 : <c:if test="${not empty lbModify_view.lbFileName01 }">
						 			<a href="${conPath }/SourcePicUp/${lbModify_view.lbFileName01}" target="_blank">${lbModify_view.lbFileName01}</a>
						 		</c:if>
						 		<c:if test="${empty lbModify_view.lbFileName01 }">
						 			첨부파일없음
						 		</c:if></td>
			</tr>
			<tr>
				<td><input type="file" name="lbFileName02" ><br>
					첨부된 파일 : <c:if test="${not empty lbModify_view.lbFileName02 }">
						 			<a href="${conPath }/SourcePicUp/${lbModify_view.lbFileName02}" target="_blank">${lbModify_view.lbFileName02}</a>
						 		</c:if>
						 		<c:if test="${empty lbModify_view.lbFileName02 }">
						 			첨부파일없음
						 		</c:if></td>
			</tr>
			<tr>
				<td><input type="file" name="lbFileName03" ><br>
					첨부된 파일 : <c:if test="${not empty lbModify_view.lbFileName03 }">
						 			<a href="${conPath }/SourcePicUp/${lbModify_view.lbFileName03}" target="_blank">${lbModify_view.lbFileName03}</a>
						 		</c:if>
						 		<c:if test="${empty lbModify_view.lbFileName03 }">
						 			첨부파일없음
						 		</c:if></td>
			</tr>
			</table>
			<table id="Buttons">
			<tr id="Button"><td colspan="2">
				<input type="button" value="목록" onclick="location='${conPath }/learnMeView.do?pageNum=${param.pageNum }'" class="Btn">
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