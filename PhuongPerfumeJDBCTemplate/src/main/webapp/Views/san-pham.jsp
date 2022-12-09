<%-- 
    Document   : san-pham
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="product-big-title-area">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="product-bit-title text-center">
					<h2>Shop</h2>
				</div>
			</div>
		</div>
	</div>
</div>


<div class="single-product-area">
	<div class="zigzag-bottom"></div>
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<div class="single-sidebar">
					<h2 class="sidebar-title">Tìm kiếm</h2>
					<form action="" method="get">
						<input type="text" placeholder="Thông tin tìm kiếm..."
							name="keyword"> <input type="submit" value="Tìm">
					</form>
				</div>

				<div class="single-sidebar">
					<h2 class="sidebar-title">Sản phẩm</h2>
					<c:forEach items="${dsTim}" var="sp">
						<div class="thubmnail-recent">
							<img src="<c:url value="/img/${sp.hinhAnh }"/>" class="recent-thumb" alt="">
							<h2>
								<a href="<c:url value="/san-pham/${sp.tenSanPham }/${sp.id}"/>">${sp.tenSanPham }</a>
							</h2>
							<div class="product-sidebar-price">
								<ins>
										<fmt:formatNumber value="${sp.donGiaKM}" />
										đ
									</ins>
									<del>
										<fmt:formatNumber value="${sp.donGia}" />
										đ
									</del>
							</div>
						</div>
					</c:forEach>
				</div>

			</div>

			<div class="col-md-8">
				<div class="product-content-right">
					<div class="product-breadcroumb">
						<a href="<c:url value="/"/>">Trang chủ</a> <a
							href="<c:url value="/trang-chu"/>">Cửa hàng</a> <a href="">${sp.tenSanPham }</a>
					</div>

					<div class="row">
						<div class="col-sm-6">
							<div class="product-images">
								<div class="product-main-img">
									<img src="<c:url value="/img/${sp.hinhAnh}"/>" alt="">
								</div>
							</div>
						</div>

						<div class="col-sm-6">
							<div class="product-inner">
								<h2 class="product-name">${sp.tenSanPham}</h2>
								<div class="product-inner-price">
									<ins>
										<fmt:formatNumber value="${sp.donGiaKM}" />
										đ
									</ins>
									<del>
										<fmt:formatNumber value="${sp.donGia}" />
										đ
									</del>
								</div>

								<form class="cart">
									<div class="quantity">
										<input type="number" size="4" class="input-text qty text"
											title="Qty" value="1" name="quantity" min="1" step="1">
									</div>
									<input type="button" value="Add to cart" onclick="javascript:themVaoGio('${sp.id}')" style="height: 37px; background-color: #5a88ca; color: white; border: none;">
								</form>


								<div role="tabpanel">
									<ul class="product-tab" role="tablist">
										<li role="presentation" class="active"><a href="#home"
											aria-controls="home" role="tab" data-toggle="tab">Mô tả</a></li>
										<li role="presentation"><a href="#profile"
											aria-controls="profile" role="tab" data-toggle="tab">Đánh
												giá</a></li>
									</ul>
									<div class="tab-content">
										<div role="tabpanel" class="tab-pane fade in active" id="home">
											<h2>Mô tả</h2>
											<p>${sp.moTa}</p>
										</div>
										<div role="tabpanel" class="tab-pane fade" id="profile">
											<h2>Reviews</h2>
											<div class="submit-review">
												<p>
													<label for="name">Name</label> <input name="name"
														type="text">
												</p>
												<p>
													<label for="email">Email</label> <input name="email"
														type="email">
												</p>
												<div class="rating-chooser">
													<p>Your rating</p>

													<div class="rating-wrap-post">
														<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
															class="fa fa-star"></i> <i class="fa fa-star"></i> <i
															class="fa fa-star"></i>
													</div>
												</div>
												<p>
													<label for="review">Your review</label>
													<textarea name="review" id="" cols="30" rows="10"></textarea>
												</p>
												<p>
													<input type="submit" value="Submit">
												</p>
											</div>
										</div>
									</div>
								</div>

							</div>
						</div>
					</div>


					<div class="related-products-wrapper">
						<h2 class="related-products-title">Sản phẩm liên quan</h2>
						<div class="related-products-carousel">
						<c:forEach items="${dsLQ}" var="sp">
							<div class="single-product">
								<div class="product-f-image">
									<img src="<c:url value="/img/${sp.hinhAnh }"/>" alt="">
									<div class="product-hover">
										<a href="" class="add-to-cart-link"><i
											class="fa fa-shopping-cart"></i> Add to cart</a> <a href=""
											class="view-details-link"><i class="fa fa-link"></i> See
											details</a>
									</div>
								</div>

								<h2>
									<a href="<c:url value="/san-pham/${sp.tenSanPham }/${sp.id}"/>">${sp.tenSanPham }</a>
								</h2>

								<div class="product-carousel-price">
									<ins>
										<fmt:formatNumber value="${sp.donGiaKM}" />
										đ
									</ins>
									<del>
										<fmt:formatNumber value="${sp.donGia}" />
										đ
									</del>
								</div>
							</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
