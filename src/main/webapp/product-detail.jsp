<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>All Products - Panacea</title>
    <link rel="stylesheet" href="style.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap"
      rel="stylesheet"
    />
  </head>
  <body>
   <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    <c:set var ="size" value="${sessionScope.sl}"/>
    <!--NAV BAR-->
      <div class="container">
        <div class="navbar">
          <div class="logo">
            <img src="images/logoPA.png" width="110px" />
          </div>
          <nav>
            <ul id="menuItem">
              <li><a href="">Home</a></li>
              <li><a href="">Products</a></li>
              <li><a href="">About</a></li>
              <li><a href="">Contact</a></li>
              <li><a href="">Account</a></li>
            </ul>
          </nav>
           <a href="cart.jsp"><img src="images/cart.png" width="30px" height="30px"> My bag (${size})</a>
          <img src="images/menu.png" class="menu-icon" onclick="menutoggle()">
        </div>
      </div>
    
     <!--Single product details-->
     <div class="small-container single-product">
      <div class="row">
        <div class="col-2">
          <img src="${product.url }" width="100%" id="productImg">
		  <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
          <div class="small-img-row">
          <c:forEach items="${list}" var = "o">
            <div class="small-img-col">
              <img src="${o.url }" width="100%" class="small-img">
            </div>
            </c:forEach>
          </div>
        </div>
        <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
        <div class="col-2">
          <p>Home / T-Shirt</p>
          <form action="buy" method="get">
          <h1>${product.nameProduct}</h1>
          <h4>${product.price}</h4>
          <select name="size">
            <option>Select Size</option>
            <option>XXL</option>
            <option>XL</option>
            <option>L</option>
            <option>M</option>
            <option>S</option>
          </select>
          <input type="hidden" name="pid" value="${product.id_product}">
          <input type="number" value="1" name="num">
          <input type="submit" class="btn" value="Add to cart">
          </form>
          <h3>Product Details</h3>
          <p>${product.description}</p>
        </div>
      </div>
     </div> 
     <!--title-->
     <div class="small_container">
      <div class="row row-2">
        <h2>Related Products</h2>
        <p>View More</p>
      </div>
     </div>

     <!--products-->

    <div class="small_container">
      <div class="row">
        <div class="col-4">
          <img src="images/buy1.jpg">
          <h4>Tshirt</h4>
          <p>250.000VND</p>
        </div>
        <div class="col-4">
          <img src="images/buy2.jpg">
          <h4>Tshirt</h4>
          <p>350.000VND</p>
        </div>
        <div class="col-4">
          <img src="images/buy3.jpg">
          <h4>Tshirt</h4>
          <p>300.000VND</p>
        </div>
        <div class="col-4" >
          <img src="images/buy4.jpg" height="247.500px">
          <h4>Tshirt</h4>
          <p>250.000VND</p>
        </div>
      </div>
    </div>
    <!--Footer-->
    <div class="footer">
      <div class="container">
        <div class="row">
          <div class="footer-col-1">
            <h3>Download Our App</h3>
            <p>Download App for android and ios mobile phone.</p>
            <div class="app-logo">
              <img src="images/play-store.png">
              <img src="images/app-store.png">
            </div>
          </div>
          <div class="footer-col-2">
            <img src="images/logoPA.png" alt="">
            <p>Create good products is our passion</p>
          </div>
          <div class="footer-col-3">
            <h3>Useful Links</h3>
            <ul>
              <li>Our blogs</li>
              <li>Join with me</li>
            </ul>
          </div>
          <div class="footer-col-4">
            <h3>Follow us</h3>
            <ul>
              <li>Facebook</li>
              <li>Instagram</li>
              <li>Twitter</li>
              <li>Youtube</li>
            </ul>
          </div>
        </div>
        <hr>
        <p class="copyright">Copyright 2023</p>
      </div>
    </div>

    <!--JS for toggle menu-->
    <script>
      var menuItem = document.getElementById("menuItem");
      menuItem.style.maxHeight="0px";
      function menutoggle()
      {
        if(menuItem.style.maxHeight=="0px")
        {
          menuItem.style.maxHeight="200px";
        }
        else
        {
          menuItem.style.maxHeight="0px";
        }
      }
    </script>

    <!--JS for product gallery-->
    <script>
      var productImg = document.getElementById("productImg");
      var smallImg = document.getElementsByClassName("small-img");

      smallImg[0].onclick = function(){
        productImg.src=smallImg[0].src;
      }
      smallImg[1].onclick = function(){
        productImg.src=smallImg[1].src;
      }
      smallImg[2].onclick = function(){
        productImg.src=smallImg[2].src;
      }
      smallImg[3].onclick = function(){
        productImg.src=smallImg[3].src;
      }
    </script>
  </body>
</html>
