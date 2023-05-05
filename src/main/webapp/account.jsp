<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
  <%
  String accountName = request.getAttribute("accountName")+"";
  accountName=(accountName.equals("null"))?"":accountName;
  
  String email = request.getAttribute("email")+"";
  email=(email.equals("null"))?"":email;
  
  String passWord = request.getAttribute("passWord")+"";
  passWord=(passWord.equals("null"))?"":passWord;
  
  String error = request.getAttribute("error")+"";
  error=(error.equals("null"))?"":error;
  %>
  <body>
    <!--NAV BAR-->
      <div class="container">
        <div class="navbar">
          <div class="logo">
            <a href="index.html"><img src="images/logoPA.png" width="110px" /></a>
          </div>
          <nav>
            <ul id="menuItem">
              <li><a href="index.html">Home</a></li>
              <li><a href="products.html">Products</a></li>
              <li><a href="">About</a></li>
              <li><a href="">Contact</a></li>
              <li><a href="account.html">Account</a></li>
            </ul>
          </nav>
          <a href="cart.html"><img src="images/cart.png" width="30px" height="30px"></a>
          <img src="images/menu.png" class="menu-icon" onclick="menutoggle()">
        </div>
      </div>

      <!--Account Page-->
      <div class="account-page">
        <div class="container">
          <div class="row">
            <div class="col-2">
            <img src="images/phinease_and_ferb-removebg-preview.png" width="70%">
            </div>
            <div class="col-2">
              <div class="form-container">
                <div class="form-btn">
                  <span onclick="login()">Login</span>
                  <span onclick="register()">Register</span>
                  <hr id="indicator">
                </div>
				<div style="color: red" id="baoLoi">
				<%=error %>
				</div>
                <form id="loginForm" action="login" method="post">
                  <input type="text" placeholder="Username" id="accountName1" name="accountName1">
                  <input type="password" placeholder="Password" id="passWord1" name="passWord1">
                  <button type="submit" class="btn">Login</button>
                  <a href="">Forgot password</a>
                </form>
                
                <form id="registerForm" action="do-register" method="get">
                  <input type="text" placeholder="Username" id="accountName" name="accountName" value="<%=accountName%>">
                  <input type="email" placeholder="Email" id="email" name="email" value="<%=email%>">
                  <input type="password" placeholder="Password" id="passWord" name="passWord" value="<%=passWord%>">
                  <button type="submit" class="btn">Register</button>
                </form>
              </div>
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

  <!--JS for toggle form-->
  <script>
    var loginForm = document.getElementById("loginForm");
    var regForm = document.getElementById("registerForm");
    var indicator = document.getElementById("indicator");

    function register(){
      regForm.style.transform = "translateX(0px)";
      loginForm.style.transform = "translateX(0px)";
      indicator.style.transform = "translateX(100px)";
    }

    function login(){
      regForm.style.transform = "translateX(300px)";
      loginForm.style.transform = "translateX(300px)";
      indicator.style.transform = "translateX(0px)";
    }
  </script>
    
  </body>
</html>
