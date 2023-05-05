<!DOCTYPE html>
<%@page import="model.customer"%>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>All Products - Panacea</title>
    <link rel="stylesheet" href="style.css" />
    <link rel="stylesheet" href="style1.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    
    <link
      href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap"
      rel="stylesheet"
    />
  </head>
  <body>
    <!--NAV BAR-->
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    <c:set var ="size" value="${sessionScope.sl}"/>
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
          <li><a href="account-detail.jsp"><%=c2.getAccountName() %></a></li>
        <%} %>
            </ul>
          </nav>
          <a href="cart.jsp"><img src="images/cart.png" width="30px" height="30px"> My bag (${size})</a>
          <img src="images/menu.png" class="menu-icon" onclick="menutoggle()">
        </div>
      </div>

    <div class="small_container">
      <div class="row row-2">
        <h2>All Products</h2>
		<div class="sort" onclick="toggleDropdown()">
                    <i class="fa fa-sort" style="font-size:30px;"></i>
                    <div class="dropdown-button">
                        <a href="filterproductbyshirt"><button class="button button1">Filter By Shirt</button></a>
						<a href="filterproductbyhoodie"><button class="button button1">Filter By Hoodie</button></a>
						<a href="filterproductbysweater"><button class="button button1">Filter By Sweater</button></a>
						<a href="filterproductbycardigan"><button class="button button1">Filter By Cardigan</button></a>
						<a href="filterproductbyjacket"><button class="button button1">Filter By Jacket</button></a>
						<a href="filterproductbypant"><button class="button button1">Filter By Pant</button></a>
						
                    </div>
                </div>        
			<form action="search1?index=1" method="post">
				<select name="sort" value="${sort}">
					<option value="1">Default Sorting</option>
					<option value="2">200.000-300.000</option>
				</select>
				<table>
					<tr>
						<td style="margin-left: -20px;"><input type="text" name="txt" value="${txtsearch }"></td>
						<td><button type="submit">Find</button></td>
					</tr>
				</table>
			</form>
		</div>
      
      
      <div class="row">
         <c:forEach items="${list}" var = "o">
         <div class="col-4">
          <a href="detail?pid=${o.id_product }"><img src="${o.url}"></a>
          <h4>${o.nameProduct }</h4>
          <p>${o.price} VND</p>
        </div>
      </c:forEach>
      </div>

      

      <div class="page-btn">
        <c:forEach begin="1" end="${end}" var="i">
        	<a href="search1?index=${i}&txt=${txtsearch}&sort=${sort}" class="btn">${i}</a>
        </c:forEach>
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
    <script>
            function toggleDropdown(){
                var dropdown = document.querySelector('.dropdown-button');
                if (dropdown.classList.contains('show')) {
                    dropdown.classList.remove('show');
                } else {
                    dropdown.classList.add('show');
                }
            }
        </script>
  </body>
</html>
