<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
String cp = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="<%=cp%>/yooWorldMember/css/divStyle.css"/>


<script type="text/javascript" src="<%=cp %>/yooWorldMember/js/util.js"></script>

<script type="text/javascript">
	function sendIt(){
		
		var f = document.myForm;
		
		
		
		str = f.id.value;
		str = str.trim();
		if(!str){
			alert("아이디를 좀 입력하시는게 어떨지요?");
			f.id.focus();
			return;
		}
		
		str = f.pwdTry.value;
		str = str.trim();
		if(!str){
			alert("비번을 좀 입력하시는게 어떨지요?");
			f.pwdTry.focus();
			return;
		}
		
		str = f.pwd.value;
		str = str.trim();
		if(!str){
			alert("비번확인을 좀 입력하시는게 어떨지요?");
			f.pwd.focus();
			return;
		}
		
		
		str2 = f.pwdTry.value;
		str2 = str2.trim();
		if(str!=str2){
			alert("비번 확인 좀 하시는게 어떨지요?");
			f.pwd.value="";
			f.pwdTry.value="";
			f.pwdTry.focus();
			return;
		}
		
		str = f.name.value;
		str = str.trim();
		if(!str){
			alert("이름을 좀 입력하시는게 어떨지요?");
			f.name.focus();
			return;
		}
		
		str = f.tel.value;
		str = str.trim();
		if(!str){
			alert("전화번호 좀 입력하시는게 어떨지요?");
			f.tel.focus();
			return;
		}
		
		str = f.birth.value;
		str = str.trim();
		if(!str){
			alert("생일을 좀 입력하시는게 어떨지요?");
			f.birth.focus();
			return;
		}
		
		f.action = "<%=cp%>/join/resistration_ok.yoo";
		f.submit();
		
	}

	

	
	function duplicate(){
		var f = document.myForm;
		
		str = f.id.value;
		str = str.trim();
		if(!str){
			alert("아이디를 좀 입력하시는게 어떨지요?");
			f.id.focus();
			return;
		}
		
		
		
		f.action = "<%=cp%>/join/duplicated_ok.yoo?id="+str;
		f.submit();
		
	}

	
	
	
	
	

</script>
	

</head>
<body>

	<div class="container">
		<div>회원가입</div>
		
		
		
		<form action="" method="post" name="myForm">
			<!-- 
			<div>
				<dl>
					<dt>아&nbsp;이&nbsp;디</dt>
					<dd>
						<input type="text" name="id" value=${id }>
						<input type="button" value="중복확인" onclick="duplicate()"/>
						<div>${message }</div>
					</dd>
				</dl>
			</div> -->
		
		 <div class="form-group">
  		 <label for="exampleInputName2">아이디</label>
    	 <input type="text" name="id" value="${id }" class="form-control" id="exampleInputName2" placeholder="아이디">
  		 <div><font color="blue">${message }</font></div>
  		 <input type="button" value="중복확인" onclick="duplicate()" class="btn btn-default"/>
  		 </div>
		
			
		 <div class="form-group">
  		 <label for="exampleInputName2">패스워드</label>
		 <input type="password" name="pwdTry" class="form-control" id="exampleInputName2" placeholder="패스워드"/>
		 </div>
		 
		 <div class="form-group">
  		 <label for="exampleInputName2">패스워드 확인</label>
		 <input type="password" name="pwd" class="form-control" id="exampleInputName2" placeholder="패스워드 재입력"/>
		 </div>
		 
		 <div class="form-group">
  		 <label for="exampleInputName2">이름</label>
		 <input type="text" name="name" class="form-control" id="exampleInputName2" placeholder="이름"/>
		 </div>
			
		
		 <div class="form-group">
  		 <label for="exampleInputName2">전화번호</label>
		 <input type="text" name="tel" class="form-control" id="exampleInputName2" placeholder="010-0000-0000"/>
		 </div>
		 
		 <div class="form-group">
  		 <label for="exampleInputName2">생년월일</label>
		 <input type="text" name="birth" class="form-control" id="exampleInputName2" placeholder="YYYY-MM-DD"/>
		 </div>
					
		
			<div>
				<div>
					<input type="button" value=" 가입하기 " onclick="sendIt();" class="btn btn-success"/>	
					<input type="button" value=" 취소 " onclick="location='<%=cp%>';" class="btn btn-danger"/>
				</div>
			</div>

		</form>
		
		
	</div>


</body>
</html>