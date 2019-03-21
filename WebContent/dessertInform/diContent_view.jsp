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
<link href="${conPath }/css/ebContent_view.css" rel="stylesheet">
</head>
<body>
<div id="ebContent_view">
	<c:if test="${not empty resultMsg }">
		<script>alert('${resultMsg}');</script>
	</c:if>
	<c:if test="${not empty loginErrorMsg}">
		<script>
			alert('${loginErrorMsg}');
			history.back();
		</script>
	</c:if>
	<c:if test="${not empty errorMsg}">
		<script>
			alert('${errorMsg}');
			history.back();
		</script>
	</c:if>


	<jsp:include page="../main/headerLogo.jsp"/>
	
	<table id="content_view">
		<tr id="content"><td class="long">제 목 : ${diContent_view.diSubject }</td>
			
			<td class="small">작 성 일 : <fmt:formatDate value="${diContent_view.diDate }" pattern="yy.MM.dd"/> </td>	
		</tr>
		<c:if test="${ not empty diContent_view.diFileName01}"><tr><td colspan="3" class="ebCPic"><img src="${conPath }/SourcePicUp/${diContent_view.diFileName01}" alt="${diContent_view.diFileName01}"></td></tr></c:if>
		<c:if test="${ not empty diContent_view.diFileName02}"><tr><td colspan="3" class="ebCPic"><img src="${conPath }/SourcePicUp/${diContent_view.diFileName02}" alt="${diContent_view.diFileName02}"></td></tr></c:if>
		<c:if test="${ not empty diContent_view.diFileName03}"><tr><td colspan="3" class="ebCPic"><img src="${conPath }/SourcePicUp/${diContent_view.diFileName03}" alt="${diContent_view.diFileName03}"></td></tr></c:if>
		<c:if test="${ not empty diContent_view.diFileName04}"><tr><td colspan="3" class="ebCPic"><img src="${conPath }/SourcePicUp/${diContent_view.diFileName04}" alt="${diContent_view.diFileName04}"></td></tr></c:if>
		<c:if test="${ not empty diContent_view.diFileName05}"><tr><td colspan="3" class="ebCPic"><img src="${conPath }/SourcePicUp/${diContent_view.diFileName05}" alt="${diContent_view.diFileName05}"></td></tr></c:if>
		<tr><td colspan="2" class="view">${diContent_view.diContent }</td></tr>
		
		<tr><td colspan="3" class="conBtn">
		<button onclick="location.href='${conPath}/dessertInformView.do?pageNum=${param.pageNum }'" class="Btn">목록</button>
		<c:if test="${not empty admin}">
			<button onclick="location.href='${conPath}/diModify_view.do?diNum=${diContent_view.diNum }&pageNum=${param.pageNum}'" class="Btn">수정</button>		
			<button onclick="location.href='${conPath}/diDelete.do?diNum=${param.diNum }'" class="Btn">삭제</button>
		</c:if>
		</td></tr>
		
	</table>
	
	<jsp:include page="../main/headerButton.jsp"/>
	<jsp:include page="../main/footer.jsp"/>
</div>
</body>
</html>