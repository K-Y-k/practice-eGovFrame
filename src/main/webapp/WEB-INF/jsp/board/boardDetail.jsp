<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"      uri="http://java.sun.com/jsp/jstl/functions" %>

<% pageContext.setAttribute("newLine", "\n"); %>
<c:set var="content" value="${fn:replace(boardVO.content, newline, '<br>') }" />


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시판 상세 화면</title>
	
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.13.3/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<script src="https://code.jquery.com/ui/1.13.3/jquery-ui.min.js"></script>
</head>

<style>
	body {
		font-size:9pt;
	}
	button {
		font-size:9pt;
	}
	table {
		width:600px;
		border-collapse:collapse;
	}
	th, td {
		border:1px solid #cccccc;
		padding:3px;
	}
	.input1 {
		width:98%;
	}
	.textarea {
		width:98%;
		height:70px;
	}
</style>

<body>
	<form id="frm">
		<table>
			<caption>게시판 상세</caption>
			<tr>
				<th width="20%"><label for="title">제목</label></th>
				<td width="80%">${result.title}</td>
			</tr>
			<tr>
				<th><label for="name">글쓴이</label></th>
				<td>${result.name}</td>
			</tr>
			<tr>
				<th><label for="content">내용</label></th>
				<td height="50">${result.content}</td>
			</tr>
			<tr>
				<th>등록일</th>
				<td>${result.rdate}</td>
			</tr>
			
			<tr>
				<th colspan="2">
					<button type="button" onclick="location.href='boardList.do'">목록</button>
					<button type="button" onclick="location.href='boardModifyWrite.do?unq=${result.unq}'">수정</button>
					<button type="button" onclick="location.href='passWrite.do?unq=${result.unq}'">삭제</button>
				</th>
			</tr>
		</table>
	</form>
</body>
</html>