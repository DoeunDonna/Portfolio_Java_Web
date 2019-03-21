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
		<tr id="content"><td class="long">제 목 : ${tbContent_view.tbSubject }</td>
			<td class="middle">작 성 자 : ${tbContent_view.cNick }</td>
			<td class="small">작 성 일 :<fmt:formatDate value="${tbContent_view.tbDate }" pattern="yy.MM.dd"/> </td>	
		</tr>
		<c:if test="${ not empty tbContent_view.tbFileName01}"><tr><td colspan="3" class="ebCPic"><img src="${conPath }/SourcePicUp/${tbContent_view.tbFileName01}" alt="${tbContent_view.tbFileName01}"></td></tr></c:if>
		<c:if test="${ not empty tbContent_view.tbFileName02}"><tr><td colspan="3" class="ebCPic"><img src="${conPath }/SourcePicUp/${tbContent_view.tbFileName02}" alt="${tbContent_view.tbFileName02}"></td></tr></c:if>
		<c:if test="${ not empty tbContent_view.tbFileName03}"><tr><td colspan="3" class="ebCPic"><img src="${conPath }/SourcePicUp/${tbContent_view.tbFileName03}" alt="${tbContent_view.tbFileName03}"></td></tr></c:if>
		<c:if test="${ not empty tbContent_view.tbFileName04}"><tr><td colspan="3" class="ebCPic"><img src="${conPath }/SourcePicUp/${tbContent_view.tbFileName04}" alt="${tbContent_view.tbFileName04}"></td></tr></c:if>
		<c:if test="${ not empty tbContent_view.tbFileName05}"><tr><td colspan="3" class="ebCPic"><img src="${conPath }/SourcePicUp/${tbContent_view.tbFileName05}" alt="${tbContent_view.tbFileName05}"></td></tr></c:if>
		<tr><td colspan="3" class="view">${tbContent_view.tbContent.replaceAll("\\r\\n","<br>") }</td></tr>
		
		<tr><td colspan="3" class="conBtn">
		<button onclick="location.href='${conPath}/talkMeView.do?pageNum=${param.pageNum }'" class="Btn">목록</button>
		
		
		
		<c:if test="${not empty customer }">
			<c:if test="${customer.cNick == tbContent_view.cNick}">
				<button onclick="location.href='${conPath}/tbDelete.do?tbNum=${param.tbNum }'" class="Btn">삭제</button>
				<button onclick="location.href='${conPath}/tbModify_view.do?tbNum=${tbContent_view.tbNum }&pageNum=${param.pageNum}'" class="Btn">수정</button>				
			</c:if>
			<c:if test="${customer.cId != tbContent_view.cId }">
				<button onclick="location.href='${conPath}/tbReply_view.do?tbNum=${tbContent_view.tbNum }&pageNum=${param.pageNum}'" class="Btn">답변</button>
			</c:if>
			<c:if test="${not empty admin }">
			<button onclick="location.href='${conPath}/ebDelete.do?ebNum=${param.ebNum }'" class="Btn">권리자 권한으로 삭제</button>
		</c:if>
		</c:if>
		</td></tr>
		
	</table>
	
	<jsp:include page="../main/headerButton.jsp"/>
	<jsp:include page="../main/footer.jsp"/>
</div>
</body>
</html>