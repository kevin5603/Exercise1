<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


	<h1>活動細節頁面</h1>
	<form action="#" id="formm">
		<fieldset >
			<input type="text" name="times" placeholder="出發時間"> 
			<select name="kinds">
				<option>親子</option>
				<option>音樂</option>
				<option>戶外</option>
				<option>刺激</option>
			</select> 
			<input type="text" name="note" placeholder="活動名稱"> 
			<input type="text" name="budget" placeholder="預算"> 
			<input type="submit" value="送出">
		</fieldset>
	</form>
<!-- 	<div> -->
<!-- 		<input type="button" id="bbb" value="新增行程"> -->
<!-- 	</div> -->
	
	
	
	<script src="../js/jquery-3.2.1.min.js"></script>
	<script>
// 	$(function(){
// 		$('#bbb').on('click',function(){
// 			console.log('test');
// 			$('#formm').append('<input type="text" name="times" placeholder="出發時間">'+
// 					'<select name="kinds"><option>親子</option><option>音樂</option>'+
// 					'<option>戶外</option><option>刺激</option></select> '+
// 				'<input type="text" name="note" placeholder="活動名稱"><input type="text" name="budget" placeholder="預算">'+
// 				'<br>');
// 		})
// 	});
	
	</script>

</body>
</html>