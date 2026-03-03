<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>게시판 등록 화면</title>
	
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

<script>
	$(function() {
		// 초깃값 설정
		$("#title").val("제목입력");
	});


	function fn_submit() {
		/* trim() -> 앞 뒤 공백 제거, java, jsp */
		if ( $.trim($("#title").val()) == "" ) {
		    alert("제목을 입력해주세요.");
		    $("#title").focus();
		    return false;
		}
		$("#title").val( $.trim($("#title").val()) );
		
		if ( $.trim($("#pass").val()) == "" ) {
		    alert("암호를 입력해주세요.");
		    $("#pass").focus();
		    return false;
		}
		$("#pass").val( $.trim($("#pass").val()) );

		/* if (document.frm.title.value == "") {
			alert("제목을 입력해주세요!");
			document.frm.title.focus();
			return false;
		}
		if (document.frm.pass.value == "") {
			alert("암호를 입력해주세요!");
			document.frm.title.focus();
			return false;
		}
		document.frm.submit(); // 동기전송방식 */
		
		console.log('dd');
		
		
		var formData = $("#frm").serialize();
		console.log(formData);
		
		
		// ajax: 비동기 전송방식의 기능을 가지고 있는 jquery 함수
		$.ajax({ 
			type: "POST",             // 메시지 전송 타입
			data: formData,           // 전송할 데이터
			url: "boardWriteSave.do", // 요청할 경로
			dataType: "text",         // 리턴 타입
			success: function(data) { // 성공한 경우
				if (data == "ok") {   // controller에서 "ok" 데이터가 올 시
					alert("저장 완료");
					location="boardList.do";
				} else {
					alert("저장 실패");
				}
			},
			error: function() {       // 실패할 경우 (장애 발생 등)
				alert("오류 발생");
			}
		});
	} 
</script>

<body>
	<form id="frm">
		<table>
			<caption>게시판 등록</caption>
			<tr>
				<th width="20%"><label for="title">제목</label></th>
				<td width="80%"><input type="text" name="title" id="title" class="input1"></td>
			</tr>
			<tr>
				<th><label for="pass">암호</label></th>
				<td><input type="password" name="pass" id="pass"></td>
			</tr>
			<tr>
				<th>글쓴이</th>
				<td><input type="text" name="name" id="name"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content" id="content" class="textarea"></textarea></td>
			</tr>
			<tr>
				<th colspan="2">
					<button type="button" onclick="location.href='boardList.do'">목록</button>
					<button type="submit" onclick="fn_submit(); return false;">저장</button>
					<button type="reset">취소</button>
				</th>
			</tr>
		</table>
	</form>
</body>
</html>