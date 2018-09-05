<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
	<script>
		document.getElementByName("room").value
	</script>
</head>
<body>

<table cellpadding="3" cellspacing=2 width=800 border=1>
    <FORM METHOD='POST' action='reservation_write'>
    <tr>
        <td width=100 align=center>성명</td>
        <td><input type="text" name="userName" size="50" value="${userName}" readonly></td>
    </tr>
    <tr>
        <td width=100 align=center>예약일자</td>
        <td width=700><input type="text" value="${reserveDate}" name="reserveDate" size = "50" readonly></td>
    </tr>
    <tr>
        <td width=100 align=center>예약방</td>
        <td>
        	<select name="room">
				<option value="1">싼방</option>
				<option value="2">좀싼방</option>
				<option value="3">비싼방</option>
			</select>
		</td>
    </tr>
    <tr>
        <td width=100 align=center>전화번호</td>
        <td><input type="text" value="" name="tel" size = "50"></td>
    </tr>
    <tr>
        <td width=100 align=center>입금자명</td>
        <td><input type="text" value="" name="depositor" size = "50"></td>
    </tr>
    <tr>
        <td width=100 align=center>남기실말</td>
        <td><textarea rows="10" cols="60" name="comment" ></textarea></td>
    </tr>
    <tr>
    	<td width=660></td>
    	<td>
    		<input type=button value="취소" onclick="javascript:location.href='reservation_list';" />
    		<input type=submit value="예약">
    	</td>
    </tr>
    </FORM>
</table>
</body>
</html>
