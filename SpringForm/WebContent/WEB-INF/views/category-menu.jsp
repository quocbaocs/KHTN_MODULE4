<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:forEach items="${parents}" var="p">
	<p>
		<b>${p.categoryName}</b>
	</p>
	<ul style="list-style: none;">
		<c:forEach items="${children}" var="c">
			<c:if test="${p.categoryId==c.parentId}">
				<li><a href="${pageContext.request.contextPath}/index/category/${c.categoryId}">${c.categoryName}</a></li>
			</c:if>
		</c:forEach>
	</ul>
</c:forEach>