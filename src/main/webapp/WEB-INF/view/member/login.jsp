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
<html lang="en" style="font-size: 10px">

<head>
<meta charset="UTF-8">
<title>Document</title>
<!-- 스타일 속성(X)-> 외부파일에 따로 두기. 불러옴. import방법도 있음.(로딩시간 걸릴수도있음.-->
<!-- <link rel="stylesheet" href="../CSS/reset.css" type="text/css"> -->
<link rel="stylesheet" href="../CSS/style.css" type="text/css">
</head>

<body>


	<jsp:include page="../inc/header.jsp" />
	<!-- visual block -->
	<div id="visual">
		<div class="content-box" style="position: relative">
			<!-- <div class="test">

            </div>
            static 자동 relative static에서 얼마더 absolute 수동 fixed 고정 sticky
            <span >사진</span>
            <img style="left:100px;top:100px;position: absolute;"
                src="https://image.fmkorea.com/files/attach/new/20180417/486616/41170129/1021006724/554449902566a4417eee09a4fdb7bd79.jpg">
            <span>사진사진</span>
            <img
                src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQHPHV0j5HE7nNGbRAmkdPqwLC8tVaQ5rp48ZgIQDa5yH6Qhm8"> -->
		</div>
	</div>

	<!-- main block -->
	<div id="body">
		<!-- clear-fix 이제 안씀.-->
		<div class="content-box">
			<aside>

				<h1 id="aside-title">고객센터</h1>

				<nav id="customer-menu">
					<h1>고객센터메뉴</h1>
					<ul>
						<li><a herf="">공지사항</a></li>
						<li><a herf="">자주하는 질문</a></li>
						<li><a herf="">수강문의</a></li>
						<li><a herf="">이벤트</a></li>
					</ul>
				</nav>

				<nav id="coworker">
					<h1>협력업체</h1>
					<ul>
						<li><a href="">노트펍스</a></li>
						<li><a href="">나무랩연구소</a></li>
						<li><a href="">한빛미디어</a></li>
					</ul>
				</nav>
			</aside>

			<main>
			<section>
					<h1>로그인</h1>
	
					<section id="breadcrumb">
						<h3 class="d-none">경로</h3>
						<ol>
							<li>home</li>
							<li>member</li>
							<li>login</li>
						</ol>
					</section>
					
					
					<section>
						<h1>로그인 폼</h1>
						<c:if test="${param.error == 1}">
						<div style="color:red;">
							아이디 또는 비밀번호가 유효하지 않습니다.
						</div>
						</c:if>
						<form method="post">
						<table>
							<tbody>
								<tr>
									<th>아이디</th>
									<td><input type="text" name="id"></td>
								</tr>
								<tr>
									<th>비밀번호</th>
									<td><input type="password" name = "pwd"></td>
								</tr>
								<tr>
									<td><input type="submit" value="로그인"></td>
								</tr>
							</tbody>
						</table>
						</form>
					</section>
	
				
				</section>
			</main>

			<!-- <div style="clear:left;">막내</div> .clear-fix사용-->
		</div>
	</div>

	<footer id="footer">
		<div>
			<!-- <h2>회사정보</h2>

    <div>
    <h3>소유권자 정보</h3>
    <dl>
        <dt>
            주소:
        </dt>
        <dd>
            서울특별시 마포구 토정로35길 11, 인우빌딩 5층 266호
        </dd>
        <dt>
            관리자메일:
        </dt>
        <dd>
            admin@newlecture.com
        </dd>
        <dt>
            사업자 등록번호:
        </dt>
        <dd>
            132-18-46763
        </dd>
        <dt>
            통신 판매업:
        </dt>
        <dd>
            신고제 2013-서울강동-0969 호
        </dd>
        <dt>
            상호:
        </dt>
        <dd>
            뉴렉처
        </dd>
        <dt>
            대표:
        </dt>
        <dd>
            박용우
        </dd>
        <dt>
            전화번호:
        </dt>
        <dd>
            070-4206-4084
        </dd>
    </dl>
</div>

<div>
    <h3>저작권정보</h3>
    <div>
        Copyright ⓒ newlecture.com 2012-2014 All Right Reserved. Contact admin@newlecture.com for more information
    </div>
</div> -->
		</div>
	</footer>
</body>

</html>