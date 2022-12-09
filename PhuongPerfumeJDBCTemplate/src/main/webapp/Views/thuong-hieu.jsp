<%-- 
    Document   : thuong-hieu
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="brands-area">
	<div class="zigzag-bottom"></div>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="brand-wrapper">
					<div class="brand-list">
						<c:forEach items="${dsThuongHieu}" var="th">
							<img src="img/${th.hinhAnh }" alt="">
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
