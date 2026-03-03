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
	<title>우편찾기 화면</title>
	
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.13.3/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<script src="https://code.jquery.com/ui/1.13.3/jquery-ui.min.js"></script>
</head>

<script>
	$(function(){
		$('#btn_send').click(function(){
			var addr = $('#address').val();
			// var addr = "[123456] 대구광역시 수성구 황금동12" 
			var addr_array = addr.split(" ");
			var zipcode = addr_array[0].substring(1, addr[0].length-1);
			var address = addr.replace(addr_array[0], "");
			address = $.trim(adress);
			
			opener.document.frm.zipcode.value = zipcode;
			opener.document.frm.address.value = address;

			self.close();
		});
	});
</script>

<body>

	<div style="width:100%; text-align:center;">
		<select name="address" id="address">
			<c:forEach var="result" items="${resultList}">
				<option value="${result.addr}">${result.addr}</option>
			</c:forEach>
		</select>
		
		<br>
		
		<button type="button" id="btn_send">적용하기</button>
	</div>
	
</body>
</html>