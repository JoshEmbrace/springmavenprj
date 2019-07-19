<%@page import="com.newlecture.web.entity.NoticeView"%>
<%@page import="com.newlecture.web.dao.NoticeDao"%>
<%@page import="java.util.Scanner"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="com.newlecture.web.entity.Notice"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en" >

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>6-10</title>
<!-- 스타일 속성(X)-> 외부파일에 따로 두기. 불러옴. import방법도 있음.(로딩시간 걸릴수도있음.-->
<!-- <link rel="stylesheet" href="../CSS/reset.css" type="text/css"> -->
<link rel="stylesheet" href="../CSS/style.css" type="text/css">

</head>

<body>
	<header id="header">
		<div class="left">
			<a href="" class="icon icon-menu">펼침버튼</a>
		</div>

		<h1><a href=""  id="logo">뉴렉쳐 온라인</a></h1>

		<div class="right">
			<a href="" class="icon icon-search">검색버튼</a>
		</div>
	</header>
	<section id="visual">
	
	</section>
	
	<main>
		<section id="top-lecture">
		${x }
		</section>
		<section id="lecture">
		</section>
		<section id="notice">
		</section>
		<section >
		</section>
	</main>
	

<%-- 	<jsp:include page="inc/footer.jsp" /> --%>
</body>

</html>