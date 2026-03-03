<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<body>
	<table>
		<tr>
			<th>부서번호</th>
			<td>${result.deptno}</td>
		</tr>
		<tr>
			<th>부서이름</th>
			<td>${result.dname}</td>
		</tr>
		<tr>
			<th>부서위치</th>
			<td>${result.loc}</td>
		</tr>
		<tr>
			<th colspan="2">
				<button type="button" onclick="location='deptModifyWrite.do?deptno=${result.deptno}'">수정</button>
				<button type="button" onclick="location='deptDelete.do?deptno=${result.deptno}'">삭제</button>
			</th>
		</tr>
	</table>
</body>
</html>