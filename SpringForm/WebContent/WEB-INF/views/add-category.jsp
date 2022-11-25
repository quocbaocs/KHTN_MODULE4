<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form action="add-category" modelAttribute="category" method="post">
	<h1>Add Category</h1>
	<p>
		<form:label path="categoryName">Name:</form:label>
		<form:input path="categoryName" />
	</p>
	<p>
		<form:label path="parentId">Parent:</form:label>
		<form:select path="parentId">
			<form:options items="${parents }" itemLabel="categoryName"
				itemValue="categoryId" />
		</form:select>
	</p>
	<p>
		<form:button>Save</form:button>
	</p>
</form:form>