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
<form action="${conPath }/ebModify.do?ebNum=${ebModify_view.ebNum }&pageNum=${param.pageNum}" method="post"  enctype="multipart/form-data">
		<input type="hidden" name="pageNum" value="${param.pageNum }">
		<input type="hidden" name="ebNum" value="${ebModify_view.ebNum }">
		<input type="hidden" name="dbFileName01" value="${ebModify_view.ebFileName01 }">
		<input type="hidden" name="dbFileName02" value="${ebModify_view.ebFileName02 }">
		<input type="hidden" name="dbFileName03" value="${ebModify_view.ebFileName03 }">
		<input type="hidden" name="dbFileName04" value="${ebModify_view.ebFileName04 }">
		<input type="hidden" name="dbFileName05" value="${ebModify_view.ebFileName05 }">
		<input type="hidden" name="dbFileName06" value="${ebModify_view.ebFileName06 }">
		<input type="hidden" name="dbFileName07" value="${ebModify_view.ebFileName07 }">
		<input type="hidden" name="dbFileName08" value="${ebModify_view.ebFileName08 }">
		<input type="hidden" name="dbFileName09" value="${ebModify_view.ebFileName09 }">
		<input type="hidden" name="dbFileName10" value="${ebModify_view.ebFileName10 }">
<div id="writing">
<table id="text">
			<tr><th>작성자</th>
				<td>${cId }</td>
			</tr>
			<tr><th>제목</th>
				<td><input type="text" name="ebSubject"  value="${ebModify_view.ebSubject }" required = "required" class="subject"></td>
			</tr>
			<tr>
				<th colspan="2">본문</th>
			</tr>
			<tr>	
				<td colspan="2"><textarea rows="5" cols="32" name="ebContent" required="required" class="context">${ebModify_view.ebContent }</textarea></td>
			</tr>
</table>
<table id="files">
			<tr>
				<td>사진은 최소 한장이상 첨부 하셔야 합니다</td>
			</tr>
			<tr>
				<td><input type="file" name="ebFileName01">필수!<br>
					첨부된 파일: <a href="${conPath }/SourcePicUp/${ebModify_view.ebFileName01}" target="_blank">${ebModify_view.ebFileName01}</a></td>
			</tr>
			<tr>
				<td><input type="file" name="ebFileName02" ><br>
					첨부된 파일 : <c:if test="${not empty modify_view.ebFileName02 }">
						 			<a href="${conPath }/SourcePicUp/${ebModify_view.ebFileName02}" target="_blank">${ebModify_view.ebFileName02}</a>
						 		</c:if>
						 		<c:if test="${empty ebModify_view.ebFileName02 }">
						 			첨부파일없음
						 		</c:if></td>
			</tr>
			<tr>
				<td><input type="file" name="ebFileName03" ><br>
					첨부된 파일 : <c:if test="${not empty ebModify_view.ebFileName03 }">
						 			<a href="${conPath }/SourcePicUp/${ebModify_view.ebFileName03}" target="_blank">${ebModify_view.ebFileName03}</a>
						 		</c:if>
						 		<c:if test="${empty ebModify_view.ebFileName03 }">
						 			첨부파일없음
						 		</c:if></td>
			</tr>
			<tr>
				<td><input type="file" name="ebFileName04" ><br>
					첨부된 파일 : <c:if test="${not empty ebModify_view.ebFileName04 }">
						 			<a href="${conPath }/SourcePicUp/${ebModify_view.ebFileName04}" target="_blank">${ebModify_view.ebFileName04}</a>
						 		</c:if>
						 		<c:if test="${empty ebModify_view.ebFileName04 }">
						 			첨부파일없음
						 		</c:if></td>
			</tr>
			<tr>
				<td><input type="file" name="ebFileName05" ><br>
					첨부된 파일 : <c:if test="${not empty ebModify_view.ebFileName05 }">
						 			<a href="${conPath }/SourcePicUp/${ebModify_view.ebFileName05}" target="_blank">${ebModify_view.ebFileName05}</a>
						 		</c:if>
						 		<c:if test="${empty ebModify_view.ebFileName05 }">
						 			첨부파일없음
						 		</c:if></td>
			</tr>
			<tr>
				<td><input type="file" name="ebFileName06" ><br>
					첨부된 파일 : <c:if test="${not empty ebModify_view.ebFileName06 }">
						 			<a href="${conPath }/SourcePicUp/${ebModify_view.ebFileName06}" target="_blank">${ebModify_view.ebFileName06}</a>
						 		</c:if>
						 		<c:if test="${empty ebModify_view.ebFileName06 }">
						 			첨부파일없음
						 		</c:if></td>
			</tr>
			<tr>
				<td><input type="file" name="ebFileName07" ><br>
					첨부된 파일 : <c:if test="${not empty ebModify_view.ebFileName07 }">
						 			<a href="${conPath }/SourcePicUp/${ebModify_view.ebFileName07}" target="_blank">${ebModify_view.ebFileName07}</a>
						 		</c:if>
						 		<c:if test="${empty ebModify_view.ebFileName07 }">
						 			첨부파일없음
						 		</c:if></td>
			</tr>
			<tr>
				<td><input type="file" name="ebFileName08" ><br>
					첨부된 파일 : <c:if test="${not empty ebModify_view.ebFileName08 }">
						 			<a href="${conPath }/SourcePicUp/${ebModify_view.ebFileName08}" target="_blank">${ebModify_view.ebFileName08}</a>
						 		</c:if>
						 		<c:if test="${empty ebModify_view.ebFileName08 }">
						 			첨부파일없음
						 		</c:if></td>
			</tr>
			<tr>
				<td><input type="file" name="ebFileName09" ><br>
					첨부된 파일 : <c:if test="${not empty ebModify_view.ebFileName09 }">
						 			<a href="${conPath }/SourcePicUp/${ebModify_view.ebFileName09}" target="_blank">${ebModify_view.ebFileName09}</a>
						 		</c:if>
						 		<c:if test="${empty ebModify_view.ebFileName09 }">
						 			첨부파일없음
						 		</c:if></td>
			</tr>
			<tr>
				<td><input type="file" name="ebFileName10" ><br>
					첨부된 파일 : <c:if test="${not empty ebModify_view.ebFileName10 }">
						 			<a href="${conPath }/SourcePicUp/${ebModify_view.ebFileName10}" target="_blank">${ebModify_view.ebFileName10}</a>
						 		</c:if>
						 		<c:if test="${empty ebModify_view.ebFileName10 }">
						 			첨부파일없음
						 		</c:if></td>
			</tr>
</table>
<table id="Buttons">
			<tr id="Botton"><td colspan="2">
				<input type="button" value="목록" onclick="location='${conPath }/eatMeView.do?pageNum=${param.pageNum }'" class="Btn">
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