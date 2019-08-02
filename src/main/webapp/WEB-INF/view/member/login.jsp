<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


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
			<div style="color: red;">아이디 또는 비밀번호가 유효하지 않습니다.</div>
		</c:if>
		<form method="post">
			<table>
				<tbody>
					<tr>
						<th>아이디</th>
						<td><input type="text" name="username"></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" name="password"></td>
					</tr>
					<tr>
						<td><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /></td>
						<td><input type="submit" value="로그인"></td>
					</tr>
				</tbody>
			</table>
		</form>
	</section>


</section>
</main>