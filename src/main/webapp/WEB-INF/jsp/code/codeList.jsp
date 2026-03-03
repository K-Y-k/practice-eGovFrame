<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<style>
	table {
		width:400px;
		border-collapse:collapse; /* cell 간격 없애기 */
	}
	th, td {
		border:1px solid #cccccc;
		padding:5px;
	}
</style>

<script>
	function fn_delete(code) {
		if (confirm("정말 삭제하시겠습니까?")) {
			location = "codeDelete.do?code=" + code;
		}
	}
	
	function fn_update(code) {
		location = "codeModifyWrite.do?code=" + code;
	}
</script>

<body>
	<table>
		<caption>
			<div>코드목록</div>
			<br>
			<div style="width=100%; text-align:left;">Total : ${resultTotal }개</div>
		</caption>
		<colgroup>
			<col width="14%"/>
			<col width="30%"/>
			<col width="30%"/>
			<col width="26%"/>
		</colgroup>
		
		<tr>
			<th>번호</th>
			<th>그룹명</th>
			<th>코드명</th>
			<th>구분</th>
		</tr>
		
		<!-- 변수 선언 및 값 설정 -->
		<c:set var="count" value="1"></c:set>
		
		<c:forEach var="code" items="${resultList}">
			<tr align="center">
				<%-- 이 코드가 내장된 형식 <c:out value="${count }"/> --%>
				<td>${count }</td>
				<td>${code.gid }</td>
				<td>${code.name }</td>
				<td>
					<button type="button" onclick="fn_update('${code.code}')">수정</button>
					<button type="button" onclick="fn_delete('${code.code}')">삭제</button>
				</td>
			</tr>
			<c:set var="count" value="${count+1}"/>
		</c:forEach>
	</table>
</body>
</html>