<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div style="display: flex; flex-flow: row wrap; margin-left: 100px ">
	<c:forEach items="${products}" var="p">
		<figure style="width: 250px;text-align: center;">
			<img alt="${p.imageUrl}" src="${pageContext.request.contextPath }/img/${p.imageUrl}" width="200"
				height="200">
			<figcaption>${p.title}</figcaption>
		</figure>
	</c:forEach>

</div>
<p align="center">
	<c:forEach var="i" begin="1" end="${tongSoTrang}">
		<!-- <a href="index?trang=${i}">${i}</a> -->
		<a href="${pageContext.request.contextPath}/index/${i}">${i}</a>
	</c:forEach>
</p>