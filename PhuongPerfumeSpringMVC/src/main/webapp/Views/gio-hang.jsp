<%-- 
    Document   : gio-hang
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>




<div class="product-big-title-area">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="product-bit-title text-center">
					<h2>Shopping Cart</h2>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- End Page title area -->


<div class="single-product-area">
	<div class="zigzag-bottom"></div>
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<div class="single-sidebar">
					<h2 class="sidebar-title">Tìm kiếm</h2>
					<form action="#">
						<input type="text" placeholder="Thông tin tìm kiếm..." name="keyword"> <input
							type="submit" value="Tìm">
					</form>
				</div>

				<div class="single-sidebar">
					<h2 class="sidebar-title">Sản phẩm</h2>
					<c:forEach items="${dsTim}" var="sp">
					<div class="thubmnail-recent">
						<img src="<c:url value="img/${sp.hinhanh }"/>" class="recent-thumb" alt="">
						<h2>
							<a href="<c:url value="/san-pham/${sp.tensanpham}"/>">${sp.tensanpham }</a>
						</h2>
						<div class="product-sidebar-price">
						<ins><fmt:formatNumber value="${sp.dongiaKm}"/> đ</ins> <del><fmt:formatNumber value="${sp.dongia}"/> đ</del>
						</div>
					</div>
					</c:forEach>
					
				</div>
			</div>

			<div class="col-md-8">
				<div class="product-content-right">
					<div class="woocommerce">
						<form method="post" action="#">
							<table cellspacing="0" class="shop_table cart">
								<thead>
									<tr>
										<th class="product-remove">Xóa</th>
										<th>Cập nhật</th>
										<th class="product-thumbnail">Hình</th>
										<th class="product-name">Sản phẩm</th>
										<th class="product-price">Đơn giá</th>
										<th class="product-quantity">Số lượng</th>
										<th class="product-subtotal">Thành tiền</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${cart.gioHang}" var="item">
										<tr class="cart_item" id="${item.key.id}">

										<td class="product-remove"><input type="button" class="minus" value="X" style="background-color: #5a88ca; border: none" onclick="javascript:xoaSanPhamGio('${item.key.id}')"></td>
												
                                            </td>
												<td><input type="button" class="minus" value="C" style="background-color: #5a88ca; border: none" onclick="javascript:capNhatQuantity('${item.key.id}')"></td>

											<td class="product-thumbnail"><a
												href="single-product.html"><img width="145" height="145"
													alt="poster_1_up" class="shop_thumbnail"
													src="img/${item.key.hinhanh }"></a></td>

											<td class="product-name"><a href="single-product.html">${item.key.tensanpham }</a>
											</td>

											<td class="product-price"><span class="amount"><fmt:formatNumber
														value="${item.key.dongiaKm }" />đ</span></td>
											<td class="product-quantity">
												<div class="quantity buttons_added">
													 <input
														type="number" size="4" class="quantity${item.key.id}"
														title="Qty"  value="${item.value}" min="1" step="1">
													
												</div>
											</td>

											<td class="product-subtotal"><span class="amount"><fmt:formatNumber
														value="${item.value*item.key.dongiaKm }" />đ</span></td>
										</tr>
									</c:forEach>
									<tr>
										<td class="actions" colspan="7">
											<div class="coupon">
												<label for="coupon_code">Phiếu thưởng:</label> <input
													type="text" placeholder="Mã phiếu" value=""
													id="coupon_code" class="input-text" name="coupon_code">
												<input type="submit" value="Áp dụng" name="apply_coupon"
													class="button">
											</div> <input type="submit"
											value="Thanh toán" name="proceed"
											class="checkout-button button alt wc-forward">
										</td>
									</tr>
								</tbody>
							</table>
						</form>

						<div class="cart-collaterals">

							<div class="cart_totals ">
								<h2>Tổng giỏ hàng</h2>

								<table cellspacing="0">
									<tbody>
										<tr class="cart-subtotal">
											<th>Cộng thành tiền</th>
											<td><span class="amount thanhTien"><fmt:formatNumber
														value="${sessionScope.cart.getTongTien() }" />đ</span></td>
										</tr>

										<tr class="shipping">
											<th>Phí giao hàng</th>
											<td>Miễn phí</td>
										</tr>

										<tr class="order-total">
											<th>Tổng cộng</th>
											<td><strong><span class="amount thanhTien"><fmt:formatNumber
														value="${sessionScope.cart.getTongTien() }" />đ</span></strong></td>
										</tr>
										
									</tbody>
								
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>	