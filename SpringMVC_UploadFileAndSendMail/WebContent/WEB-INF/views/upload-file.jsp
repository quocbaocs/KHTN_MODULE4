<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form action="upload-file" method="post" enctype="multipart/form-data">
	<h1>Minh họa Upload File</h1>
		<!-- Example upload one file
	<p>
		<label>Tên tập tin: </label><input type="file" name="file"
			multiple="multiple">
	</p>
	<p>
		<input type="submit" name="btnUpload" value="upLoad">
	</p>

	<c:if test="${not empty tapTin}">
		<img src="img/${tapTin}" width="100" height="100">
	</c:if>
	 -->

	<!-- Upload multi file -->
	<p>
		<label>Tên tập tin: </label><input type="file" name="file"
			multiple="multiple">
	</p>
	<p>
		<input type="submit" name="btnUpload" value="upLoad">
	</p>
	<c:if test="${not empty tapTin}">
		<c:forEach items="${tapTins}" var="tapTin">
			<img src="img/${tapTin}" width="100" height="100">
		</c:forEach>
	</c:if>
</form>