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
<link href="${conPath }/css/join.css" rel="stylesheet">

	<script>
		function chk(){
			if(frm.cPw.value != frm.cPwChk.value){
				alert('비밀번호를 확인하세요');
				frm.cPw.value='';
				frm.cPwChk.value='';
				frm.cPw.focus();
				return false;
			}
			return ture;
		}
	</script>

</head>
<body>
<div id="joinForm">
	<jsp:include page="../main/headerLogo.jsp"/>
	
	<form action="${conPath }/join.do" method="post" name="frm" onsubmit="return chk()">
		<input type="hidden" name="lNum" value=2>
		<table id="InformInput">
			<tr><th colspan="2" id="joinUs">회원가입</th></tr>
				<tr><th>아이디</th>
					<td><input type="text" class="joinCus" name="cId" required="required"></td>
				</tr>
				<tr><th>비밀번호</th>
					<td><input type="password" class="joinCus" name="cPw" required="required"></td>
				</tr>
				<tr><th>비밀번호 확인</th>
					<td><input type="password" class="joinCus" name="cPwChk" required="required"></td>
				</tr>
				<tr><th>이름</th>
					<td><input type="text" class="joinCus" name="cName" required="required"></td>
				</tr>
				<tr><th>별명</th>
					<td><input type="text" class="joinCus" name="cNick" required="required"></td>
				</tr>
				<tr><th>생년월일</th>
					<td><input type="date" class="joinCus" name="cBirth" required="required"></td>
				</tr>
				<tr><th>성별</th>
					<td  class="joinGender" ><input type="radio"  name="cGender" value="male"/>남
					&nbsp;&nbsp;&nbsp;
	                   <input type="radio" name="cGender" value="female"/>여</td>
				</tr>
				<tr><th>휴대전화</th>
					<td><input type="number" class="joinPhone" name="cPhone1">
					-
					<input type="number" class="joinPhone" name="cPhone2">
					-
					<input type="number" class="joinPhone" name="cPhone3"></td>
				</tr>
				<tr><td colspan="2">
					<input type="submit" value="회원가입" class="jBtn"></td>
				</tr>
		</table>
	</form>
	
	<jsp:include page="../main/footer.jsp"/>
</div>
</body>
</html>