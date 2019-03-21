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
<form action="${conPath }/cbModify.do?cbNum=${cbModify_view.cbNum }&pageNum=${param.pageNum}" method="post"  enctype="multipart/form-data">
		<input type="hidden" name="pageNum" value="${param.pageNum }">
		<input type="hidden" name="cbNum" value="${cbModify_view.cbNum }">
		<input type="hidden" name="dbFileName01" value="${cbModify_view.cbFileName01 }">
		<input type="hidden" name="dbFileName02" value="${cbModify_view.cbFileName02 }">
		<input type="hidden" name="dbFileName03" value="${cbModify_view.cbFileName03 }">
		<input type="hidden" name="dbFileName04" value="${cbModify_view.cbFileName04 }">
		<input type="hidden" name="dbFileName05" value="${cbModify_view.cbFileName05 }">
		<input type="hidden" name="dbFileName06" value="${cbModify_view.cbFileName06 }">
		<input type="hidden" name="dbFileName07" value="${cbModify_view.cbFileName07 }">
		<input type="hidden" name="dbFileName08" value="${cbModify_view.cbFileName08 }">
		<input type="hidden" name="dbFileName09" value="${cbModify_view.cbFileName09 }">
		<input type="hidden" name="dbFileName10" value="${cbModify_view.cbFileName10 }">
<div id="writing">		
<table id="text">
			<tr><th>작성자</th>
				<td>${cId }</td>
			</tr>
			<tr><th>제목</th>
				<td><input type="text" name="cbSubject"  value="${cbModify_view.cbSubject }" required = "required" class="subject"></td>
			</tr>
			</table>
			<table id="files">
			<tr>
				<td colspan="2">사진은 세장이상 첨부</td>
			</tr>
			<tr>
				<td><input type="file" name="cbFileName01">필수!<br>
					첨부된 파일: <a href="${conPath }/SourcePicUp/${cbModify_view.cbFileName01}" target="_blank">${cbModify_view.cbFileName01}</a></td>	
				<td><textarea rows="5" cols="32" name="cbContent01" required="required" class="context">${cbModify_view.cbContent01 }"</textarea></td>
			</tr>
			<tr>
				<td><input type="file" name="cbFileName02">필수!<br>
					첨부된 파일: <a href="${conPath }/SourcePicUp/${cbModify_view.cbFileName02}" target="_blank">${cbModify_view.cbFileName02}</a></td>	
				<td><textarea rows="5" cols="32" name="cbContent02" required="required" class="context">${cbModify_view.cbContent02 }"</textarea></td>
			</tr>
			<tr>
				<td><input type="file" name="cbFileName03">필수!<br>
					첨부된 파일: <a href="${conPath }/SourcePicUp/${cbModify_view.cbFileName03}" target="_blank">${cbModify_view.cbFileName03}</a></td>	
				<td><textarea rows="5" cols="32" name="cbContent03" required="required" class="context">${cbModify_view.cbContent03 }"</textarea></td>
			</tr>
			<tr>
				<td><input type="file" name="cbFileName04" ><br>
					첨부된 파일 : <c:if test="${not empty cbModify_view.cbFileName04 }">
						 			<a href="${conPath }/SourcePicUp/${cbModify_view.cbFileName04}" target="_blank">${cbModify_view.cbFileName04}</a>
						 		</c:if>
						 		<c:if test="${empty cbModify_view.cbFileName04 }">
						 			첨부파일없음
						 		</c:if></td>
					<td><textarea rows="5" cols="32" name="cbContent04" class="context">${cbModify_view.cbContent04 }"</textarea></td>
			</tr>
			<tr>
				<td><input type="file" name="cbFileName05" ><br>
					첨부된 파일 : <c:if test="${not empty cbModify_view.cbFileName05 }">
						 			<a href="${conPath }/SourcePicUp/${cbModify_view.cbFileName05}" target="_blank">${cbModify_view.cbFileName05}</a>
						 		</c:if>
						 		<c:if test="${empty cbModify_view.cbFileName05 }">
						 			첨부파일없음
						 		</c:if></td>
					<td><textarea rows="5" cols="32" name="cbContent05" class="context">${cbModify_view.cbContent05 }"</textarea></td>
			</tr>
			<tr>
				<td><input type="file" name="cbFileName06" ><br>
					첨부된 파일 : <c:if test="${not empty cbModify_view.cbFileName06 }">
						 			<a href="${conPath }/SourcePicUp/${cbModify_view.cbFileName06}" target="_blank">${cbModify_view.cbFileName06}</a>
						 		</c:if>
						 		<c:if test="${empty cbModify_view.cbFileName06 }">
						 			첨부파일없음
						 		</c:if></td>
					<td><textarea rows="5" cols="32" name="cbContent06" class="context">${cbModify_view.cbContent06 }"</textarea></td>
			</tr>
			<tr>
				<td><input type="file" name="cbFileName07" ><br>
					첨부된 파일 : <c:if test="${not empty cbModify_view.cbFileName07 }">
						 			<a href="${conPath }/SourcePicUp/${cbModify_view.cbFileName07}" target="_blank">${cbModify_view.cbFileName07}</a>
						 		</c:if>
						 		<c:if test="${empty cbModify_view.cbFileName07 }">
						 			첨부파일없음
						 		</c:if></td>
					<td><textarea rows="5" cols="32" name="cbContent07" class="context">${cbModify_view.cbContent07 }"</textarea></td>
			</tr>
			<tr>
				<td><input type="file" name="cbFileName08" ><br>
					첨부된 파일 : <c:if test="${not empty cbModify_view.cbFileName08 }">
						 			<a href="${conPath }/SourcePicUp/${cbModify_view.cbFileName08}" target="_blank">${cbModify_view.cbFileName08}</a>
						 		</c:if>
						 		<c:if test="${empty cbModify_view.cbFileName08 }">
						 			첨부파일없음
						 		</c:if></td>
					<td><textarea rows="5" cols="32" name="cbContent08" class="context">${cbModify_view.cbContent08 }"</textarea></td>
			</tr>
			<tr>
				<td><input type="file" name="cbFileName09" ><br>
					첨부된 파일 : <c:if test="${not empty cbModify_view.cbFileName09 }">
						 			<a href="${conPath }/SourcePicUp/${cbModify_view.cbFileName09}" target="_blank">${cbModify_view.cbFileName09}</a>
						 		</c:if>
						 		<c:if test="${empty cbModify_view.cbFileName09 }">
						 			첨부파일없음
						 		</c:if></td>
				<td><textarea rows="5" cols="32" name="cbContent09" class="context">${cbModify_view.cbContent09 }"</textarea></td>
			</tr>
			<tr>
				<td><input type="file" name="cbFileName10" ><br>
					첨부된 파일 : <c:if test="${not empty cbModify_view.cbFileName10 }">
						 			<a href="${conPath }/SourcePicUp/${cbModify_view.cbFileName10}" target="_blank">${cbModify_view.cbFileName10}</a>
						 		</c:if>
						 		<c:if test="${empty cbModify_view.cbFileName10 }">
						 			첨부파일없음
						 		</c:if></td>
				<td><textarea rows="5" cols="32" name="cbContent10" class="context">${cbModify_view.cbContent10 }"</textarea></td>
			</tr>
			</table>
			<table id="Buttons">
			<tr id="Button"><td colspan="2">
				<input type="button" value="목록" onclick="location='${conPath }/cookMeView.do?pageNum=${param.pageNum }'" class="Btn">
				<input type="reset" value="취소" onclick="history.back()" class="Btn">
				<input type="submit" value="수정" class="Btn">
				</td>
			</tr>
		</table>
		</div>
	</form>
		<jsp:include page="../main/headerButton.jsp"/>
		<jsp:include page="../main/footer.jsp"/>
</div>
</body>
</html>