<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form action="them-loai-sua4" method="post" modelAttribute="loaisua">
	<p>
		<form:label path="maLoai">Mã loại</form:label>
		<form:input path="maLoai" />
	</p>
	<p>
		<form:label path="tenLoai">Tên loại</form:label>
		<form:input path="tenLoai" />
	</p>
	<p>

		<form:button>Save</form:button>
	</p>
</form:form>