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
  <!-- Bootstrap + jQuery -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="http://code.jquery.com/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <!--// Bootstrap + jQuery -->

</head>

<body>
  <div class="container">
    <div class="page-header">
      <h1>Cookie 저장</h1>
      <c:choose>
        <c:when test="${my_cookie == ''}">
          <h2>저장된 쿠키 없음</h2>
        </c:when>
        <c:otherwise>
          <h2>저장된 쿠키 = ${my_cookie}</h2>
        </c:otherwise>
      </c:choose>
      <%-- JSTL을 통한 쿠키 데이터 읽기 --%>
      <c:if test="${cookie.my_cookie != null}">
        <h3>${cookie.my_cookie.value}(이)가 저장되었습니다.</h3>
      </c:if>
    </div>
    <form class="" action="${pageContext.request.contextPath}/cookie/save.do" method="post">
      <div class="form-group">
        <input type="text" name="memo" id="memo" class="form-control" />
      </div>
      <div class="form-group">
        <input type="submit" class="btn btn-primary btn-block" value="Cookie 저장" />
      </div>
    </form>
  </div>

</body>

</html>
