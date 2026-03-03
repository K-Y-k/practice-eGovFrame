<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>게시판 삭제 화면</title>
	
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.13.3/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<script src="https://code.jquery.com/ui/1.13.3/jquery-ui.min.js"></script>
</head>

<script>
	$(function() {
		$('#delBtn').click(function() {

	        var pass = $('#pass').val();
	        pass = $.trim(pass);

	        if (pass === "") {
	            alert("암호를 입력하세요.");
	            $('#pass').focus();
	            return;
	        }

	        var sendData = "unq=${unq}&pass=" + pass;

	        $.ajax({
	            type: "POST",
	            data: sendData,
	            url: "boardDelete.do",
	            dataType: "text",
	            success: function(data) {
	                if (data == "ok") {
	                    alert("삭제 완료");
	                    location = "boardList.do";
	                } else if (data == "passIncorrect") {
	                    alert("암호가 일치하지 않습니다.");
	                } else {
	                    alert("삭제 실패 \n관리자에게 연락해주세요.");
	                }
	            },
	            error: function() {
	                alert("오류 발생");
	            }
	        });
	    });
		
	});
</script>

<body>

	<form>
	
	</form>
	<table>
		<th>암호입력</th>
		<td><input type="password" id="pass"></td>
		<td><button type="button" id="delBtn">삭제하기</button></td>
	</table>

</body>
</html>