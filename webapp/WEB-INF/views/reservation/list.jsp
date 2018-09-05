<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page session="false" %>

<html>
<head>
aaaaaaaaaaaaaaaaaaaaa
</head>
<body>
<center>
	<table cellpadding="3" cellspacing=2 width=450 border=1>
	    <tr>
	        <td width=150 align=center>예약일자</td>
	        <td width=100 align=center>방1</td>
	        <td width=100 align=center>방2</td>
	        <td width=100 align=center>방3</td>
	    </tr>
	    
		<c:forEach items="${reservations}" var="reservation">
			<tr>
				<td width=150 align=center>${reservation.date}</td>
				<c:choose>
					<c:when test="${reservation.reservedRoomCheck1 ne '예약가능'}">
						<td width=100 align=center>${reservation.reservedRoomCheck1}</td>
					</c:when>
					<c:otherwise>
						<td width=100 align=center><c:url value="/reservation_insert?reserveDate=${reservation.date}" var="url"/><a href="${url}">${reservation.reservedRoomCheck1}</a></td>
					</c:otherwise>
				</c:choose>
 
 				<c:choose>
					<c:when test="${reservation.reservedRoomCheck2 ne '예약가능'}">
						<td width=100 align=center>${reservation.reservedRoomCheck2}</td>
					</c:when>
					<c:otherwise>
						<td width=100 align=center><c:url value="/reservation_insert?reserveDate=${reservation.date}" var="url"/><a href="${url}">${reservation.reservedRoomCheck2}</a></td>
					</c:otherwise>
				</c:choose>
				
    			<c:choose>
					<c:when test="${reservation.reservedRoomCheck3 ne '예약가능'}">
						<td width=100 align=center>${reservation.reservedRoomCheck3}</td>
					</c:when>
					<c:otherwise>
						<td width=100 align=center><c:url value="/reservation_insert?reserveDate=${reservation.date}" var="url"/><a href="${url}">${reservation.reservedRoomCheck3}</a></td>
					</c:otherwise>
				</c:choose>
			</tr>
		</c:forEach>
	</table>
</center>

</body>
</html>
