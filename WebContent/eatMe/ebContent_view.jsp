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
		<tr id="content"><td class="long">제 목 : ${ebContent_view.ebSubject }</td>
			<td class="middle">작 성 자 : ${ebContent_view.cNick }</td>
			<td class="small">작 성 일 : <fmt:formatDate value="${ebContent_view.ebDate }" pattern="yy.MM.dd"/> </td>	
		</tr>
		<c:if test="${ not empty ebContent_view.ebFileName01}"><tr><td colspan="3" class="ebCPic"><img src="${conPath }/SourcePicUp/${ebContent_view.ebFileName01}" alt="${ebContent_view.ebFileName01}"></td></tr></c:if>
		<c:if test="${ not empty ebContent_view.ebFileName02}"><tr><td colspan="3" class="ebCPic"><img src="${conPath }/SourcePicUp/${ebContent_view.ebFileName02}" alt="${ebContent_view.ebFileName02}"></td></tr></c:if>
		<c:if test="${ not empty ebContent_view.ebFileName03}"><tr><td colspan="3" class="ebCPic"><img src="${conPath }/SourcePicUp/${ebContent_view.ebFileName03}" alt="${ebContent_view.ebFileName03}"></td></tr></c:if>
		<c:if test="${ not empty ebContent_view.ebFileName04}"><tr><td colspan="3" class="ebCPic"><img src="${conPath }/SourcePicUp/${ebContent_view.ebFileName04}" alt="${ebContent_view.ebFileName04}"></td></tr></c:if>
		<c:if test="${ not empty ebContent_view.ebFileName05}"><tr><td colspan="3" class="ebCPic"><img src="${conPath }/SourcePicUp/${ebContent_view.ebFileName05}" alt="${ebContent_view.ebFileName05}"></td></tr></c:if>
		<c:if test="${ not empty ebContent_view.ebFileName06}"><tr><td colspan="3" class="ebCPic"><img src="${conPath }/SourcePicUp/${ebContent_view.ebFileName06}" alt="${ebContent_view.ebFileName06}"></td></tr></c:if>
		<c:if test="${ not empty ebContent_view.ebFileName07}"><tr><td colspan="3" class="ebCPic"><img src="${conPath }/SourcePicUp/${ebContent_view.ebFileName07}" alt="${ebContent_view.ebFileName07}"></td></tr></c:if>
		<c:if test="${ not empty ebContent_view.ebFileName08}"><tr><td colspan="3" class="ebCPic"><img src="${conPath }/SourcePicUp/${ebContent_view.ebFileName08}" alt="${ebContent_view.ebFileName08}"></td></tr></c:if>
		<c:if test="${ not empty ebContent_view.ebFileName09}"><tr><td colspan="3" class="ebCPic"><img src="${conPath }/SourcePicUp/${ebContent_view.ebFileName09}" alt="${ebContent_view.ebFileName09}"></td></tr></c:if>
		<c:if test="${ not empty ebContent_view.ebFileName10}"><tr><td colspan="3" class="ebCPic"><img src="${conPath }/SourcePicUp/${ebContent_view.ebFileName10}" alt="${ebContent_view.ebFileName10}"></td></tr></c:if>
		<tr><td colspan="3" class="view">${ebContent_view.ebContent.replaceAll("\\r\\n","<br>") }</td></tr>
		
		<tr><td colspan="3" class="conBtn">
		<button onclick="location.href='${conPath}/eatMeView.do?pageNum=${param.pageNum }'" class="Btn">목록</button>
		<c:if test="${customer.cId eq ebContent_view.cId}">
			<button onclick="location.href='${conPath}/ebModify_view.do?ebNum=${ebContent_view.ebNum }&pageNum=${param.pageNum}'" class="Btn">수정</button>		
			<button onclick="location.href='${conPath}/ebDelete.do?ebNum=${param.ebNum }'" class="Btn">삭제</button>
		</c:if>
		<c:if test="${not empty admin }">
			<button onclick="location.href='${conPath}/ebDelete.do?ebNum=${param.ebNum }'" class="Btn">관리자 권한으로 삭제</button>
		</c:if>
		</td></tr>
		
	</table>
	
	<jsp:include page="../main/headerButton.jsp"/>
	<jsp:include page="../main/footer.jsp"/>
</div>	
</body>
</html>