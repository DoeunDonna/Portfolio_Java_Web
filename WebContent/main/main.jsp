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
<script>
	var btn1Img = ['${conPath }/SourceImg/CottonCat.png', '${conPath }/SourceImg/CottonCatOnclick.png'];
	var btn2Img = ['${conPath }/SourceImg/MrGingerRabbit.png', '${conPath }/SourceImg/MrGingerRabbitOnclick.png'];
	var btn3Img = ['${conPath }/SourceImg/JAMHatter.png', '${conPath }/SourceImg/JAMHatterOnclick.png'];
	var btn4Img = ['${conPath }/SourceImg/QueenCupCake.png', '${conPath }/SourceImg/QueenCupCakeOnclick.png'];
	
	function EatMeBtn(n) {//eatme
	    var img = document.getElementById('CottonCat');
	    img.src = btn1Img[n];
	}
	function CookMeBtn(n) {//cookme
	    var img = document.getElementById('MrRabbit');
	    img.src = btn2Img[n];
	}
	function TalkMeBtn(n) {//talkme
	    var img = document.getElementById('JamHatter');
	    img.src = btn3Img[n];
	}
	function LearnMeBtn(n) {//learnme
	    var img = document.getElementById('Queen');
	    img.src = btn4Img[n];
	}
</script>
<style>
	*{ padding:0;
		margin:0;
	}
	a{text-decoration: none;}
	#main{
		margin:0 auto;
		overflow: hidden;
		width:1500px;
	}
	#main #button{
		float:right;}
	#main #lnb{
		width:200px; height:200px;
        position:absolute;
        top: 300px;
		}
		
	#main #lnb #map{
		width:1100px;
		}
		
	#main #lnb #eatMe{
	    position:absolute;
        left:815px; top:105px;
		}
	#main #lnb #eatMe #CottonCat{
		width: 250px;
	}
	#main #lnb #cookMe{
	    position:absolute;
        left:400px; top:250px;
		}
	#main #lnb #cookMe #MrRabbit{
		width: 250px;
		}
	#main #lnb #talkMe{
	    position:absolute;
        left:5px; top:120px;
		}
	#main #lnb #talkMe #JamHatter{
		width: 250px;
	}	
	#main #lnb #learnMe{
	    position:absolute;
        left:570px; top:150px;
		}
	#main #lnb #learnMe #Queen{
		width: 250px;
		}
	#main #hide{
		background-color: #ffbfbf;
		font-family: 'Cute Font', cursive;
		font-size: 1.2em;
		color:white;
	}	
	#main #hide a{
		color:white;
	}	
</style>
</head>
<body>
<div id="main">
	<c:if test="${not empty loginErrorMsg}">
		<script>
			alert('${loginErrorMsg}');
			history.back();
		</script>
	</c:if>
	<c:if test="${not empty loginMsg  && customer.lNum != 5}">
		<script>
			alert('${customer.cNick}${loginMsg}');
		</script>
	</c:if>
	<c:if test="${not empty adminloginResult }">
		<script>
			alert('${adminloginResult }');
		</script>
	</c:if>
	<c:if test="${not empty error }">
		<script>
			history.back();
		</script>
	</c:if>
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
	<c:if test="${not empty DeleteErrorMsg }">
		<script>
			alert('${DeleteErrorMsg}');
			history.back();
		</script>
	</c:if>
	<c:if test="${not empty DeleteResultMsg }">
		<script>
			alert('${DeleteResultMsg}');
		</script>
	</c:if>
	
	<c:if test="${customer.lNum == 5 }">
		<script>
			alert('현실로 돌아간 앨리스는 돌아올 수 없어');
			location.href="logout.do";
		</script>
	</c:if>
	
	<jsp:include page="../main/headerLogo.jsp"/>
	
	<div id="lnb">
		<img id="map" src="${conPath }/SourceImg/Map.png" alt="지도">
		<div id="eatMe">
			<a href = "${conPath }/eatMeView.do"><img id="CottonCat" src="${conPath }/SourceImg/CottonCat.png" alt="eatMe_CottonCat"
			onmouseover="EatMeBtn(1);" onmouseout="EatMeBtn(0);"></a>
		</div>
		<div id="cookMe">
			<a href = "${conPath }/cookMeView.do"><img id="MrRabbit" src="${conPath }/SourceImg/MrGingerRabbit.png" alt="cookMe_MrRabbit"
			onmouseover="CookMeBtn(1);" onmouseout="CookMeBtn(0);"></a>
		</div>
		<div id="talkMe">
			<a href = "${conPath }/talkMeView.do"><img id="JamHatter" src="${conPath }/SourceImg/JAMHatter.png" alt="talkMe_MadJam"
			onmouseover="TalkMeBtn(1);" onmouseout="TalkMeBtn(0);"></a>
		</div>
		<div id="learnMe">
			<a href = "${conPath }/learnMeView.do"><img id="Queen" src="${conPath }/SourceImg/QueenCupCake.png" alt="learnMe_bakingCastle"
			onmouseover="LearnMeBtn(1);" onmouseout="LearnMeBtn(0);"></a>
		</div>
	</div>
	<div id="button">
		<jsp:include page="../main/headerButton.jsp"/>
	</div>
	<jsp:include page="../main/footer.jsp"/>
	<div id="hide">
		<c:if test="${empty customer and empty admin }">
			<a href="${conPath }/adminloginView.do">관 리 자 모 드</a>
		</c:if>
	</div>
	
</div>
</body>
</html>