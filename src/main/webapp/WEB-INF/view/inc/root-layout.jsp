<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html>
<html lang="en" style="font-size: 10px">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Document</title>
<link rel="stylesheet" href="/javaprj/resource/css/style.css" type="text/css">
</head>

<body>
	<!-- header block -->
	<%-- <jsp:include page="../../inc/header.jsp" /> --%>
	<tiles:insertAttribute name="header"/>

	<!-- visual block -->
	<div id="visual">
		<div class="content-box" style="position: relative">

		</div>
	</div>

	<!-- main block -->
	<div id="body">
		<div class="content-box">

			<tiles:insertAttribute name="main"/>
			
		</div>
	</div>

	<!-- footer block -->
	<tiles:insertAttribute name="footer"/>
</body>

</html>