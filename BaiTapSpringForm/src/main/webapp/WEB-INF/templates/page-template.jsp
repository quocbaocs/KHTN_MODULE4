<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:insertAttribute name="tieuDe" /></title>
<style type="text/css">
*{
	margin: 0;
	box-sizing: border-box;
}
header, footer {
	height: 100px;
	background-color: #f8f8f8;
}

main {
	display: flex;
	width: 100%;
}

nav {
	width: 20%;
	background-color: #f8f8f8;
}

article {
	width: 80%;
	
	
}
</style>
</head>
<body>
	<header>

		<tiles:insertAttribute name="dauTrang" />
	</header>
	<main>
		<nav>
			<tiles:insertAttribute name="thucDon" />
		</nav>
		<article>
			<tiles:insertAttribute name="noiDung" />
		</article>
	</main>
	<footer>
	<h1>Footer</h1>
		<tiles:insertAttribute name="cuoiTrang" />
	</footer>
</body>
</html>