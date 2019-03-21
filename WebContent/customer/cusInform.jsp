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
<link href="${conPath }/css/cusInform.css" rel="stylesheet">
</head>
<body>
<div id="informForm">
	<c:if test="${not empty modifyErrorMsg }">
		<script>
			alert('${modifyErrorMsg}');
			history.back();
		</script>
	</c:if>
	<c:if test="${not empty modifyResultMsg }">
		<script>
			alert('${modifyResultMsg}');
		</script>
	</c:if>

	<jsp:include page="../main/headerLogo.jsp"/>
	
	<form action="${conPath }/modifyView.do" method="post" name="frm" onsubmit="return chk()">
		<input type="hidden" name="cId" value="${customer.cId }">
		
		<table id="cusInform">
			<tr><th colspan="3" id="Inform">회원정보</th></tr>
			<tr><th>아이디</th>
				<td colspan="2">${customer.cId }</td>
			</tr>
			<tr><th>이름</th>
				<td colspan="2">${customer.cName }</td>
			</tr>
			<tr><th>별명</th>
				<td colspan="2">${customer.cNick }</td>
			</tr>
			<tr><th>회원레벨</th>
				<td colspan="2">${customer.lName }</td>
			</tr>
			<tr><th>생년월일</th>
				<td colspan="2">${customer.cBirth.toString() }</td>
			</tr>
			<tr><th>성별</th>
				<td colspan="2"><c:if test="${customer.cGender == 'male' }">
						남자
					</c:if>
					<c:if test="${customer.cGender != 'male' }">
						여자
					</c:if>
				</td>
				</tr>
				<tr><th>휴대전화</th>
					<td colspan="2">${customer.cPhone1.toString() }-${customer.cPhone2.toString() }-${customer.cPhone3.toString() }</td>
				</tr>
			<tr><td colspan="3">
				<input type="button" class="iBtn" value="메인화면" onclick="location.href='${conPath}/main.do'">
				<input id="delete" class="iBtn" type="button" value="회원탈퇴" onclick="location.href='${conPath}/cusDelete_view.do'">
				<input type="submit" class="iBtn" value="정보수정">
			</td>
		</table>
	</form>
	
	<jsp:include page="../main/footer.jsp"/>
	
</div>
</body>
</html>