<!DOCTYPE html>
<%@page import="model.producttype"%>
<html>
    <head>
        <title>Manage Product</title>
        <!--CSS link-->
        <link rel="stylesheet" href="grid.css">
        <link rel="stylesheet" href="stylemanage.css">
        <!--Font link-->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">
        <!--Icon link-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
        
    </head>
    <body>
     <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
     <%
     	Object o = session.getAttribute("flag");
     	if(o==null)
     	{
     %>
        <div class="model-0 hide">
      <%
     	}else{
      %>
      <div class="model-0 ">
      <%
     	}
      %>
            <div class="model-inner-0">  
                <div class="model-header-0 d-flex">
                    <div class="header-form"><h3>UPDATE YOUR PRODUCT</h3></div>
                    <a href="closeupdateproduct"><i class="fa fa-window-close"></i></a>
                </div>
                <div class="model-body-0">
                    <form action="updateproductadmin" enctype="multipart/form-data" method="post">
                        <label for="name">Product name</label><br>
                        <input class="name" type="text" id="name" name="name" value="${name}"><br>
                        <label for="name-producer">Producer</label><br>
                        <input class="name" type="text" id="name-producer" name="nameproducer" value="${producer}"><br>
                        <label for="name-producer">Quantity</label><br>
                        <input class="name" type="text" id="name-producer" name="quantity" value="${quantity}"><br>
                         <label for="name-producer">Size</label><br>
                        <input class="name" type="text" id="name-producer" name="nameSize" value="${nameSize}"><br>
                        <label for="descr">Product description</label><br>
                        <textarea class="descr" id="descr" name="descr" rows="4" cols="70">${des}</textarea>
                        <div class="container-price-cate my-3 d-flex">
                            <div class="price">
                                <label for="price">Price</label><br>
                                <input class="float-left price-cate" type="text" id="price" name="price" value="${price}">
                            </div>
                            <c:if test="${producttype == 'A02'}">
                            <div class="cate">
                                <label for="cate">Category</label><br>
                                <select class="price-cate" name="cate" id="cate">
                                    <option value="A02">Hoodie</option>
                                    <option value="A01">Shirt</option>
                                    <option value="A03">Sweater</option>
                                    <option value="A04">Cardigan</option>
                                    <option value="A05">Jacket</option>
                                    <option value="Q01">Pant</option>
                                </select>
                            </div>
                            </c:if>
                            <c:if test="${producttype == 'A01'}">
                            <div class="cate">
                                <label for="cate">Category</label><br>
                                <select class="price-cate" name="cate" id="cate">
                                 	<option value="A01">Shirt</option>
                                    <option value="A02">Hoodie</option>
                                    <option value="A03">Sweater</option>
                                    <option value="A04">Cardigan</option>
                                    <option value="A05">Jacket</option>
                                    <option value="Q01">Pant</option>
                                </select>
                            </div>
                            </c:if>
                            <c:if test="${producttype == 'A03'}">
                            <div class="cate">
                                <label for="cate">Category</label><br>
                                <select class="price-cate" name="cate" id="cate">
                                	<option value="A03">Sweater</option>
                                 	<option value="A01">Shirt</option>
                                    <option value="A02">Hoodie</option>
                                    <option value="A04">Cardigan</option>
                                    <option value="A05">Jacket</option>
                                    <option value="Q01">Pant</option>
                                </select>
                            </div>
                            </c:if>
                            <c:if test="${producttype == 'A04'}">
                            <div class="cate">
                                <label for="cate">Category</label><br>
                                <select class="price-cate" name="cate" id="cate">
                                	<option value="A04">Cardigan</option>
                                	<option value="A03">Sweater</option>
                                 	<option value="A01">Shirt</option>
                                    <option value="A02">Hoodie</option>
                                    <option value="A05">Jacket</option>
                                    <option value="Q01">Pant</option>
                                </select>
                            </div>
                            </c:if>
                            <c:if test="${producttype == 'A05'}">
                            <div class="cate">
                                <label for="cate">Category</label><br>
                                <select class="price-cate" name="cate" id="cate">
                                	<option value="A05">Jacket</option>
                                	<option value="A04">Cardigan</option>
                                	<option value="A03">Sweater</option>
                                 	<option value="A01">Shirt</option>
                                    <option value="A02">Hoodie</option>
                                    <option value="Q01">Pant</option>
                                </select>
                            </div>
                            </c:if>
                            <c:if test="${producttype == 'Q01'}">
                            <div class="cate">
                                <label for="cate">Category</label><br>
                                <select class="price-cate" name="cate" id="cate">
                                	<option value="Q01">Pant</option>
                                	<option value="A05">Jacket</option>
                                	<option value="A04">Cardigan</option>
                                	<option value="A03">Sweater</option>
                                 	<option value="A01">Shirt</option>
                                    <option value="A02">Hoodie</option>
                                </select>
                            </div>
                            </c:if>
                        </div>
                        <label for="img">Select image</label><br>
                        <div class="btn-img">
                            <input type="file" id="img" name="img" accept="image/*" > 
                        </div>
                        <div class="id-number my-3">
                            <label for="id">ID Product</label><br>
                            <input type="text" name="id" id="id" value="${id}"> 
                        </div>
                        <input class="submit" type="submit" value="SUBMIT">
                    </form>
                </div>
            </div>
        </div>
        <div class="col-2 nav float-left">
            <h2 style="color:white;padding-bottom: 20px;">Panacea</h2>
            <div class="nav-item"><a href="adminhome.jsp"><span class="material-symbols-outlined">home</span>Home</a></div>
            <button class="dropdown-btn"><span class="material-symbols-outlined">category</span>Manage Products</button>
            <div class="dropdown-container">
                <a href="loadsanphamad">ALL PRODUCTS</a>
                <a href="#">SHIRTS</a>
                <a href="#">PANTS</a>
                <a href="#">ACCESSORY</a>
            </div>
            <div class="nav-item"><a href="loaduserad"><span class="material-symbols-outlined">manage_accounts</span>Manage Users</a></div>
            <div class="nav-item"><a href="loadorderad"><span class="material-symbols-outlined">list_alt</span>Manage Orders</a></div>
        </div>
        <div class="col-10" style="margin-left:16.66%">
            <h1><i class="fa fa-gear" style="font-size:24px"></i>Manage Product</h1>
            
            <div class="new-p my-3">
                <a href="getproductid"><i class="fa fa-plus-circle" style="margin-right: 10px;"></i>ADD NEW PRODUCT</a>   
            </div>
            
            <div class="my-4 sort-search d-flex">     
                <form class="col-4" action="searchproductad">
                    <div class="search d-flex">
                        <input type="text" placeholder="&#160;&#160;&#160;Search here" style = "width:100%" name="txt" value="${txtsearch}">     
                        <button type="submit" style="font-size:30px;margin-left:3px; margin-top: auto; margin-bottom:auto;"><span class="material-symbols-outlined">search</span></button>
                    </div>
                </form>
                <div class="sort" onclick="toggleDropdown()">
                    <i class="fa fa-sort" style="font-size:30px;"></i>
                    <div class="dropdown-button">
                        <form action="filterproduct" method="get">
                            <div class="filter" style="text-align: left;">
                                <input type="radio" id="price2" name="price" value="1">
                                <label for="price2">100.000d - 300.000d</label><br>  
                                <input type="radio" id="price3" name="price" value="2">
                                <label for="price3">200.000d - 500.000d</label><br>
                            </div>
                            <input type="hidden" value="${txtsearch}" name="txt">
                            <button class="filter-btn" type="submit" value="submit">FILTER</button>
                        </form>      
                    </div>
                </div>   
            </div>

            <div class="container-fluid all-p">
                <div class="container-fluid row-title d-flex my-3">
                    <div class="col-1 text-center title">ID</div>
                    <div class="col-1 text-center title">IMAGE</div>
                    <div class="col-3 text-center title">NAME OF PRODUCT</div>
                    <div class="col-2 text-center title">PRICE</div>
                    <div class="col-1 text-center title">SIZE</div>
                    <div class="col-2 text-center title">QUANTITY</div>
                    <div class="col-2 text-center title">UPDATE/SOLDOUT</div>
                </div>
                
                <c:forEach items="${list}" var = "o">
                <div class="conatiern-fluid row-product d-flex">
                    <div class="col-1 text-center product"><p>${o.id_product}</p></div>
                    <div class="col-1 product"><img src="${o.url}" alt=""></div>
                    <div class="col-3 text-center product"><p>${o.nameProduct}</p></div>
                    <div class="col-2 text-center product">${o.price}</div>
                    <div class="col-1 text-center product"><p>${o.nameSize}</p></div>
                    <div class="col-2 text-center product"><p>${o.quantity}</p></div>
                     <input type="hidden" value="${o.id_product}" name="id_p">
                    <div class="col-2 text-center product btn-de-up">
                         <!--<button  class="btn but-update">UPDATE</button> -->
                        <a href="updateproduct?id_p=${o.id_product}&nameSize=${o.nameSize}" class="btn but-update" >UPDATE</a>
                        <c:if test="${o.quantity == 0}">
                        <a href="deleteproduct?piddd=${o.id_product}"  class="btn but-delete " style="color:red;">SOLDOUT</a>
                        </c:if>
                        <c:if test="${o.quantity != 0}">
                        <a href="deleteproduct?piddd=${o.id_product}"  class="btn but-delete " ">SOLDOUT</a>
                        </c:if>
                    </div>
                   
                </div>
                </c:forEach>
            </div>
        </div>
        <!-- Su kien onclick cua div-sort -->
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
        <!--Open Close Model-->
        <script>
            var buttonGroups =document.querySelectorAll('.btn-de-up')
            var model0= document.querySelector('.model-0');
            var icon0 = document.querySelector('.model-header-0 i');
            var submit = document.querySelector('.submit')
            function toggleCLose2(){
                model0.classList.add('hide');
            }
            buttonGroups.forEach(group => {
                const deleteButton = group.querySelector('.but-update');
                 deleteButton.addEventListener('click', () => {
                    model0.classList.remove('hide');
                });
            });
            icon0.addEventListener('click',  toggleCLose2);
            submit.addEventListener('click', toggleCLose2);
        </script>
        <script>
            /* Loop through all dropdown buttons to toggle between hiding and showing its dropdown content - This allows the user to have multiple dropdowns without any conflict */
            var dropdown = document.getElementsByClassName("dropdown-btn");
            var i;
            
            for (i = 0; i < dropdown.length; i++) {
              dropdown[i].addEventListener("click", function() {
                this.classList.toggle("active");
                var dropdownContent = this.nextElementSibling;
                if (dropdownContent.style.display === "block") {
                  dropdownContent.style.display = "none";
                } else {
                  dropdownContent.style.display = "block";
                }
              });
            }

            function YesorNo(id){
            	var option = confirm('DO YOU WANT TO DELETE THIS PRODUCT ?');
            	if(option === true)
            	{
            		window.location.href = 'deleteproduct?pid='+id;	
            	}
                
            }
        </script>
    </body>
</html>
