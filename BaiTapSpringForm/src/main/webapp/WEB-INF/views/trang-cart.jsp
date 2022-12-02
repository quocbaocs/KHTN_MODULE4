<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div>
	<h1 style="font-size: 50px">${title}</h1>
	<table
		style="width: 100%; border-collapse: collapse;" border="1">
		<tr>
			<th>Title</th>
			<th>Quantity</th>
			<th>Price</th>
			<th>Image</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${list}" var="sp">

			<tr>
				<td>${sp.title}</td>
				<td><input type="number" value="${sp.quantity }"></td>
				<td><fmt:formatNumber value="${sp.price }" /></td>
				<td><img src='<c:url value="/img/${sp.imageUrl}"/>'
					width="50px" height="80px"></td>
				<td><a href="del-cart?id=${sp.productId}"><img
						src="<c:url value="/img/trash.png"/>"></a></td>
			</tr>
		</c:forEach>

	</table>
</div>
