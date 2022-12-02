<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div style="display: flex; flex-flow: row wrap;">
	<c:forEach items="${products}" var="p">
		<figure style="width: 250px; margin-bottom: 20px;">
			<img alt="${p.imageUrl}" src="<c:url value="/img/${p.imageUrl}"/>" width="200px"
				height="200px">
			<figcaption><a href="<c:url value='/home/detail?id=${p.productId}'/>">${p.title}</a></figcaption>
		</figure>
	</c:forEach>
</div>
 <c:if test="${tongSoTrang!=null}">
<div align="center">
	<a href="?trang=1">&lt;&lt; </a>&nbsp; 
	<a href="?trang=${param.trang-1<1?1:trang-1 }">&lt; </a>
	&nbsp; 
	<c:forEach begin="1" end="${tongSoTrang}" var="i">
		<a href="?trang=${i}">${i }</a>
	</c:forEach>
&nbsp; 
	<a href="?trang=${param.trang+1<tongSoTrang?trang+1:tongSoTrang }">&gt; </a>&nbsp; 
	<a href="?trang=${tongSoTrang}">&gt;&gt; </a>
	</c:if>
	
</div>