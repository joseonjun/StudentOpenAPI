<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div class="container">
    <h1 class='page-header'>학생수정</h1>

    <!-- 추가를 위한 HTML 폼 시작 -->
    <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/student/StudAddOk.do">
      <div class="form-group">
        <label for="name" class="col-sm-2 control-label">학생 이름</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" id="name" name="name" value="${item.getName()}"/>
        </div>
      </div>

      <div class="form-group">
        <label for="userid" class="col-sm-2 control-label">아이디</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" id="userid" name="userid" value="${item.getUserid()}" />
        </div>
      </div>

      <div class="form-group">
        <label for="grade" class="col-sm-2 control-label">학년</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" id="grade" name="grade" value="${item.getGrade()}" />
        </div>
      </div>

      <div class="form-group">
        <label for="idnum" class="col-sm-2 control-label">주민번호</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" id="idnum" name="idnum" value="${item.getIdnum()}" />
        </div>
      </div>

      <div class="form-group">
        <label for="birthdate" class="col-sm-2 control-label">생년월일</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" id="birthdate" name="birthdate" value="${item.getBirthdate()}" />
        </div>
      </div>

      <div class="form-group">
        <label for="tel" class="col-sm-2 control-label">전화번호</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" id="tel" name="tel" value="${item.getTel()}" />
        </div>
      </div>

      <div class="form-group">
        <label for="deptno" class="col-sm-2 control-label">학과번호</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" id="deptno" name="deptno" value="${item.getProfno()}" />
        </div>
      </div>

      <div class="form-group">
        <label for="profno" class="col-sm-2 control-label">교수담당번호</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" id="profno" name="profno" value="${item.getProfno()}" />
        </div>
      </div>

      <div class="form-group">
        <label for="weight" class="col-sm-2 control-label">몸무게</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" id="weight" name="weight"  value="${item.getWeight()}"/>
        </div>
      </div>


      <div class="form-group">
        <label for="height" class="col-sm-2 control-label">키</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" id="height" name="height" value="${item.getHeight()}" />
        </div>
      </div>

      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
          <button type="submit" class="btn btn-default">저장하기</button>
        </div>
      </div>
    </form>
    <!--// 추가를 위한 HTML 폼 끝  -->
  </div>
</body>
</html>