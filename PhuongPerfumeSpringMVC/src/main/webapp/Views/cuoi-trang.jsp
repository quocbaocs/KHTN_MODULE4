<%-- 
    Document   : cuoi-trang
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <div class="footer-top-area">
        <div class="zigzag-bottom"></div>
        <div class="container">
            <div class="row">
                <div class="col-md-3 col-sm-6">
                    <div class="footer-about-us">
                        <h2>Phuong<span>Perfume</span></h2>
                        <p>Chuyên cung cấp các loại nước hoa ngoại nhập với chất lượng đảm bảo và giá cả phải chăng</p>
                        <div class="footer-social">
                            <a href="#" target="_blank"><i class="fa fa-facebook"></i></a>
                            <a href="#" target="_blank"><i class="fa fa-twitter"></i></a>
                            <a href="#" target="_blank"><i class="fa fa-youtube"></i></a>
                            <a href="#" target="_blank"><i class="fa fa-linkedin"></i></a>
                        </div>
                    </div>
                </div>
                
                <div class="col-md-3 col-sm-6">
                    <div class="footer-menu">
                        <h2 class="footer-wid-title">Loại</h2>
                        <ul>
                        <c:forEach var="l" items="${dsLoai}">
                            <li><a href="#">${l.tenloai}</a></li>
                           
                            </c:forEach>
                        </ul>                        
                    </div>
                </div>
                	
                <div class="col-md-3 col-sm-6">
                    <div class="footer-menu">
                        <h2 class="footer-wid-title">Đăng nhập</h2>
                          <div class="newsletter-form">
                            <form action="#">
                                <input type="email" placeholder="Nhập email" id="email">
                                 <input type="email" placeholder="Nhập Password" id="password">
                                <input type="button" value="Đăng nhập"  onclick="checkLogin()">
                            </form>
                        </div>                    
                    </div>
                </div>
                
                <div class="col-md-3 col-sm-6">
                    <div class="footer-newsletter">
                        <h2 class="footer-wid-title">Nhận tin</h2>
                        <p>Vui lòng cung cấp email để nhận tin mới cập nhật thường xuyên</p>
                        <div class="newsletter-form">
                            <form action="#">
                                <input type="email" placeholder="Type your email">
                                <input type="submit" value="Subscribe">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div> <!-- End footer top area -->
    
    <div class="footer-bottom-area">
        <div class="container">
            <div class="row">
                <div class="col-md-8">
                    <div class="copyright">
                        <p>&copy; 2015 uCommerce. All Rights Reserved. <a href="http://www.freshdesignweb.com" target="_blank">freshDesignweb.com</a></p>
                    </div>
                </div>
                
                <div class="col-md-4">
                    <div class="footer-card-icon">
                        <i class="fa fa-cc-discover"></i>
                        <i class="fa fa-cc-mastercard"></i>
                        <i class="fa fa-cc-paypal"></i>
                        <i class="fa fa-cc-visa"></i>
                    </div>
                </div>
            </div>
        </div>
    </div> <!-- End footer bottom area -->
   
    <!-- Latest jQuery form server -->
    <script src="https://code.jquery.com/jquery.min.js"></script>
    
    <!-- Bootstrap JS form CDN -->
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    
    <!-- jQuery sticky menu -->
    <script src="<c:url value='/js/owl.carousel.min.js'/>"></script>
    <script src="<c:url value='/js/jquery.sticky.js'/>"></script>
    
    <!-- jQuery easing -->
    <script src="<c:url value='/js/jquery.easing.1.3.min.js'/>"></script>
    
    <!-- Main Script -->
    <script src="<c:url value='/js/main.js'/>"></script>
    
    <!-- Slider -->
    <script type="text/javascript" src="<c:url value='/js/bxslider.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/script.slider.js'/>"></script>
	<script type="text/javascript">
			function checkLogin() {
				var email = document.getElementById("email").value;
				var password = document.getElementById("password").value;
			
				var xhr = new XMLHttpRequest();
				xhr.onreadystatechange = function() {
					if (this.readyState == 4 && this.status == 200) {
						var text = this.responseText;
					
						document.getElementById("ten").innerHTML=text;
						
						
					}
				}
				xhr.open("get", "login?email=" + email + "&password="+password);
				xhr.send();
		
		}
	
		function themVaoGio(id) {
			const numberFormat = new Intl.NumberFormat('vi-VN', {
				  style: 'currency',
				  currency: 'VND',
				});
			var xhr = new XMLHttpRequest();
			xhr.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					var text = this.responseText;
				
					var tongtien = text.substring(0, text.indexOf(";"));
					var slh = text.substring(text.indexOf(";")+1);
					
					
					var obTongTien = document.getElementById("tongTien");
					obTongTien.innerText =  numberFormat.format(tongtien);;
					
					var soMatHang = document.getElementById("smh");
					
					soMatHang.innerHTML=slh;
				}
			}
			
			xhr.open("get", "${pageContext.request.contextPath}/them-vao-gio?idsp=" + id + "&slm=1");
			xhr.send();

	}
		function xoaSanPhamGio(id) {
			const numberFormat = new Intl.NumberFormat('vi-VN', {
				  style: 'currency',
				  currency: 'VND',
				});
			document.getElementById(id).style.display = "none";
			var xhr = new XMLHttpRequest();
			xhr.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					var text = this.responseText;
					const tongtien = text.substring(0, text.indexOf(";"));
					var slh = text.substring(text.indexOf(";")+1);
					
					
					var obTongTien = document.getElementById("tongTien");
					obTongTien.innerHTML = numberFormat.format(tongtien);
					
					const collection = document.getElementsByClassName("thanhTien");
					for (let i = 0; i < collection.length; i++) {
						
					  collection[i].innerText = numberFormat.format(tongtien);
					}
					
					
					var soMatHang = document.getElementById("smh");
					
					soMatHang.innerHTML=slh;
				}
			}
			xhr.open("get", "xoa-item-gio?idsp=" + id);
			xhr.send();
	}
		
		
		function capNhatQuantity(id) {
			const numberFormat = new Intl.NumberFormat('vi-VN', {
				  style: 'currency',
				  currency: 'VND',
				});
			var newQuantity = document.getElementsByClassName("quantity"+id)[0].value;
			
			var xhr = new XMLHttpRequest();
			xhr.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					var text = this.responseText;
				
					var tongtien = text.substring(0, text.indexOf(";"));
					var slh = text.substring(text.indexOf(";")+1);
					
					
					var obTongTien = document.getElementById("tongTien");
					obTongTien.innerText =  numberFormat.format(tongtien);
					
					const collection = document.getElementsByClassName("thanhTien");
					for (let i = 0; i < collection.length; i++) {
						
					  collection[i].innerText = numberFormat.format(tongtien);
					}
					
					var soMatHang = document.getElementById("smh");
					
					soMatHang.innerHTML=slh;
				}
			}
			xhr.open("get", "cap-nhat-gio-hang?idsp=" + id + "&slm="+newQuantity);
			xhr.send();

	}	
</script>


  </body>
</html>