<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>


<%-- Standard JSP/JSTL "goodness" --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>



<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width,initial-scale=1.0,
minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
  <title>Document</title>
  <!-- Twitter Bootstrap3 & jQuery -->
  <link rel="icon" href="data:;base64,iVBORw0KGgo=">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" />
  <script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
  	<div class="container">
		<h1 class='page-header'>학생 상세 보기</h1>

		<!-- 조회결과를 출력하기 위한 표 시작 -->
		<table class="table table-bordered">
			<tbody>
				<tr>
					<th class="info text-center" width="130">학과 번호</th>
					<td>${item.getStudno()}</td>
				</tr>
				<tr>
					<th class="info text-center">이름</th>
					<td>${item.getName()}</td>
				</tr>
				<tr>
					<th class="info text-center">아이디</th>
					<td>${item.getUserid()}</td>
				</tr>
				<tr>
					<th class="info text-center">등급</th>
					<td>${item.getGrade()}</td>
				</tr>
				<tr>
					<th class="info text-center">주민번호</th>
					<td>${item.getIdnum()}</td>
				</tr>
				<tr>
					<th class="info text-center">생년월일</th>
					<td>${item.getBirthdate()}</td>
				</tr>
				<tr>
					<th class="info text-center">전화번호</th>
					<td>${item.getTel()}</td>
				</tr>
				<tr>
					<th class="info text-center">교수번호</th>
					<td>${item.getProfno()}</td>
				</tr>
				<tr>
					<th class="info text-center">학과번호</th>
					<td>${item.getDeptno()}</td>
				</tr>
			</tbody>
		</table>
		<!--// 조회결과를 출력하기 위한 표 끝  -->

		<!-- 버튼 시작 -->
		<div class="text-center">
			<a href="${pageContext.request.contextPath}/student/stud_list.do" class="btn btn-primary">목록</a>
			<a href="${pageContext.request.contextPath}/student/stud_add.do" class="btn btn-info">추가</a>
			<a href="${pageContext.request.contextPath}/student/stud_edit.do?studno=${item.studno}" class="btn btn-warning">수정</a>
			<a href="${pageContext.request.contextPath}/student/stud_delete.do?studno=${item.studno}" class="btn btn-danger">삭제</a>
		</div>
		<!--// 버튼 끝 -->
	</div>

</body>

</html>
