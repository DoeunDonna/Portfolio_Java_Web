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
<link href="https://fonts.googleapis.com/css?family=Gamja+Flower" rel="stylesheet">
<script>
	//로그인 전
	var but1Img = ['${conPath }/SourceImg/MacaronButton1.png', '${conPath }/SourceImg/MacaronOnclick1.png'];
	var but2Img = ['${conPath }/SourceImg/MacaronButton2.png', '${conPath }/SourceImg/MacaronOnclick2.png'];
	var but3Img = ['${conPath }/SourceImg/MacaronButton3.png', '${conPath }/SourceImg/MacaronOnclick3.png'];
	
	//로그인 후
	var but4Img = ['${conPath }/SourceImg/MacaronButton1.png', '${conPath }/SourceImg/MacaronButtonCus.png'];
	var but5Img = ['${conPath }/SourceImg/MacaronButton2.png', '${conPath }/SourceImg/MacaronButtonLogout.png'];
	
	function button1(n) {//로그인
	    var img = document.getElementById('macaron1');
	    img.src = but1Img[n];
	}
	function button2(n) {//회원가입
	    var img = document.getElementById('macaron2');
	    img.src = but2Img[n];
	}
	function button3(n) {//디저트정보
	    var img = document.getElementById('macaron3');
	    img.src = but3Img[n];
	}
	function button5(n){//로그아웃
		var img = document.getElementById('macaron5');
		img.src = but5Img[n];
	}
</script>
<style>
	*{padding:0; margin:0;}
	li{list-style: none;}
	a{text-decoration: none;}
	#headerButton{
		margin:0 auto;
		overflow: hidden;
	}
	#headerButton #gnb{
		float:right;
	}
	#headerButton #gnb .button{
		width:350px;
		padding:30px 50px 30px 100px;
		display:block;
	}
	#headerButton #gnb #nicks{
		transform : rotate(-15deg);
		position: relative;
		top:-150px;
		right:-115px;
		width:110px;
	}
	#headerButton #gnb #nicks a{
		width:200px;
		height:200px;
		font-family: 'Gamja Flower', cursive;
		font-size: 1.4em;
		color: black;
		transform : rotate(45deg);
	}
	
	
</style>
</head>
<body>
<div id="headerButton">
	<!-- file:///D:/mega-IT/source/5_js/ch11_%EC%9D%B4%EB%B2%A4%ED%8A%B8/ex4.html 참고 -->
	<!-- 비회원 -->
	<c:if test="${empty customer and empty admin }">
		<div id="gnb">
			<a href="${conPath }/loginView.do"><img id="macaron1" class="button" src="${conPath }/SourceImg/MacaronButton1.png"
						onmouseover="button1(1);" onmouseout="button1(0);"></a>
			<a href="${conPath }/joinView.do"><img id="macaron2" class="button" src="${conPath }/SourceImg/MacaronButton2.png"
						onmouseover="button2(1);" onmouseout="button2(0);"></a>
			<a href="${conPath }/dessertInformView.do"><img id="macaron3" class="button" src="${conPath }/SourceImg/MacaronButton3.png"
						onmouseover="button3(1);" onmouseout="button3(0);"></a>
		</div>
	</c:if>
	
	<!-- 회원 -->
	<c:if test="${not empty customer and empty admin }">
		<div id="gnb">
			<a href="${conPath }/cusInform.do"><img id="macaron4" class="button" src="${conPath }/SourceImg/MacaronButtonCus.png"></a>
			<div id="nicks">
			<a href="${conPath }/cusInform.do">${customer.cNick}님</a>
			</div>
			<a href="${conPath }/logout.do"><img id="macaron5" class="button" src="${conPath }/SourceImg/MacaronButton2.png"
						onmouseover="button5(1);" onmouseout="button5(0);"></a>
			<a href="${conPath }/dessertInformView.do"><img id="macaron3" class="button" src="${conPath }/SourceImg/MacaronButton3.png"
						onmouseover="button3(1);" onmouseout="button3(0);"></a>
		</div>
	</c:if>
	
	<!-- 관리자 -->
	<c:if test="${empty customer and not empty admin }">
		<div id="gnb">
			<a href="${conPath }/manageCus.do"><img id="macaron4" class="button" src="${conPath }/SourceImg/MacaronButtonCus.png"></a>
			<div id="nicks">
			<a href="${conPath }/manageCus.do">${admin.aName}</a>
			</div>
			<a href="${conPath }/logout.do"><img id="macaron5" class="button" src="${conPath }/SourceImg/MacaronButton2.png"
						onmouseover="button5(1);" onmouseout="button5(0);"></a>
			<a href="${conPath }/dessertInformView.do"><img id="macaron3" class="button" src="${conPath }/SourceImg/MacaronButton3.png"
						onmouseover="button3(1);" onmouseout="button3(0);"></a>
		</div>
	</c:if>
</div>
</body>
</html>