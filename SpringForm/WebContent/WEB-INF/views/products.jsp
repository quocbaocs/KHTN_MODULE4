<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div style="display: flex; flex-flow: row wrap;">
	<c:forEach items="${products}" var="p">
		<figure style="width: 250px;">
			<img alt="${p.imageUrl}" src="img/${p.imageUrl}" width="200px" height="200px">
			<figcaption>${p.title}</figcaption>
		</figure>
	</c:forEach>
</div>