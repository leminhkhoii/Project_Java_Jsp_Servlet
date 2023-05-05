<!DOCTYPE html>
<%@page import="model.customer"%>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Panacea</title>
    <link rel="stylesheet" href="style.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap"
      rel="stylesheet" 
    />
  </head>
  <body>
    <!--NAV BAR-->
    <div class="header">
      <div class="container">
        <div class="navbar">
          <div class="logo">
            <a href="index.jsp"><img src="images/logoPA.png" width="110px" /></a>
          </div>
          <nav>
            <ul id="menuItem">
              <li><a href="index.jsp">Home</a></li>
              <li><a href="loadsanpham">Products</a></li>
              <li><a href="">About</a></li>
              <li><a href="">Contact</a></li>
	<%
        	Object obj = session.getAttribute("Customer");
        	customer c2 = null;
        	if(obj!=null)
        	{
        		c2=(customer)obj;
        	}
        	if(c2==null){
        %>
        <li><a href="account.jsp">Account</a></li>
        <%} else { %>
          <li><a href="accountdetail"><%=c2.getAccountName() %></a></li>
        <%} %>
            </ul>
          </nav>
          <a href="cart.html"><img src="images/cart.png" width="30px" height="30px"></a>
          <img src="images/menu.png" class="menu-icon" onclick="menutoggle()">
        </div>
      </div>
      <!--END NAV BAR-->
      <div class="row">
        <div class="col-2" style="text-align: center;">
          <h1>HEY DUDE</h1>
          <p>Give us a style <br />We will give you 1 outfit</p>
          <a href="" class="btn">Explore Now</a>
        </div>

        <div class="col-2">
          <img src="images/1.png" alt="" />
        </div>
      </div>
    </div>

    <!-- featured categories-->
    <div class="categories">
      <div class="small_container">
        <div class="row">
          <div class="col-3">
            <img src="images/buy1.jpg" alt="">
          </div>
          <div class="col-3">
            <img src="images/buy2.jpg" alt="">
          </div>
          <div class="col-3">
            <img src="images/buy3.jpg" alt="">
          </div>
      </div>
    </div>


    <!-- featured products -->
    <div class="small_container">
      <h2 class="title">Featured Products</h2>
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
      <h2 class="title">Latest Products</h2>
      <div class="row">
        <div class="col-4">
          <img src="images/buy5.jpg">
          <h4>Tshirt</h4>
          <p>250.000VND</p>
        </div>
        <div class="col-4">
          <img src="images/buy3.jpg">
          <h4>Tshirt</h4>
          <p>350.000VND</p>
        </div>
        <div class="col-4">
          <img src="images/buy2.jpg">
          <h4>Tshirt</h4>
          <p>300.000VND</p>
        </div>
        <div class="col-4" >
          <img src="images/buy1.jpg" height="247.500px">
          <h4>Tshirt</h4>
          <p>250.000VND</p>
        </div>
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
    </div>
    <!--Offer-->
    <div class="offer">
      <div class="small_container">
        <div class="row">
        <div class="col-2">
          <img src="images/buy3-removebg-preview.png" class="offer-img">
        </div>
        <div class="col-2" style="text-align: center;">
            <p>Exclusively Available on Panacea</p>
            <h1>Season 4</h1>
            <small>Sweater with polieste make you feel like cotton</small>
            <br>
            <a href="" class="btn">Buy Now &#8594;</a>
        </div>
      </div>
      </div>
    </div>

    <!--Brands-->
    <div class="brands">
      <div class="small_container">
        <div class="row">
          <div class="col-5">
            <img src="images/logo-godrej.png" alt="">
          </div>
          <div class="col-5">
            <img src="images/logo-oppo.png" alt="">
          </div>
          <div class="col-5">
            <img src="images/logo-coca-cola.png" alt="">
          </div>
          <div class="col-5">
            <img src="images/logo-paypal.png" alt="">
          </div>
          <div class="col-5">
            <img src="images/logo-philips.png" alt="">
          </div>
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
  </body>
</html>
