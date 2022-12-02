<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>
	<h1>${product.title }</h1>
	<form action="search">
		<input type="search" name="keyword"><input type="submit" value="Search">
	</form>
	<table style="width: 100%;">
		<tr>
			<td><img src='<c:url value="/img/${product.imageUrl }"/>'
				width="200px" height="250px"></td>
			<td style="vertical-align: top; line-height: 1.5">
				<h3>${product.title }</h3> ISBN:<span><b>${product.isbn }</b><span><br>
						Pages:<b>${product.page }</b><br> Price: <b>${product.price }</b><br>
						<form action="${pageContext.request.contextPath}/cart/add" method="post">
						<input type="hidden" name="productId" value="${product.productId}"/>
							<input type="number" name="quantity" min="1" step="1" value="1">&nbsp;<input
								type="submit" value="Add to Cart"
								style="background-color: blue; color: white; border: none; height: 23px">
						</form>
			</td>
		</tr>

	</table>

</div>