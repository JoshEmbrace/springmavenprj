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
		<form method="post" action="reg" enctype="multipart/form-data">
			<h1>공지사항 내용</h1>
			<table>
				<tbody>
					<tr>
						<th>카테고리</th>
						<td><select name="category">
								<option>학습</option>
								<option>결제</option>
								<option>기타</option>
						</select></td>
					</tr>
					<tr>
						<th>제목</th>
						<td><input value="${notice.title}" name="title"></td>
					</tr>
					<tr>
						<th>첨부파일</th>
						<td><input type="file" name="file"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea name="content"></textarea></td>
					</tr>
				</tbody>
			</table>
			<div>
				<input type="submit" value="저장"> <a href="list1">취소</a>
			</div>
		</form>
	</section>
</main>