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
<link href="${conPath }/css/cbContent_view.css" rel="stylesheet">
</head>
<body>
<div id="cbContent_view">
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
		<tr id="content"><td class="long">제 목 : ${cbContent_view.cbSubject }</td>
			<td class="middle">작 성 자 : ${cbContent_view.cNick }</td>
			<td class="small">작 성 일 : <fmt:formatDate value="${cbContent_view.cbDate }" pattern="yy.MM.dd"/> </td>	
		</tr>
		<tr><td class="cbCPic"><img src="${conPath }/SourcePicUp/${cbContent_view.cbFileName01}" alt="${cbContent_view.cbFileName01}"></td>
			<td  colspan="2" class="conPic">${cbContent_view.cbContent01.replaceAll("\\r\\n","<br>") }</td>
		</tr>
		<tr><td class="cbCPic"><img src="${conPath }/SourcePicUp/${cbContent_view.cbFileName02}" alt="${cbContent_view.cbFileName02}"></td>
			<td  colspan="2" class="conPic">${cbContent_view.cbContent02.replaceAll("\\r\\n","<br>") }</td>
		</tr>
		<tr><td class="cbCPic"><img src="${conPath }/SourcePicUp/${cbContent_view.cbFileName03}" alt="${cbContent_view.cbFileName03}"></td>
			<td  colspan="2" class="conPic">${cbContent_view.cbContent03.replaceAll("\\r\\n","<br>") }</td>
		</tr>
		<c:if test="${ not empty cbContent_view.cbFileName04}"><tr><td class="cbCPic"><img src="${conPath }/SourcePicUp/${cbContent_view.cbFileName04}" alt="${cbContent_view.cbFileName04}"></td>
																	<td colspan="2" class="conPic">${cbContent_view.cbContent04.replaceAll("\\r\\n","<br>") }</td>
																</tr></c:if>
		<c:if test="${ not empty cbContent_view.cbFileName05}"><tr><td class="cbCPic"><img src="${conPath }/SourcePicUp/${cbContent_view.cbFileName05}" alt="${cbContent_view.cbFileName05}"></td>
																	<td colspan="2" class="conPic">${cbContent_view.cbContent05.replaceAll("\\r\\n","<br>") }</td>
																</tr></c:if>
		<c:if test="${ not empty cbContent_view.cbFileName06}"><tr><td class="cbCPic"><img src="${conPath }/SourcePicUp/${cbContent_view.cbFileName06}" alt="${cbContent_view.cbFileName06}"></td>
																	<td colspan="2" class="conPic">${cbContent_view.cbContent06.replaceAll("\\r\\n","<br>") }</td>
																</tr></c:if>
		<c:if test="${ not empty cbContent_view.cbFileName07}"><tr><td class="cbCPic"><img src="${conPath }/SourcePicUp/${cbContent_view.cbFileName07}" alt="${cbContent_view.cbFileName07}"></td>
																	<td colspan="2" class="conPic">${cbContent_view.cbContent07.replaceAll("\\r\\n","<br>") }</td>
																</tr></c:if>
		<c:if test="${ not empty cbContent_view.cbFileName08}"><tr><td class="cbCPic"><img src="${conPath }/SourcePicUp/${cbContent_view.cbFileName08}" alt="${cbContent_view.cbFileName08}"></td>
																	<td colspan="2" class="conPic">${cbContent_view.cbContent08.replaceAll("\\r\\n","<br>") }</td>
																</tr></c:if>
		<c:if test="${ not empty cbContent_view.cbFileName09}"><tr><td class="cbCPic"><img src="${conPath }/SourcePicUp/${cbContent_view.cbFileName09}" alt="${cbContent_view.cbFileName09}"></td>
																	<td colspan="2" class="conPic">${cbContent_view.cbContent09.replaceAll("\\r\\n","<br>") }</td>
																</tr></c:if>
		<c:if test="${ not empty cbContent_view.cbFileName10}"><tr><td class="cbCPic"><img src="${conPath }/SourcePicUp/${cbContent_view.cbFileName10}" alt="${cbContent_view.cbFileName10}"></td>
																	<td colspan="2" class="conPic">${cbContent_view.cbContent10.replaceAll("\\r\\n","<br>") }</td>
																</tr></c:if>
		
		<tr><td colspan="3" class="conBtn">
		<button onclick="location.href='${conPath}/cookMeView.do?pageNum=${param.pageNum }'" class="Btn">목록</button>
		<c:if test="${customer.cId eq cbContent_view.cId}">
			<button onclick="location.href='${conPath}/cbModify_view.do?cbNum=${cbContent_view.cbNum }&pageNum=${param.pageNum}'" class="Btn">수정</button>		
			<button onclick="location.href='${conPath}/cbDelete.do?cbNum=${param.cbNum }'" class="Btn">삭제</button>
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