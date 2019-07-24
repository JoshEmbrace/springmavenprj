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
		<h1>공지사항 내용</h1>
		<table>
			<tbody>
				<tr>
					<th>제목</th>
					<td>${notice.title}</td>
				</tr>
				<tr>
					<th>작성일</th>
					<td>${notice.regDate}</td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td><c:forEach var="file" items="${noticeFile}">
							<a href="/upload/${file.name}" download>${file.name}</a>
							<br>
						</c:forEach></td>
				</tr>
				<tr>
					<th>내용</th>
					<td>${notice.content}</td>
				</tr>
			</tbody>
		</table>
		<div>
			<a href="edit?id=${notice.id}">수정</a> <a href="del?id=${notice.id}">삭제</a>
		</div>
	</section>

	<section>
		<h1></h1>
		<ul>
			<li><a href="detail?id=${prev.id}"><span>이전글</span>${prev.title}</a></li>
			<li><a href="detail?id=${next.id}"><span>다음글</span>${next.title}</a></li>
		</ul>
	</section>

</section>
</main>