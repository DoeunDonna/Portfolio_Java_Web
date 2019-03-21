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
<link href="${conPath }/css/cusModify.css" rel="stylesheet">
</head>
<body>
<div id="cusModify">
<jsp:include page="../main/headerLogo.jsp"/>
<div>
<div id="all">
<form action='${conPath }/aCusModify_view.do' method='post'>
	<table id="member">
		<tr><th colspan="9" id="caption"> 전 체 회 원 보 기 </td></tr>
		
		<tr>
			<th>선 택</th><th>별 명</th><th>아 이 디</th><th>이 름</th><th colspan="2">레 벨</th><th>생 일</th><th>성 별</th><th>전 화 번 호</th>
		</tr>
		
			<c:forEach var="aCus" items="${aCuslist }">
			<tr>	
				<td><input type="radio" name="cId" value="${aCus.cId }" required="required">
				<td>${aCus.cNick }</td><td>${aCus.cId }</td><td>${aCus.cName }</td>
				<td>${aCus.lName }</td><td>${aCus.lNum }</td>
				<td>${aCus.cBirth }</td>
				<td><c:if test="${aCus.cGender==null }">
				비밀★
				</c:if>
				${aCus.cGender }</td>
				<td>
				<c:if test="${aCus.cPhone1==null && aCus.cPhone2==null && aCus.cPhone3==null }">
				비밀★
				</c:if>
				<c:if test="${aCus.cPhone1!=null || aCus.cPhone2!=null || aCus.cPhone3!=null }">
				${aCus.cPhone1 }-${aCus.cPhone2 }-${aCus.cPhone3 }
				</c:if>
				</td>
				
			</tr>
			</c:forEach>
		
		</table>
		<table id="Buttons">
		<tr>
		<td colspan="10">
		<input type="button" value="메인화면"  onclick="location.href='${conPath }/main.do'" class="Btn">
		<input type="submit" value="등급변경" class="Btn"></td>
		</tr>
	</table>
</form>
</div>
	<div class="paging">
		<c:if test="${startPage>BLOCKSIZE }">
			<a href="${conPath }/allView.do?pageNum=${startPage-1 }"> &lt; </a>
		</c:if>
		&nbsp; &nbsp; &nbsp;
		<c:if test="${startPage<=BLOCKSIZE }">
			&lt;
		</c:if>
		&nbsp; &nbsp; &nbsp;
		<c:forEach var="i" begin="${startPage }" end="${endPage }">
			<c:if test="${i==pageNum }">
				<span class="currentPage">[ ${i} ]</span>
			</c:if>
			<c:if test="${i!=pageNum }">
				[ <a href="${conPath }/allView.do?pageNum=${i }">${i }</a> ]
			</c:if>
		</c:forEach>
		&nbsp; &nbsp; &nbsp;
		<c:if test="${endPage<pageCnt }">
			<a href="${conPath }/allView.do?pageNum=${endPage+1 }"> &gt; </a> 
		</c:if>
		&nbsp; &nbsp; &nbsp;
		<c:if test="${endPage==pageCnt }">
			&gt; 
		</c:if>
	</div>
</div>
<jsp:include page="../main/footer.jsp"/>
</div>
</body>
</html>