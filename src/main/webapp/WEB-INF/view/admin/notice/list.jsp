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
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Document</title>
<!-- 스타일 속성(X)-> 외부파일에 따로 두기. 불러옴. import방법도 있음.(로딩시간 걸릴수도있음.-->
<!-- <link rel="stylesheet" href="../CSS/reset.css" type="text/css"> -->
<link rel="stylesheet" href="/javaprj/resource/css/style.css" type="text/css">

</head>

<body>


	<!--     <header id="header">
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
                        <label>과정검색</label>
                        <input type="text">
                        <input type="submit" value="검색">
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
    </header> -->
	<jsp:include page="../../inc/header.jsp" />

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
			<!--           <aside>

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
            </aside> -->
			<jsp:include page="../../inc/aside.jsp" />
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
					<h1>공지사항 검색</h1>
					<form>
						<select>
							<option>제목</option>
							<option>작성자</option>
							<option>내용</option>
						</select> <input type="text"> <input type="submit" value="검색">
					</form>
				</section>

				<section id="notice">
					<h3 class="d-none">공지사항 목록</h3>
					<form  method="post">
						<table>
							<thead>
								<tr>
									<td class="num">번호</td>
									<td class="title">제목</td>
									<td class="writer">작성자</td>
									<td class="date">작성일</td>
									<td class="hit">조회수</td>
								</tr>
							</thead>

							<tbody>
								<c:forEach var="n" items="${list}">
									<c:if test="${param.eid == n.id}">
										<tr>
											<td class="num">${n.id}</td>
											<td class="title">
												<input type="text" name="title" value="${n.title}">
												<span>[23]</span>
												<input type="hidden" name="id" value="${n.id}" >
												<span><input type="submit" value="저장"></span>
											</td>
											<td class="writer">${n.writerId}</td>
											<td class="date">${n.regDate}</td>
											<td class="hit">${n.hit}</td>
										</tr>
									</c:if>

									<c:if test="${param.eid != n.id}">
										<tr>
											<td class="num">${n.id}</td>
											<td class="title"><a href="detail?id=${n.id}">${n.title}</a>
												<span>[23]</span> <span><a href="list1?eid=${n.id}">수정</a><a
													href="">삭제</a></span></td>
											<td class="writer">${n.writerId}</td>
											<td class="date">${n.regDate}</td>
											<td class="hit">${n.hit}</td>
										</tr>
									</c:if>


								</c:forEach>
							</tbody>
						</table>
					</form>
					<div>
						<a href="reg">글쓰기</a>
					</div>
				</section>
			</section>

			<section id="page-index">
				<h1 style="font-size: 2rem" class="d-none">페이지 정보</h1>
				<div>
					<span class="color-highlight font-bold">1</span> / 1 pages
				</div>
			</section>

			<section id="pager">
				<h1 class="d-none">페이지</h1>
				<div>
					<div>이전</div>
					<ul>
						<li class="current"><a href="list?p=1">1</a></li>
						<li><a href="list?p=2">2</a></li>
						<li><a href="list?p=3">3</a></li>
						<li><a href="list?p=4">4</a></li>
						<li><a href="list?p=5">5</a></li>
					</ul>
					<div>다음</div>
				</div>
			</section>
			</main>

			<!-- <div style="clear:left;">막내</div> .clear-fix사용-->
		</div>
	</div>

	<!--     <footer id="footer">
        <div>
             <h2>회사정보</h2>

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
</div> 
        </div>
    </footer> -->
	<jsp:include page="../../inc/footer.jsp" />
</body>

</html>