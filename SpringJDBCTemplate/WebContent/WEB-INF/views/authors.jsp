<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


	<button style="width: 60px; height: 50px; background-color: lightblue; margin:10px  200px;" ><a href="add-author">Add Author</a></button>

<table border="1" style="margin: auto;">
	<tr>
		<th>Delete</th>
		<th>Id</th>
		<th>Name</th>
		<th>Edit</th>
		<th>Del</th>
	</tr>
	<c:forEach items="${authors}" var="au">
		<tr>
			<td><input type="checkbox" name="idDel" value="${au.id}" /></td>
			<td>${au.id }</td>
			<td>${au.name }</td>
			<td><a href="edit-author?id=${au.id}"><img
					src="img/edit.png"></a></td>
			<td><a href="del-author?id=${au.id}"><img
					src="img/trash.png"></a></td>
		</tr>
	</c:forEach>
</table>