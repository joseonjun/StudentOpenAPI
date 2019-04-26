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
    <h1 class='page-header'>�л�����</h1>

    <!-- �߰��� ���� HTML �� ���� -->
    <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/student/StudAddOk.do">
      <div class="form-group">
        <label for="name" class="col-sm-2 control-label">�л� �̸�</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" id="name" name="name" value="${item.getName()}"/>
        </div>
      </div>

      <div class="form-group">
        <label for="userid" class="col-sm-2 control-label">���̵�</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" id="userid" name="userid" value="${item.getUserid()}" />
        </div>
      </div>

      <div class="form-group">
        <label for="grade" class="col-sm-2 control-label">�г�</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" id="grade" name="grade" value="${item.getGrade()}" />
        </div>
      </div>

      <div class="form-group">
        <label for="idnum" class="col-sm-2 control-label">�ֹι�ȣ</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" id="idnum" name="idnum" value="${item.getIdnum()}" />
        </div>
      </div>

      <div class="form-group">
        <label for="birthdate" class="col-sm-2 control-label">�������</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" id="birthdate" name="birthdate" value="${item.getBirthdate()}" />
        </div>
      </div>

      <div class="form-group">
        <label for="tel" class="col-sm-2 control-label">��ȭ��ȣ</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" id="tel" name="tel" value="${item.getTel()}" />
        </div>
      </div>

      <div class="form-group">
        <label for="deptno" class="col-sm-2 control-label">�а���ȣ</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" id="deptno" name="deptno" value="${item.getProfno()}" />
        </div>
      </div>

      <div class="form-group">
        <label for="profno" class="col-sm-2 control-label">��������ȣ</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" id="profno" name="profno" value="${item.getProfno()}" />
        </div>
      </div>

      <div class="form-group">
        <label for="weight" class="col-sm-2 control-label">������</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" id="weight" name="weight"  value="${item.getWeight()}"/>
        </div>
      </div>


      <div class="form-group">
        <label for="height" class="col-sm-2 control-label">Ű</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" id="height" name="height" value="${item.getHeight()}" />
        </div>
      </div>

      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
          <button type="submit" class="btn btn-default">�����ϱ�</button>
        </div>
      </div>
    </form>
    <!--// �߰��� ���� HTML �� ��  -->
  </div>
</body>
</html>