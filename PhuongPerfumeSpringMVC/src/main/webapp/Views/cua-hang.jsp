<%-- 
    Document   : cua-hang
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
            <c:forEach items="${listSanPhamTrang}" var="sp">
                <div class="col-md-3 col-sm-6" style="height: 309px;">
                    <div class="single-shop-product">
                        <div class="product-upper">
                            <img src="img/${sp.hinhanh }" alt="" width="150" height="150">
                        </div>
                        <h2><a href="san-pham/${sp.tensanpham }/${sp.id}">${sp.tensanpham }</a></h2>
                        <div class="product-carousel-price">
                            <ins><fmt:formatNumber value="${sp.dongiaKm}"/> đ</ins> <del><fmt:formatNumber value="${sp.dongia}"/> đ</del>
                        </div>  
                        
                        <div class="product-option-shop">
                            <a class="add_to_cart_button" data-quantity="1" data-product_sku="" data-product_id="70" rel="nofollow" href="javascript:themVaoGio('${sp.id}')">Add to cart</a>
                        </div>                       
                    </div>
                </div>
                </c:forEach>
            </div>
            
            <div class="row">
                <div class="col-md-12">
                    <div class="product-pagination text-center">
                        <nav>
                          <ul class="pagination">
                            <li>
                              <a href="?trang=${param.trang-1<1?1:param.trang-1}" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                              </a>
                            </li>
                            <c:forEach begin="1" end="${tongSoTrang}" var="i">
	                            <li><a href="?trang=${i}" style="background-color:${param.trang==i?'lightgreen':'white'}; ">${i}</a></li>
	                            
                            </c:forEach>
                            <li>
                              <a href="?trang=${param.trang+1>tongSoTrang?tongSoTrang:param.trang+1}" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                              </a>
                            </li>
                          </ul>
                        </nav>                        
                    </div>
                </div>
            </div>
        </div>
    </div>
