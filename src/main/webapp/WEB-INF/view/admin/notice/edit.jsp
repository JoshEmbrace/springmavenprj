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
<%
    /* NoticeDao noticeDao = new FileNoticeDao();
    List<NoticeView> notices = noticeDao.getList();
    //MVC
/*     List<Notice> notices = new ArrayList<>(); */
    //자바 프로그래밍의 입장
    // 데이터를 제공하는 코드블록 -> data service Object:DAO
    //List<Notice> getNoticeList(){
 /*    FileInputStream fis = new FileInputStream("D:\\java\\workspace\\JSPPrj\\WebContent\\WEB-INF\\data\\notice-file.df");
    Scanner fscan = new Scanner(fis);
    
    String line = "";
    
    while(fscan.hasNextLine()){
    line = fscan.nextLine();	
   /*  line = line.replaceAll("^\\s+", ""); */
   /*  Notice notice = new Notice(line.split(","));
    notices.add(notice);
    }
    
    fscan.close();
    fis.close(); */ 
    //여기까지가------
    //} */
    %>
<!DOCTYPE html>
<html lang="en" style="font-size: 10px">

<head>
<meta charset="UTF-8">
<title>Document</title>
<!-- 스타일 속성(X)-> 외부파일에 따로 두기. 불러옴. import방법도 있음.(로딩시간 걸릴수도있음.-->
<!-- <link rel="stylesheet" href="../CSS/reset.css" type="text/css"> -->
<link rel="stylesheet" href="../../CSS/style.css" type="text/css">
</head>

<body>


	<header id="header">
		<div class="content-box">
			<h1 id="logo">뉴렉처 온라인</h1>
			<section>
				<h1 class="d-none">머릿말</h1>

				<nav id="main-menu">
					<h1 class="d-none">메인메뉴</h1>
					<ul>
						<li><a href="">학습가이드</a></li>
						<li><a href="">강좌선택</a></li>
						<li><a href="">AnswerIs</a></li>
					</ul>
				</nav>

				<section id="lecture-search-form">
					<h1 class="d-none">강좌검색 폼</h1>
					<form>
						<label>과정검색</label> <input type="text"> <input
							type="submit" value="검색">
					</form>
				</section>

				<nav id="member-menu">
					<h1 class="d-none">회원메뉴</h1>
					<ul>
						<li>HOME</li>
						<li>로그인</li>
						<li>회원가입</li>
					</ul>
				</nav>

				<nav id="direct-menu">
					<h1 class="d-none">자주 사용하는 메뉴</h1>
					<ul>
						<li>마이페이지</li>
						<li>고객센터</li>
					</ul>
					<nav>
			</section>
	</header>
	</div>
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
				<h1>공지사항</h1>

				<section id="breadcrumb">
					<h3 class="d-none">경로</h3>
					<ol>
						<li>home</li>
						<li>고객센터</li>
						<li>공지사항</li>
					</ol>
				</section>
				<section>
					<form method="post" action="edit">
						<h1>공지사항 내용</h1>
						<table>
							<tbody>
								<tr>
									<th>카테고리</th>
									<td>
										<select name = "category">
											<option>학습</option>
											<option>결제</option>
											<option>기타</option>
										</select>
									</td>
								</tr>
								<tr>
									<th>제목</th>
									<td><input value="${notice.title}" name="title"></td>
								</tr>
								<tr>
									<th>작성일</th>
									<td>${notice.regDate}</td>
								</tr>
								<tr>
									<th>내용</th>
									<td><textarea name="content">${notice.content}</textarea></td>
								</tr>
							</tbody>
						</table>
						<div>
							<input type="hidden" name="id" value="${notice.id}">
							<input type="submit" value="저장"> 
							<a href="detail?id=${notice.id}">취소</a>
						</div>
					</form>
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