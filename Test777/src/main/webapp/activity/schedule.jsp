<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>創立行程頁面</h1>
	<form action="actDetail.jsp">
		起始時間:<input type="text" name="actStartDate"> <br>
		地區:<input type="text"name="actRegion">  <br>
		活動標題:<input type="text" name="actTitle"><hr>
		上傳圖片:<hr>
		簡介:<textarea rows="20px" cols="40px" name="Introduction"></textarea><br>
		<input type="submit" value="下一步">
	</form>

</body>
</html>