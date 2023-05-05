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
   <c:set var ="totalprice" value="${sessionScope.total}"/>
    <!--NAV BAR-->
      <div class="container">
        <div class="navbar">
          <div class="logo">
            <a href="index.html"><img src="images/logoPA.png" width="110px" /></a>
          </div>
          <nav>
            <ul id="menuItem">
              <li><a href="index.html">Home</a></li>
              <li><a href="loadsanpham">Products</a></li>
              <li><a href="">About</a></li>
              <li><a href="">Contact</a></li>
              <li><a href="account.html">Account</a></li>
            </ul>
          </nav>
          <a href="index.html"><img src="images/cart.png" width="30px" height="30px"></a>
          <img src="images/menu.png" class="menu-icon" onclick="menutoggle()">
        </div>
      </div>

      <!--Cart items details-->
    <div class="small_container cart-page">
      <table>
        <tr>
          <th>Product</th>
          <th>Quantity</th>
          <th>Size</th>
          <th>Subtotal</th>
        </tr>
        
        <c:set var="o" value="${sessionScope.cart}"/>
        <c:set var="t" value="0"/>
        <c:forEach items="${o.items}" var="i">
        	<tr>
          <td>
            <div class="cart-info">
              <img src="${i.product.url }">
              <div><p>${i.product.nameProduct }</p>
              <br>
              <small>${i.product.price} VND</small>
              <br>
              <form action="remove" method="post">
              <input type="hidden" value="${i.product.id_product }" name="p_id">
              <input type="submit" value="remove" class="btn">
              </form>
            </div>
            </div>
          </td>
          <td><input type="number" value="${i.quantity}"></td>
          <td>${i.s.nameSize}</td>
          <td>${i.quantity*i.product.price} VND</td>
        </tr>
        </c:forEach>
        
      </table>

      <div class="total-price">
        <table>
          <tr> 
            <td>Subtotal</td>
            <td>${totalprice} VND</td>
          </tr>
          <tr> 
            <td>Shipping</td>
            <td>20.000 VND</td>
          </tr>
          <tr> 
            <td>Total</td>
            <td>${totalprice+20000} VND</td>
          </tr>
          <tr>
            <td style="text-align: left;">Payment method</td>
          </tr>
          <tr style="align-items: left">
					<td style="text-align: center;align-content: left">
								<form action="checkout">
										<input type="radio" id="html" name="payment" value="Cash">Cash
										<input type="radio" id="css" name="payment" value="Visa">Visa
							<button class="btn" type="submit">Check out</button>
							</form>
					</td>
				</tr>
        </table>
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
