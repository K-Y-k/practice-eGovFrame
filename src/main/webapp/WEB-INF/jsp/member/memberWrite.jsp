<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원 가입 화면</title>
	
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
	$( function() {
		/* datepicker라는 함수에 기능을 부여 */
		$("#birth").datepicker({
			changeMonth: true,
			changeYear: true
		});
		
		/* 중복 체크 기능 부여 */
		$("#btn_idcheck").click(function(){
			
			var userid = $.trim($("#userid").val()); // 현재 창에 입력된 값
			if (userid == "") {
				alert("아이디를 입력해주세요.");
				$("#userid").focus();
				return false;
			}
			
			// idcheck.do로 중복된 아이디인지 체크 (비동기 전송 방식 활용)
			$.ajax({
				type: "POST",              // 메시지 전송 타입
				data: "userid="+userid,    // 전송할 데이터
				url: "idcheck.do",         // 요청할 경로
				dataType: "text",          // 리턴 타입
				success: function(data) {  // 성공한 경우
					if (data == "ok") {    // controller에서 "ok" 데이터가 올 시
						alert("사용 가능한 아이디 입니다.");
					} else {
						alert("이미 사용 중인 아이디 입니다.");
					}
				},
				error: function() {       // 실패할 경우 (장애 발생 등)
					alert("오류 발생");
				}
			});
		});
		
		/* 우편번호 찾기 기능 부여 */
		$("#btn_zipcode").click(function(){
			var w = 500;
			var h = 100;
			var url = "post1.do";
			
			window.open(url, 'zipcode', 'width=' + w + ', height='+h);
		});
		
		
		/* 저장 click 함수에 기능을 부여 */
		$("#btn_submit").click(function() {
			
			var userid = $("#userid").val();
			var pass = $("#pass").val();
			var name =$("#name").val();
			userid = $.trim(userid);
			pass = $.trim(pass);
			name = $.trim(name);
			
			if (userid == "") {
				alert("아이디를 입력해주세요.");
				$("#userid").focus();
				return false;
			}

			if (pass == "") {
				alert("비밀번호를 입력해주세요.");
				$("#pass").focus();
				return false;
			}

			if (name == "") {
				alert("이름을 입력해주세요.");
				$("#name").focus();
				return false;
			}
			
			$("#userid").val(userid);
			$("#pass").val(pass);
			$("#name").val(name);
			
			var formData = $("#frm").serialize();
			
			$.ajax({ 
				type: "POST",             // 메시지 전송 타입
				data: formData,           // 전송할 데이터
				url: "memberWriteSave.do", // 요청할 경로
				dataType: "text",         // 리턴 타입
				success: function(data) { // 성공한 경우
					if (data == "ok") {   // controller에서 "ok" 데이터가 올 시
						alert("저장 완료");
						location="loginWrite.do";
					} else {
						alert("저장 실패");
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
			<caption>회원가입 폼</caption>
			
			<tr>
				<th><label for="userid">아이디</label></th>
				<td>
					<input type="text" name="userid" id="userid" placeholder="아이디입력">
					<button type="button" id="btn_idcheck">중복체크</button>
				</td>
			</tr>
			
			<tr>
				<th><label for="pass">암호</label></th>
				<td>
					<input type="password" name="pass" id="pass">
				</td>
			</tr>
	
			<tr>
				<th><label for="name">이름</label></th>
				<td>
					<input type="text" name="name" id="name">
				</td>
			</tr>
			
			<tr>
				<th><label for="name">성별</label></th>
				<td>
					<input type="radio" name="gender" id="genderM" value="M">
					<label for="genderM">남</label>

					<input type="radio" name="gender" id="genderF" value="F">
					<label for="genderF">여</label>
				</td>
			</tr>
			
			<tr>
				<th><label for="birth">생년월일</label></th>
				<td>
					<input type="text" name="birth" id="birth" readonly>
				</td>
			</tr>
			
			<tr>
				<th><label for="phone">연락처</label></th>
				<td>
					<input type="text" name="phone" id="phone"> (ex) 010-1234-1234)
				</td>
			</tr>
			
			<tr>
				<th><label for="address">주소</label></th>
				<td>
					<input type="text" name="zipcode" id="zipcode">
					<button type="button" id="btn_zipcode">우편번호 찾기</button>
					<br>
					<input type="text" name="address" id="address">
				</td>
			</tr>
		</table>
	</form>
	
	<div class="div_button">
		<button type="button" id="btn_submit">저장</button>
		<button type="reset">초기화</button>
	</div>
	
</body>
</html>