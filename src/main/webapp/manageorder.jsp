<!DOCTYPE html>
<html>
    <head>
        <title>Manage Product</title>
        <!--CSS link-->
        <link rel="stylesheet" href="grid.css">
        <link rel="stylesheet" href="styleorder.css">
        <!--Font link-->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">
        <!--Icon link-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
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
                    <div class="header-form"><h3>UPDATE YOUR ORDER</h3></div>
                    <a href="closeupdateorder"><i class="fa fa-window-close"></i></a>
                </div>
                <div class="model-body-0">
                    <form action="updateorderadmin" method="get">
                        <div class="container-price-cate my-3 d-flex">
                            <div class="price">
                                <label for="cus-number">Order number</label><br>
                                <input class="float-left price-cate" type="text" id="cus-number" name="id_order" value="${id_order}">
                            </div>
                            <div class="cate">
                                <label for="pro-number">Customer Number</label><br>
                                <input class="float-left price-cate" type="text" id="pro-number" name="id_customer" value="${id_customer}">
                            </div>
                        </div>
                        <div class="container-price-cate my-3 d-flex">
                            <div class="price">
                                <label for="cus-number">Order Date</label><br>
                                <input class="float-left price-cate" type="text" id="cus-number" name="orderdate" value="${order_date}">
                            </div>
                            <div class="cate">
                                <label for="pro-number">Delivery Date</label><br>
                                <input class="float-left price-cate" type="text" id="pro-number" name="deliverydate" value="${deliver_date}">
                            </div>
                        </div>
                        <div class="container-price-cate my-3 d-flex">
                            <div class="price">
                                <label for="price">Total Price</label><br>
                                <input class="float-left price-cate" type="text" id="price" name="price" value="${total}">
                            </div>
                            <div class="cate">
                                <label for="price">Status</label><br>
                                <input class="float-left price-cate" type="text" id="status" name="status" value="${status}">
                            </div>
                        </div>
                        <div class="container-price-cate my-3 d-flex">
                            <div class="price">
                                <label for="price">Method Payment (Cash/Visa)</label><br>
                                <input class="float-left price-cate" type="text" id="price" name="method" value="${method}">
                            </div>
                        </div>
                        <input class="submit" type="submit" value="SUBMIT">
                    </form>
                </div>
            </div>
        </div>
        
        <div class="model hide">
            <div class="model-inner">
                <div class="model-header d-flex">
                    <p>Do you want to delete this order ?</p>
                    <i class="fa fa-window-close"></i>
                </div>
                <div class="model-body">
                    <button class="btn-no">No</button>
                    <button class="btn-yes">Yes</button>
                </div>
            </div>
        </div>
        <div class="col-2 nav float-left">
            <h2 style="color:white;padding-bottom: 20px;">Panacea</h2>
            <div class="nav-item"><a href="admin.html"><span class="material-symbols-outlined">home</span>Home</a></div>
            <div class="nav-item"><a href="loadsanphamad"><span class="material-symbols-outlined">category</span>Manage Products</a></div>
            <div class="nav-item"><a href="loaduserad"><span class="material-symbols-outlined">manage_accounts</span>Manage Users</a></div>
            <div class="nav-item"><a href="loadorderad"><span class="material-symbols-outlined">list_alt</span>Manage Orders</a></div>
        </div>
        <div class="col-10" style="margin-left:16.66%">
            <h1><i class="fa fa-gear" style="font-size:24px"></i>Manage Order</h1>
            <div class="my-4 sort-search d-flex">     
                <div class="search d-flex col-4 float-left">
                    <input type="text" placeholder="&#160;&#160;&#160;Search here" style = "width:100%">  
                    <span class="material-symbols-outlined"style="font-size:30px;margin-left:3px; margin-top: auto; margin-bottom:auto;">search</span>       
                </div>
                <div class="sort" onclick="toggleDropdown()">
                    <i class="fa fa-sort" style="font-size:30px;"></i>
                    <div class="dropdown-button">
                        <a href="filterorderbydate"><button class="button button1">Filter By Delivery_Date Today</button></a>
						<a href="filterorderbyshipping"><button class="button button1">Filter By Status Shipping</button></a>
						<a href="filterorderbycanceled"><button class="button button1">Filter By Status Canceled</button></a>
						<a href="filterorderbydelivered"><button class="button button1">Filter By Status delivered</button></a>
                    </div>
                </div>   
                <div class="cate">
                	<form action="filterorderbyarea">
                	<label for="cate">Province</label><br>
                                <select class="price-cate" name="province" id="cate">
                                    <option value="HCM">HCM</option>
                                    <option value="Binh Duong">Binh Duong</option>
                                    <option value="Vung Tau">Vung Tau</option>
                                    <option value="Da Nang">Da Nang</option>
                                    <option value="Ha Noi">Ha Noi</option>
                                    <option value="Hai Phong">Hai Phong</option>
                                </select>
                                <button type="submit" class="btn but-update">Find</button>
                	</form>
                  </div>
            </div>

            <div class="container-fluid all-p">
                <div class="container-fluid row-title d-flex my-3">
                    <div class="col-2 text-center title">ORDER NUMBER</div>
                    <div class="col-2 text-center title">CUSTOMER NUMBER</div>
                    <div class="col-2 text-center title">ORDER DATE</div>
                    <div class="col-2 text-center title">DELIVERY DATE</div>
                    <div class="col-2 text-center title">STATUS</div>
                    <div class="col-2 text-center title">UPDATE/DELETE</div>
                </div>
                <c:forEach items="${list}" var = "o">
                <div class="conatiern-fluid row-order d-flex">
                    <div class="col-2 text-center order"><p>${o.id_order}</p></div>
                    <div class="col-2 text-center order"><p>${o.id_customer}</p></div>
                    <div class="col-2 text-center order"><p>${o.order_date}</p></div>
                    <div class="col-2 text-center order"><p>${o.delivery_date}</p></div>
                    <div class="col-2 text-center order status my-2"><p>${o.status}</p></div>
                    <div class="col-2 text-center order btn-de-up">
                       <!-- <button class="btn but-update">UPDATE</button>  -->
                       <a href="updateorder?id_o=${o.id_order}" class="btn but-update">UPDATE</a>
                        <button class="btn but-delete ">DELETE</button>
                    </div>
                </div>
                </c:forEach>
            </div>
        </div>
        <script>
            $(document).ready(function() {
              $('.row-order .status').each(function() {
                if ($(this).text().includes('Delivered')) {
                  $(this).css('background-color', 'rgba(0, 231, 79, 0.5)');
                } else if ($(this).text().includes('Shipping')) {
                  $(this).css('background-color','rgba(255, 217, 71, 0.5)');
                }else if ($(this).text().includes('Canceled')) {
                  $(this).css('background-color','rgba(255, 99, 71, 0.5)');
                }
              });
            });
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
        <script>
            var buttonGroups =document.querySelectorAll('.btn-de-up')
            var model0= document.querySelector('.model-0');
            var model = document.querySelector('.model');
            var icon = document.querySelector('.model-header i');
            var icon0 = document.querySelector('.model-header-0 i');
            var btnYes = document.querySelector('.model-body .btn-yes');
            var btnNo = document.querySelector('model-body .btn-no');
            var submit = document.querySelector('.submit')
            function toggleCLose1(){
                model.classList.add('hide');
            }
            buttonGroups.forEach(group => {
                const deleteButton = group.querySelector('.but-delete');
                 deleteButton.addEventListener('click', () => {
                    model.classList.remove('hide');
                });
            });
            function toggleCLose2(){
                model0.classList.add('hide');
            }
            buttonGroups.forEach(group => {
                const deleteButton = group.querySelector('.but-update');
                 deleteButton.addEventListener('click', () => {
                    model0.classList.remove('hide');
                });
            });
            model.addEventListener('click', toggleCLose1);
            icon.addEventListener('click',  toggleCLose1);
            icon0.addEventListener('click',  toggleCLose2);
            btnNo.addEventListener('click', toggleCLose1);
            btnYes.addEventListener('click', toggleCLose1);
            submit.addEventListener('click', toggleCLose2);
        </script>
    </body>
</html>