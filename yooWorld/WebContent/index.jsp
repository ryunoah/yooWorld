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
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="<%=cp%>/yooWorldMember/css/divStyle.css"/>
</head>
<body>
<div class="container">
<c:choose>
	<c:when test="${empty sessionScope.memberInfo.id }">
		홈페이지를 이용하기 위해서 로그인이 필요합니다.
	</c:when>

	<c:otherwise>
		${sessionScope.memberInfo.name } 님 환영합니다.
	</c:otherwise>
</c:choose>

<c:choose>
	<c:when test="${empty sessionScope.memberInfo.id }">
		여기에 목록들<br/>
		
		예를들어<br/>
		<a href="<%=cp %>/join/login.yoo">게시판</a><br/>
		이런식으로<br/>
		
	</c:when>
	
	<c:otherwise>
		${sessionScope.memberInfo.name } 님 목록들<br/>
		<a href="<%=cp%>/imageBoard/photoGallery.yoo">사진첩</a>
	</c:otherwise>
</c:choose>

<c:choose>
	<c:when test="${empty sessionScope.memberInfo.id }">
		<a href="<%=cp %>/join/login.yoo">로그인</a><br/>
		<a href="<%=cp %>/join/resistration.yoo">회원가입</a><br/>
	</c:when>
	
	<c:otherwise>
		<a href="<%=cp %>/join/logout.yoo">로그아웃</a><br/>	
	</c:otherwise>

</c:choose>

</div>

</body>
</html>