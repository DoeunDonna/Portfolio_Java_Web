<%@page import="com.tj.dessert.dao.EatMeBoardDao"%>
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
<link href="${conPath }/css/EatMeBoard.css" rel="stylesheet">
<script src="http://code.jquery.com/jquery-3.3.1.js"></script>
<script>
			$(document).ready(function(){
				$('.Board').click(function(){
					
					var ebNum = Number($(this).children(0).eq(0).val());	//0번째  td안의 있는 text;
					//alert(ebNum);
					if(!isNaN(ebNum)){
						location.href='${conPath}/ebContent_view.do?ebNum='+ebNum+'&pageNum=${pageNum}';
					}
				});
			});
		</script>
</head>
<body>
<div id="eatmeList">	<!-- 전체 -->
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
			EAT ME , 카 페 및 먹 방 후 기 게 시 판
		</div>

	<jsp:include page="../main/headerLogo.jsp"/>
	<div id="eatme">	<!-- 테이블전체 -->
		<table id="writeAllow">
			<c:if test="${not empty admin }">
				<tr><td class="writeEatMe"><a>관리자는 후기글을 남길 수 없습니다</a></td></tr>
			</c:if>
			<c:if test="${not empty customer  && customer.lNum != 1}">
				<tr><td class="writeEatMe"><a href="${conPath }/ebWrite_view.do">글쓰기</a></td></tr>
			</c:if>
			<c:if test="${empty customer && empty admin}">
				<tr><td class="writeEatMe"><a href="${conPath }/loginView.do">글쓰기는 로그인 이후에만 가능합니다</a></td></tr>
			</c:if>
		</table>

		<table id="list">
			<c:if test="${totCnt == 0 }">
				<tr><td colspan="5" id="none">글이 없습니다</td></tr>
			</c:if>
			<c:if test="${totCnt != 0 }">
					<c:set var="i" value="0"/>				
					<tr	>
						<c:forEach var="dto" items="${list }">
							<td class="Board">
								<input type="hidden" value="${dto.ebNum }">	
								<table>
									<tr><td colspan="2"><img id="ebPic" src="${conPath}/SourcePicUp/${dto.ebFileName01}" alt="사진" ></td>				
									<tr><td colspan="2">${dto.ebSubject }</td>
									</tr>
									<tr><td>조회 ${dto.ebHit}</td><td><fmt:formatDate value="${dto.ebDate }" pattern="yy.MM.dd"/></td>
									<tr><td colspan="2">${dto.cNick }</td></tr>
								</table>
							</td>
						<c:if test="${i%5 == 4 }">
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
				<a href="${conPath }/eatMeView.do?pageNum=${startPage-1}">이전</a>
			</c:if>
			<c:forEach var="i" begin="${startPage }" end="${endPage }">
				<c:if test="${i == pageNum }">
					[<b>${i }</b>]
				</c:if>
				<c:if test="${i != pageNum }">
					[<a href="${conPath }/eatMeView.do?pageNum=${i}"> ${i }</a>]
				</c:if>
			</c:forEach>
			<c:if test="${endPage < pageCnt }">
				<a href="${conPath }/eatMeView.do?pageNum=${endPage+1}">다음</a>
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