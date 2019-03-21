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
<link href="${conPath }/css/delete.css" rel="stylesheet">
<script>
		function chk(){
			if(frm.cPw.value != '${customer.cPw}'){
				alert('비밀번호를 다시 입력해 주세요');
				return false;
			}
			return true;
		}
	</script>
</head>
<body>
<div id="deleteForm">
	<jsp:include page="../main/headerLogo.jsp"/>
	
	<form action="${conPath }/cusDelete.do" method="post" name="frm" onsubmit="return chk()">
		<input type="hidden" name="cId" value="${customer.cId }">
		<input type="hidden" name="cName" value="${customer.cName }">
		<input type="hidden" name="cNick" value="${customer.cNick }">
		<input type="hidden" name="lNum" value="${customer.lNum }">
		<input type="hidden" name="lName" value="${customer.lName }">
		<input type="hidden" name="cBirth" value="${customer.cBirth.toString() }">
		<input type="hidden" name="cGender" value="${customer.cGender }">
		<input type="hidden" name="cPhone1" value="${customer.cPhone1.toString() }">
		<input type="hidden" name="cPhone2" value="${customer.cPhone2.toString() }">
		<input type="hidden" name="cPhone3" value="${customer.cPhone3.toString() }">
		
		<table id="InformDelete">
			<tr><th colspan="2">회 원 탈 퇴</th>
			<tr><td colspan="2">본인 확인을 위해 비밀번호가 필요합니다!</td>
			</tr>
			<tr><th>비 밀 번 호 입 력</th>
				<td><input type="password" class="DeleteCus" name="cPw" required="required"></td>
			</tr>
			<tr><td colspan="2">
				<input type="reset" value="취소하기" class="dBtn" onclick="history.go(-1)">
				<input type="submit" value="탈퇴하기" class="dBtn">
			</td>
		</table>
	</form>
	
	<jsp:include page="../main/footer.jsp"/>
</div>
</body>
</html>