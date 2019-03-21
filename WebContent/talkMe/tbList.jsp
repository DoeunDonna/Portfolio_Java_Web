<%@page import="com.tj.dessert.dao.TalkMeBoardDao"%>
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
<link href="${conPath }/css/TalkMeBoard.css" rel="stylesheet">
<script src="http://code.jquery.com/jquery-3.3.1.js"></script>

<script>
			$(document).ready(function(){
				$('.Board').click(function(){
					
					var tbNum = Number($(this).children(0).eq(0).val());	//0번째  td안의 있는 text;
					//alert(tbNum);
					if(!isNaN(tbNum)){
						location.href='${conPath}/tbContent_view.do?tbNum='+tbNum+'&pageNum=${pageNum}';
					}
				});
			});
		</script>
</head>
<body>
<div id="talkmeList">	<!-- 전체 -->
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
	
		<div id="place">
			TALK ME , 자 유 게 시 판
		</div>
	
	<jsp:include page="../main/headerLogo.jsp"/>
	<div id="talkme">	<!-- 테이블전체 -->
		
	<table id="writeAllow">
		<c:if test="${not empty admin }">
			<tr><td class="writetalkme">관리자는 글을 남길 수 없습니다</td></tr>
		</c:if>
		<c:if test="${not empty customer  && customer.lNum != 1}">
			<tr><td class="writetalkme"><a href="${conPath }/tbWrite_view.do">글쓰기</a></td></tr>
		</c:if>
		<c:if test="${empty customer && empty admin}">
			<tr><td class="writetalkme"><a href="${conPath }/loginView.do">글쓰기는 로그인 이후에만 가능합니다</a></td></tr>
		</c:if>
	</table>
	
	<table id="list">
		<c:if test="${totCnt == 0 }">
			<tr><td colspan="5">글이 없습니다</td></tr>
		</c:if>
		<c:if test="${totCnt != 0 }">
			<c:set var="i" value="0"/>			
				<tr>
					<th colspan="2">제 목</th><th>작 성 자</th><th>작 성 일</th><th>조 회 수</th>
				</tr>	
					<c:forEach var="dto" items="${list }">
						<tr class="Board">
							<input type="hidden" value="${dto.tbNum }">
							<td>${dto.tbNum }</td>
							<td><c:forEach var="i" begin="1" end="${dto.tbIndent }">
									<c:if test="${i==dto.tbIndent }">└─</c:if>
									<c:if test="${i!=dto.tbIndent }"> &nbsp; &nbsp; </c:if>
								</c:forEach>
								${dto.tbSubject }</td>
							<td>${dto.cNick }</td>
							<td><fmt:formatDate value="${dto.tbDate }" pattern="yy.MM.dd"/></td>
							<td>${dto.tbHit}</td>
						</tr>
					</c:forEach>
		</c:if>
	</table>
	
	<c:if test="${totCnt != 0 }">
	
	<div class="paging">
		<c:if test="${startPage > BLOCKSIZE}">
			<a href="${conPath }/talkMeView.do?pageNum=${startPage-1}">이전</a>
		</c:if>
		<c:forEach var="i" begin="${startPage }" end="${endPage }">
			<c:if test="${i == pageNum }">
				[<b>${i }</b>]
			</c:if>
			<c:if test="${i != pageNum }">
				[<a href="${conPath }/talkMeView.do?pageNum=${i}">${i }</a>]
			</c:if>
		</c:forEach>
		<c:if test="${endPage < pageCnt }">
			<a href="${conPath }/talkMeView.do?pageNum=${endPage+1}">다음</a>
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