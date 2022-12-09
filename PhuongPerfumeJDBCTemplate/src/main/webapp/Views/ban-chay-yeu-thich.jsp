<%-- 
    Document   : ban-chay-yeu-thich
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <div class="product-widget-area">
        <div class="zigzag-bottom"></div>
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <div class="single-product-widget">
                        <h2 class="product-wid-title">Bán chạy nhất</h2>
                        <a href="" class="wid-view-more">Danh Sách</a>
                        <c:forEach var="sp" items="${listBanChay}">
                        <div class="single-wid-product">
                            <a href="single-product.html"><img src="img/${sp.hinhAnh }" alt="" class="product-thumb"></a>
                            <h2><a href="<c:url value="/san-pham/${sp.tenSanPham }/${sp.id}"/>">${sp.tenSanPham }</a></h2>
                            <div class="product-wid-rating">
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                            </div>
                            <div class="product-wid-price">
                                <ins><fmt:formatNumber value="${sp.donGiaKM}"/> đ</ins> <del><fmt:formatNumber value="${sp.donGia}"/> đ</del>
                            </div>                            
                        </div>
                        </c:forEach>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="single-product-widget">
                        <h2 class="product-wid-title">Giảm Nhiều Nhất</h2>
                        <a href="#" class="wid-view-more">View All</a>
                        <c:forEach var="sp" items="${listGiamGia}">
                        <div class="single-wid-product">
                            <a href="single-product.html"><img src="img/${sp.hinhAnh}" alt="" class="product-thumb"></a>
                            <h2><a href="<c:url value="/san-pham/${sp.tenSanPham }/${sp.id}"/>">${sp.tenSanPham}</a></h2>
                            <div class="product-wid-rating">
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                            </div>
                            <div class="product-wid-price">
                                <ins><fmt:formatNumber value="${sp.donGiaKM}"/> đ</ins> <del><fmt:formatNumber value="${sp.donGia}"/> đ</del>
                            </div>                            
                        </div>
                        </c:forEach>
                        
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="single-product-widget">
                        <h2 class="product-wid-title">Yêu thích nhất</h2>
                        <a href="" class="wid-view-more">Danh Sách</a>
                        <c:forEach var="sp" items="${listBanChay}">
                        <div class="single-wid-product">
                            <a href="single-product.html"><img src="img/${sp.hinhAnh }" alt="" class="product-thumb"></a>
                            <h2><a href="<c:url value="/san-pham/${sp.tenSanPham }/${sp.id}"/>">${sp.tenSanPham }</a></h2>
                            <div class="product-wid-rating">
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                            </div>
                            <div class="product-wid-price">
                                <ins><fmt:formatNumber value="${sp.donGiaKM}"/> đ</ins> <del><fmt:formatNumber value="${sp.donGia}"/> đ</del>
                            </div>                            
                        </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div> <!-- End product widget area -->
