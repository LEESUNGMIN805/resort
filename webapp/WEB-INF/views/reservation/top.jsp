<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>

<table cellpadding="3" cellspacing=2 width=800 border=1>
    <FORM METHOD='POST' action='gongji_write'>
    <tr>
        <td width=100 align=center>번호</td>
        <td><input type="text" name="id" size = "50" value="${maxid+1}" readonly> </td>
    </tr>
    <tr>
        <td width=100 align=center>제목</td>
        <td> <input type="text" name="title" size = "50"> </td>
    </tr>
    <tr>
        <td width=100 align=center>일자</td>
        <td width=700>${selectOne.date}</td>
    </tr>
    <tr>
        <td width=100 align=center>조회수</td>
        <td> <input type="text" value=0 name="viewcnt" size = "50" readonly> </td>
    </tr>
    <tr>
        <td width=100 align=center>내용</td>
        <td><textarea rows="10" cols="60" name="content" ></textarea></td>
    </tr>
    <tr>
    <td width=660></td>
    <td><input type=button value="취소" onclick="javascript:location.href='gongji_list?page=1&itemSizePerPage=2';" />
    <input type=submit value="쓰기">
    </td>
    
    </tr>
    
    </FORM>
</table>


</body>
</html>