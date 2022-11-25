<%-- 
    Document   : san-pham-moi
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <div class="maincontent-area">
        <div class="zigzag-bottom"></div>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="latest-product">
                        <h2 class="section-title">Sản phẩm mới</h2>
                        <div class="product-carousel">
                        
                        <c:forEach items="${listSanPhamMoi}" var="sp">
                            <div class="single-product">
                                <div class="product-f-image">
                                    <img src="img/${sp.hinhanh }" alt="">
                                    <div class="product-hover">
                                        <a href="javascript:themVaoGio('${sp.id}')" class="add-to-cart-link"><i class="fa fa-shopping-cart"></i> Thêm vào giỏ hàng</a>
                                        <a href="single-product.html" class="view-details-link"><i class="fa fa-link"></i> Xem chi tiết</a>
                                    </div>
                                </div>
                                
                                <h2><a href="san-pham/${sp.tensanpham }/${sp.id}">${sp.tensanpham }</a></h2>
                                
                                <div class="product-carousel-price">
                                    <ins><fmt:formatNumber value="${sp.dongiaKm}"/> đ</ins> <del><fmt:formatNumber value="${sp.dongia}"/> đ</del>
                                </div> 
                            </div>
                            </c:forEach>
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div> <!-- End main content area -->
    