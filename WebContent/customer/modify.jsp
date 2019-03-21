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
<link href="${conPath }/css/modify.css" rel="stylesheet">
<script>
		function chk(){
			if(frm.cPw.value != '${customer.cPw}'){
				alert('비밀번호를 다시 입력해 주세요');
				return false;
			}
			if(frm.cPwNew.value != ''){
				if(frm.cPwNew.value != frm.cPwChk.value){
					alert('새 비밀번호가 일치하지 않습니다');
					frm.cPw.value='';
					frm.cPwChk.value='';
					frm.cPw.focus();
					return false;
				}
			}
			return true;
		}
	</script>
</head>
<body>
<div id="modifyForm">
	<% String cGender = request.getParameter("cGender"); %>
	<jsp:include page="../main/headerLogo.jsp"/>
	
	<form action="${conPath }/modify.do" method="post" name="frm" onsubmit="return chk()">
		<input type="hidden" name="cId" value="${customer.cId }">
		<input type="hidden" name="lNum" value="${customer.lNum }">
		<input type="hidden" name="lName" value="${customer.lName }">
		<table id="cusModify">
			<tr><th colspan="3" id="modify">정보수정</th></tr>
			<tr><th>아이디</th>
				<td colspan="2">${customer.cId }</td>
			</tr>
			<tr><th>비밀번호</th>
				<td colspan="2"><input type="password" class="modifyCus" name="cPw" required="required"></td>
			</tr>
			<tr><th>비밀번호 변경</th>
				<td colspan="2"><input type="password" class="modifyCus" name="cPwNew"></td>
			</tr>
			<tr><th>비밀번호 재확인</th>
				<td colspan="2"><input type="password" class="modifyCus" name="cPwChk"></td>
			</tr>
			<tr><th>이름</th>
				<td colspan="2"><input type="text" class="modifyCus" name="cName" value="${customer.cName }" required="required"></td>
			</tr>
			<tr><th>별명</th>
				<td colspan="2"><input type="text" class="modifyCus" name="cNick" value="${customer.cNick }" required="required"></td>
			</tr>
			<tr><th>회원레벨</th>
				<td colspan="2">${customer.lName }</td>
			</tr>
			<tr><th>생년월일</th>
				<td colspan="2"><input type="date" class="modifyCus" name="cBirth" value="${customer.cBirth.toString() }"></td>
			</tr>
			<tr><th>성별</th>
					<td colspan="2" class="modifyGender"><%if(cGender!=null && cGender.equals("male")){ %>
								<input type="radio" name="cGender" value="male" checked="checked">
								남&nbsp;&nbsp;&nbsp;
								<input type="radio" name="cGender" value="female">여
							<%}else{ %>
								<input type="radio" name="cGender" value="male">남&nbsp;&nbsp;&nbsp;
								<input type="radio" name="cGender" value="female" checked="checked">
								여
							<%} %>
						</td>
						
							
				</tr>
				<tr><th>휴대전화</th>
					<td colspan="2"><input type="text" class="modifyPhone" name="cPhone1" size="3" value="${customer.cPhone1.toString() }">
					-<input type="text" class="modifyPhone" name="cPhone2" size="4" value="${customer.cPhone2.toString() }">
					-<input type="text" class="modifyPhone" name="cPhone3" size="4" value="${customer.cPhone3.toString() }"></td>
				</tr>
			<tr><td colspan="3">
				<input type="reset" value="이전" class="mBtn" onclick="history.go(-1)">
				<input type="reset" value="초기화" class="mBtn">
				<input type="submit" value="정보수정" class="mBtn">
			</td>
		</table>
	</form>
	
	<jsp:include page="../main/footer.jsp"/>
</div>
</body>
</html>