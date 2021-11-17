<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 보기</title>
</head>
<body>

<form action="update.nhn" method="post">
	<table width="600" align="center" border="1" cellpadding="5" cellspacing="0">
		<tr>
			<th colspan="4">게시글 보기</th>
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
				<input type="text" name="subject" value="${vo.subject}" style="width: 98%"/>
			</td>
		</tr>
		<tr>
			<td align="center">내용</td>
			<td colspan="3">
				<textarea rows="10" name="content" style="resize: none; width: 98%;">${vo.content}</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="4" align="center">
				<input type="hidden" name="idx" value="${vo.idx}"/>
				<input type="hidden" name="currentPage" value="${currentPage}"/>
				<input type="submit" value="수정하기"/>
				<input type="button" value="삭제하기" onclick="location.href='delete.nhn?idx=${vo.idx}&currentPage=${currentPage}'"/>
				<input type="button" value="답변하기" onclick="location.href='reply.nhn?idx=${vo.idx}&currentPage=${currentPage}'"/>
				<input type="button" value="돌아가기" onclick="location.href='list.nhn?currentPage=${currentPage}'"/>
			</td>
		</tr>
	</table>
</form>

</body>
</html>













