<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <h1 class="page-header">Upload Test</h1>

    <form class="" action="${pageContext.request.contextPath}/upload/upload_ok.do" method="post" enctype="multipart/form-data">
      <div class="form-group">
        <label for="memo">파일설명</label>
        <input type="text" name="memo" class="form-control">
      </div>
      <div class="form-group">
        <label for="memo">첨부파일</label>
        <input type="file" name="upload_file" id="upload_file" class="form-control" multiple />
      </div>

      <div class="form-group">
        <input type="submit" class="btn btn-primary btn-block" value="업로드" />
        <input type="reset" class="btn btn-primary btn-block" value="리셋" />
      </div>
    </form>
  </div>

</body>

</html>
