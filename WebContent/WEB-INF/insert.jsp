<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답변형 게시판 입력하기</title>
</head>
<body>

<form action="insertOK.nhn" method="post">
	<table width="500" align="center" border="1" cellpadding="5" cellcpacing="0">
	
		<tr>
			<th colspan="2">답변형 게시판 입력하기</th>
		</tr>
		
		<tr>
			<th width="100">이름</th>
			<td width="400">
				<input type="text" name="name">
			</td>
		</tr>
		
		<tr>
			<th>제목</th>
			<td>
				<input type="text" name="subject">
			</td>
		</tr>
		
		<tr>
			<th>내용</th>
			<td>
				<textarea rows="10" cols="50" name="content" style="resize: none;"></textarea>
			</td>
		</tr>
	
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="저장하기"/>
				<input type="reset" value="다시쓰기"/>
				<input type="button" value="돌아가기" onclick="history.back()"/>
			</td>
		</tr>
	
	</table>
</form>

</body>
</html>
















