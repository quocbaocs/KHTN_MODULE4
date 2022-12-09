<%-- 
    Document   : quang-cao-slider
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <div class="slider-area">
        	<!-- Slider -->
			<div class="block-slider block-slider4">
				<ul class="" id="bxslider-home4">
				<c:forEach items="${dsqc}" var="qc">
					<li>
						<img src="img/${qc.hinhAnh }" alt="Slide">
						<div class="caption-group">
							<h2 class="caption title">
								${qc.thongDiep }
							</h2>
							<a class="caption button-radius" href="#"><span class="icon"></span>Shop now</a>
						</div>
					</li>
					</c:forEach>
				</ul>
			</div>
			<!-- ./Slider -->
    </div> <!-- End slider area -->