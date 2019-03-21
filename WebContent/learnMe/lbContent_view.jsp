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
<link href="${conPath }/css/lbContent_view.css" rel="stylesheet">
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
	<div id="all">
	<table id="content_view">
		<tr id="content"><td class="long">강 의 명 : ${lbContent_view.lbSubject }</td>
			<td class="middle">
				<c:if test="${lbContent_view.cId != null }">
					작 성 자 : ${lbContent_view.cNick }
				</c:if>
				<c:if test="${lbContent_view.aId != null }">
					작 성 자 : ${lbContent_view.aName }
				</c:if>
			</td>
			<td class="small">작 성 일 : <fmt:formatDate value="${lbContent_view.lbDate }" pattern="yy.MM.dd"/> </td>	
		</tr>
		<c:if test="${ not empty lbContent_view.lbFileName01}"><tr><td colspan="3" class="pic"><img src="${conPath }/SourcePicUp/${lbContent_view.lbFileName01}" alt="${lbContent_view.lbFileName01}" class="ebCPic"></td></tr></c:if>
		<c:if test="${ not empty lbContent_view.lbFileName02}"><tr><td colspan="3" class="pic"><img src="${conPath }/SourcePicUp/${lbContent_view.lbFileName02}" alt="${lbContent_view.lbFileName02}" class="ebCPic"></td></tr></c:if>
		<c:if test="${ not empty lbContent_view.lbFileName03}"><tr><td colspan="3" class="pic"><img src="${conPath }/SourcePicUp/${lbContent_view.lbFileName03}" alt="${lbContent_view.lbFileName03}" class="ebCPic"></td></tr></c:if>
		
		<tr><td colspan="3" class="view">${lbContent_view.lbContent.replaceAll("\\r\\n","<br>") }</td></tr>
		<tr><td colspan="3" class="conBtn">
		<button onclick="location.href='${conPath}/learnMeView.do?pageNum=${param.pageNum }'" class="Btn">목록</button>
		<c:if test="${customer.cId == lbContent_view.cId && (lbContent_view.cId == '' || admin.aId == lbContent_view.aId)}">
			<button onclick="location.href='${conPath}/lbModify_view.do?lbNum=${lbContent_view.lbNum }&pageNum=${param.pageNum}'" class="Btn">수정</button>		
			<button onclick="location.href='${conPath}/lbDelete.do?lbNum=${param.lbNum }'" class="Btn">삭제</button>
		</c:if>
		<c:if test="${not empty admin && admin.aId != lbContent_view.aId}">
			<button onclick="location.href='${conPath}/lbDelete.do?lbNum=${param.lbNum }'" class="Btn">관리자 권한으로 삭제</button>
		</c:if>
		</td></tr>
	</table>
	
	
	<div id="reply">
	<table>
		<tr><td id="replier">작성자</td><td id="replytext">댓글</td><td id="replydate">작성일</td></tr>
		<c:forEach var="dto" items="${rlist }">
			<tr>
				<td id="cusNick">${dto.cId }</td>
				<td>${dto.rMemo }</td>
				<td id="cusDate">${dto.rDate }</td>
			</tr>
		</c:forEach>
	</table>
	<c:if test="${not empty customer}">
	
	<form action="${conPath }/lbRegister.do" method="post">
		<table id="replyText">
			<input type="hidden" name="lbNum" value="${lbContent_view.lbNum }">
			<input type="hidden" name="cId" value="${customer.cId }">
			<tr><td id="form">댓글쓰기</td>
				<td><input type="text" name="rMemo" required="required" id="write"></td>
				<td><input type="submit" value="등록" class="Btn"></td>
		</table>
	</form>
	</c:if>
	</div>
	</div>	
	<jsp:include page="../main/headerButton.jsp"/>
	<jsp:include page="../main/footer.jsp"/>
</div>
</body>
</html>