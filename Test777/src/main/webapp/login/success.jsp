<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>成功登入</h1>
	<h2>主Key${ans.memberID }</h2>
	<h2>帳號:${ans.account }</h2>
	<h2>密碼:${ans.psd }</h2>
	
	<a href="../activity/schedule.jsp">建立行程</a>
</body>
</html>