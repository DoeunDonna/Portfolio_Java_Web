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
<style>
	*{padding:0; margin:0;}
	
	header #logo{
		overflow: hidden;
		margin:20px;
		padding:30px 130px;
		border:10px solid #ffd9d9;
		border-radius: 30px;
	}
	header #logo #dessert{
		width:800px;
		float:right;
	}
	header #logo #fonts{
		float:left;
		padding:50px 200px;
		position:absolute;
	}
	header #logo #fonts #font1{
		position:absolute;
		left:-70px; top:20px;
		font-family: 'Cute Font', cursive;
		font-size: 1.7em;
		color : #d7bafa;
	}
	header #logo #fonts #font2{
		position:absolute;
		left:0px; top:60px;
		font-family: 'Cute Font', cursive;
		font-size: 1.7em;
		color : #d7bafa;
	}

</style>
</head>
<body>
	<header>
		<div id="logo">
			<a href="${conPath }/main.do"><img id="dessert" src="${conPath }/SourceImg/headerLogo.png"></a>
			<div id="fonts">
			<p id="font1">"네가 먹어보지 못한"</p>
			<p id="font2">"이상한 나라의 맛있는 디저트들"</p>
		</div>
		</div>
		
	</header>

</body>
</html>