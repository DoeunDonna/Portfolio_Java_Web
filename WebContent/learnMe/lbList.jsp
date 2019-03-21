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
<link href="${conPath }/css/LearnMeBoard.css" rel="stylesheet">

<script src="http://code.jquery.com/jquery-3.3.1.js"></script>
<script>
			$(document).ready(function(){
				$('.Board').click(function(){
					
					var lbNum = Number($(this).children(0).eq(0).val());	//0번째  td안의 있는 text;
					//alert(lbNum);
					if(!isNaN(lbNum)){
						location.href='${conPath}/lbContent_view.do?lbNum='+lbNum+'&pageNum=${pageNum}';
					}
				});
			});
		</script>
</head>
<body>
<div id="learnmeList">	<!-- 전체 -->
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
			LEARN ME , 베 이 킹 클 래 스 - 수 강 신 청
		</div>

	<jsp:include page="../main/headerLogo.jsp"/>
	<div id="learnme">	<!-- 테이블전체 -->
	<table id="writeAllow">
		<c:if test="${not empty admin }">
			<tr><td class="writelearnme"><a href="${conPath }/lbWrite_view.do">관 리 자 글쓰기</a></td></tr>
		</c:if>
		<c:if test="${not empty customer && customer.lNum ==4}">
			<tr><td class="writelearnme"><a href="${conPath }/lbWrite_view.do">글 쓰 기</a></td></tr>
		</c:if>
		<c:if test="${empty customer && empty admin}">
			<tr><td class="writelearnme"><a href="${conPath }/loginView.do">글쓰기는 배부른 앨리스등급부터 가능합니다</a></td></tr>
		</c:if>
		<c:if test="${customer.lNum == 1 || customer.lNum == 2 || customer.lNum == 3}">
			<tr><td class="writelearnme">글쓰기는 배부른 앨리스등급부터 가능합니다</td></tr>
		</c:if>
	</table>
	
	<table id="list">
		<c:if test="${totCnt == 0 }">
			<tr><td colspan="5" id="none">강의가 없습니다</td></tr>
		</c:if>
		<c:if test="${totCnt != 0 }">
				<tr>
					<th colspan="3">Dessert class</th><th>작성자</th><th>작성일</th><th>조회수</th>
				</tr>
			<c:forEach var="dto" items="${list}">
				<tr class="Board">
					<input type="hidden" value="${dto.lbNum }">
					<td>${dto.lbNum }</td>
					<td><img id="lbPic" src="${conPath}/SourcePicUp/${dto.lbFileName01}" alt="${dto.lbFileName01 }" ></td>
					<td>${dto.lbSubject }</td>
					<td>
						<c:if test="${dto.cId != null }">
							${dto.cNick }
						</c:if>
						<c:if test="${dto.aId != null }">
							${dto.aName }
						</c:if>
					</td>
					<td><fmt:formatDate value="${dto.lbDate }" pattern="yy.MM.dd"/></td>
					<td>${dto.lbHit}</td>				
				</tr>
			</c:forEach>
						
		</c:if>
		
	</table>
	
	<c:if test="${totCnt != 0 }">
	
	<div class="paging">
		<c:if test="${startPage > BLOCKSIZE}">
			<a href="${conPath }/learnMeView.do?pageNum=${startPage-1}">이전</a>
		</c:if>
		<c:forEach var="i" begin="${startPage }" end="${endPage }">
			<c:if test="${i == pageNum }">
				[<b>${i }</b>]
			</c:if>
			<c:if test="${i != pageNum }">
				[<a href="${conPath }/learnMeView.do?pageNum=${i}">${i }</a>]
			</c:if>
		</c:forEach>
		<c:if test="${endPage < pageCnt }">
			<a href="${conPath }/learnMeView.do?pageNum=${endPage+1}">다음</a>
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