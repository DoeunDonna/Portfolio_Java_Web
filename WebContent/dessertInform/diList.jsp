<%@page import="com.tj.dessert.dao.DessertInformDao"%>
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
<link href="${conPath }/css/DessertInform.css" rel="stylesheet">
<script src="http://code.jquery.com/jquery-3.3.1.js"></script>
<script>
			$(document).ready(function(){
				$('.Board').click(function(){
					
					var diNum = Number($(this).children(0).eq(0).val());	//0번째  td안의 있는 text;
					//alert(diNum);
					if(!isNaN(diNum)){
						location.href='${conPath}/diContent_view.do?diNum='+diNum+'&pageNum=${pageNum}';
					}
				});
			});
		</script>
</head>
<body>
<div id="dessertInformList">
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
	<div id="dessertInform">	<!-- 테이블전체 -->
	<table id="writeAllow">
		<c:if test="${not empty admin }">
			<tr><td><a href="${conPath }/diWrite_view.do">글 쓰 기</a></td></tr>
		</c:if>
	</table>
	
	<table  id="list">
		
		<c:if test="${totCnt == 0 }">
			<tr><td colspan="5" id="none">디저트 정보 없음!</td></tr>
		</c:if>
		<c:if test="${totCnt != 0 }">
				<c:set var="i" value="0"/>				
				<tr>
					<c:forEach var="dto" items="${list }">
						<td  class="Board">
							<input type="hidden" value="${dto.diNum }">	
							<table  id="board">
								<tr><td colspan="2">${dto.diSubject }</td>
								<tr><td colspan="2"><img id="diPic" src="${conPath}/SourcePicUp/${dto.diFileName01}" alt="사진" ></td>									
							</table>
						</td>
					<c:if test="${i%3 == 2 }">
						</tr><tr>
					</c:if>
					<c:set var="i" value="${i+1 }"/>
					</c:forEach>
				</tr>
		</c:if>
		
	</table>
	
	<c:if test="${totCnt != 0 }">
	<div class="paging">
		<c:if test="${startPage > BLOCKSIZE}">
			<a href="${conPath }/dessertInformView.do?pageNum=${startPage-1}">이전</a>
		</c:if>
		<c:forEach var="i" begin="${startPage }" end="${endPage }">
			<c:if test="${i == pageNum }">
				[<b>${i }</b>]
			</c:if>
			<c:if test="${i != pageNum }">
				[<a href="${conPath }/dessertInformView.do?pageNum=${i}">${i }</a>]
			</c:if>
		</c:forEach>
		<c:if test="${endPage < pageCnt }">
			<a href="${conPath }/dessertInformView.do?pageNum=${endPage+1}">다음</a>
		</c:if>
	</div>
	
	</c:if>
	</div>
	<div id="Button">
		<jsp:include page="../main/headerButton.jsp"/>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</div>
</body>
</html>