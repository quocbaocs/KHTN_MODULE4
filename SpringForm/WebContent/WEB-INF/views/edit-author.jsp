<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>Edit Author</h1>
<form action="edit-author" method="post">
	<table>
		<tr>
			<td><label>Name</label></td>
			<input type="hidden" name="id" value="${au.id}">
			<td><input type="text" size="30" name="name" value="${au.name}"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Save" name="btnSave"></td>
		</tr>
	</table>
</form>
    