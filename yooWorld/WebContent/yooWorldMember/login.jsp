<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
String cp = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="<%=cp%>/yooWorldMember/css/divStyle.css"/>

<script type="text/javascript">

function login(){
	
	var f = document.myForm;
	
	if(!f.id.value){
		alert("아이디를 입력하세요");
		f.id.focus();
		return;
	}
	
	if(!f.pwd.value){
		alert("패스워드를 입력하세요");
		f.pwd.focus();
		return;
	}
	
		f.action="<%=cp%>/join/login_ok.yoo";
		f.submit();
	}
</script>

</head>
<body>

	<div class="container">
		<form action="" method="post" name="myForm">
		
			<div class="child">
				
					<label class="control-label" for="inputSuccess1">아이디</label>
					<input name="id" type="text" class="form-control" id="inputSuccess1" size="30px"/>			
								
			</div>
		
			<div class="child">
				<label class="control-label" for="inputSuccess1">패스워드</label>
					<input name="pwd" type="text" class="form-control" id="inputSuccess1" size="30px"/>							
			</div>
		
			<div class="form-group">
				<input type="button" class="btn btn-info" value="로그인" onclick="login();"/>
				<input type="button" class="btn btn-danger" value="취소" onclick="location='<%=cp%>';"/>
				<input type="button" class="btn btn-success" value="회원가입" onclick="location='<%=cp%>/join/resistration.yoo';"/>
			</div>
		
			<div>
				<p><font color="red"><b>${message }</b></font></p>
			</div>
		
		
			<div>
			<a href="">비밀번호 찾기</a>
			</div>
		</form>
	</div>


</body>
</html>