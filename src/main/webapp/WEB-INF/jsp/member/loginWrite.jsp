<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인 화면</title>
	
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.13.3/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<script src="https://code.jquery.com/ui/1.13.3/jquery-ui.min.js"></script>
</head>

<style>
	body {
		font-size: 9pt;
		font-color: #333333;
		font-family: 맑은 고딕;
	}
	a {
		text-decoration: none;
	}
	table {
		width: 600px;
		border-collapse:collapse;
	}
	th, td {
		border: 1px solid #cccccc;
		padding: 3px;
		line-height: 1.6;
	}
	caption {
		font-size: 15pt;
		font-weight: bold;
		margin-top: 10px;
		margin-bottom: 10px;
	}
	.div_button {
		width: 600px;
		text-align: center;
		margin-top:5px;
	}
	
}
</style>

<script>

	$ ( function() {
		$('#btn_submit').click(function(){
			
			var userid = $.trim($('#userid').val());
			var pass = $.trim($('#pass').val());
			
			if (userid == "") {
				alert('아이디를 입력하세요');
				$('#userid').focus();
				return false;
			}
			if (pass == "") {
				alert('암호를 입력하세요.');
				$('#pass').focus();
				return false;
			}
			
			$.ajax({
				type: "POST",              // 메시지 전송 타입
				data: "userid="+userid+"&pass="+pass,    // 전송할 데이터
				url: "loginWriteSub.do",   // 요청할 경로
				dataType: "text",          // 리턴 타입
				success: function(data) {  // 성공한 경우
					if (data == "ok") {    // controller에서 "ok" 데이터가 올 시
						alert(userid + "님 로그인 되었습니다.");
						location="boardList.do";
					} else {
						alert("아이디 또는 비밀번호가 틀렸습니다.");
					}
				},
				error: function() {       // 실패할 경우 (장애 발생 등)
					alert("오류 발생");
				}
			});
		});
		
	});

</script>

<body>

	<%@ include file="../include/topMenu.jsp" %>
	<br>

	<form name="frm" id="frm">
		<table>
			<caption>로그인</caption>
			
			<tr>
				<th><label for="userid">아이디</label></th>
				<td>
					<input type="text" name="userid" id="userid" placeholder="아이디입력">
				</td>
			</tr>
			
			<tr>
				<th><label for="pass">암호</label></th>
				<td>
					<input type="password" name="pass" id="pass">
				</td>
			</tr>
		</table>
	</form>
	
	<div class="div_button">
		<button type="button" id="btn_submit">로그인</button>
		<button type="reset">초기화</button>
	</div>
	
</body>
</html>