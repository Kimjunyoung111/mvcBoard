<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답변하기</title>
</head>
<body>

<table width="600" align="center" border="1" cellpadding="5" cellspacing="0">
	<tr>
		<th colspan="4">질문글 보기</th>
	</tr>
	<tr>
		<td width="80" align="center">글번호</td>
		<td width="320" align="center">이름</td>
		<td width="120" align="center">작성일</td>
		<td width="80" align="center">조회수</td>
	</tr>
	<tr>
		<td align="center">${vo.idx}</td>
		<td align="center">
			<c:set var="name" value="${fn:replace(vo.name, '<', '&lt;')}"/>
			<c:set var="name" value="${fn:replace(name, '>', '&gt;')}"/>
			${name}
		</td>
		<td align="center">
			<jsp:useBean id="date" class="java.util.Date"/>
			<c:if test="${date.year == vo.writeDate.year && date.month == vo.writeDate.month &&
				date.date == vo.writeDate.date }">
				<fmt:formatDate value="${vo.writeDate}" pattern="a h:mm"/>
			</c:if>
			<c:if test="${date.year != vo.writeDate.year || date.month != vo.writeDate.month ||
				date.date != vo.writeDate.date }">
				<fmt:formatDate value="${vo.writeDate}" pattern="yyyy.MM.dd(E)"/>
			</c:if>
		</td>
		<td align="center">${vo.hit}</td>
	</tr>
	<tr>
		<td align="center">제목</td>
		<td colspan="3">
			<c:set var="subject" value="${fn:replace(vo.subject, '<', '&lt;')}"/>
			<c:set var="subject" value="${fn:replace(subject, '>', '&gt;')}"/>
			${subject}
		</td>
	</tr>
	<tr>
		<td align="center">내용</td>
		<td colspan="3">
			<c:set var="content" value="${fn:replace(vo.content, '<', '&lt;')}"/>
			<c:set var="content" value="${fn:replace(content, '>', '&gt;')}"/>
			<c:set var="content" value="${fn:replace(content, enter, '<br/>')}"/>
			${content}
		</td>
	</tr>
</table>

<hr width="600" size="3" color="red" align="center"/>

<form action="replyInsert.nhn" method="post">

	<input type="text" name="idx" value="${vo.idx}"/> 
	<input type="text" name="gup" value="${vo.gup}"/> 
	<input type="text" name="lev" value="${vo.lev}"/> 
	<input type="text" name="seq" value="${vo.seq}"/> 
	<input type="text" name="currentPage" value="${currentPage}"/> 

	<table width="600" align="center" border="1" cellpadding="5" cellspacing="0">
		<tr>
			<th colspan="2">답글 쓰기</th>
		</tr>
		<tr>
			<td width="100" align="center">이름</td>
			<td width="500">
				<input type="text" name="name"/>
			</td>
		</tr>
		<tr>
			<td align="center">제목</td>
			<td>
				<input type="text" name="subject" style="width: 98%"/>
			</td>
		</tr>
		<tr>
			<td align="center">내용</td>
			<td>
				<textarea rows="10" name="content" style="resize: none; width: 98%;"></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="저장하기"/>
				<input type="reset" value="다시쓰기"/>
				<input type="button" value="돌아가기" onclick="history.back()"/>
				<input type="button" value="목록보기" onclick="location.href='list.nhn?currentPage=${currentPage}'"/>
			</td>
		</tr>
	</table>
</form>

</body>
</html>









