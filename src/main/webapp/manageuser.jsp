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
                    <div class="header-form"><h3>UPDATE YOUR USER</h3></div>
                    <a href="closeupdateuser"><i class="fa fa-window-close"></i></a>
                </div>
                <div class="model-body-0">
                    <form onsubmit="OnSubmit();" action="updateuseradmin" method="get">
                        <div class="container-price-cate my-3 d-flex">
                            <div class="price">
                                <label for="account">ACCOUNT</label><br>
                                <input class="float-left price-cate" type="text" id="account" name="account" value="${account}">
                            </div>
                            <div class="cate">
                                <label for="pro-number">PASSOWRD</label><br>
                                <input class="float-left price-cate" type="text" id="password" name="password" value="${password}">
                            </div>
                        </div>
                        <div class="container-price-cate my-3 d-flex">
                            <div class="price">
                                <label for="price">EMAIL</label><br>
                                <input class="float-left price-cate" type="text" id="email" name="email" value="${mail}">
                            </div>
                            <div class="cate">
                                <label for="phone">Phone number</label><br>
                                <input class="float-left price-cate" type="tel" id="phone" name="phone" pattern="(84|0[3|5|7|8|9])+([0-9]{8})\b" value="${phone}">
                            </div>
                        </div>
                        <label for="descr">ADDRESS</label><br>
                        <textarea class="descr" id="descr" name="descr" rows="4" cols="70">${address}</textarea> 
                        <input type="hidden" name="id" value="${id_c}">
                        <input class="submit" type="submit" value="SUBMIT">
                    </form>
                </div>
            </div>
        </div>
        <div class="model hide">
            <div class="model-inner">
                <div class="model-header d-flex">
                    <p>Do you want to delete this user ?</p>
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
            <div class="nav-item"><a href="adminhome.jsp"><span class="material-symbols-outlined">home</span>Home</a></div>
            <div class="nav-item"><a href="loadsanphamad"><span class="material-symbols-outlined">category</span>Manage Products</a></div>
            <div class="nav-item"><a href="loaduserad"><span class="material-symbols-outlined">manage_accounts</span>Manage Users</a></div>
            <div class="nav-item"><a href="loadorderad"><span class="material-symbols-outlined">list_alt</span>Manage Orders</a></div>
        </div>
        <div class="col-10" style="margin-left:16.66%">
            <h1><i class="fa fa-gear" style="font-size:24px"></i>Manage Order</h1>
            
            <div class="new-p my-3">
                <a href="getcustomerid"><i class="fa fa-plus-circle" style="margin-right: 10px;"></i>ADD NEW USER</a>   
            </div>
            
            <div class="my-4 sort-search d-flex">     
                <form class="col-4" action="searchuserad">
                    <div class="search d-flex">
                        <input type="text" placeholder="&#160;&#160;&#160;Search here" style = "width:100%" name="txt" value="${txtsearch}">     
                        <button type="submit" style="font-size:30px;margin-left:3px; margin-top: auto; margin-bottom:auto;"><span class="material-symbols-outlined">search</span></button>
                    </div>
                </form>
                <div class="sort" onclick="toggleDropdown()">
                    <i class="fa fa-sort" style="font-size:30px;"></i>
                    <div class="dropdown-button">
                        <button class="button button3">A -> Z</button>
                        <button class="button button4">Z -> A</button>       
                    </div>
                </div>   
            </div>

            <div class="container-fluid all-p">
                <div class="container-fluid row-title d-flex my-3">
                    <div class="col-1 text-center title">ID</div>
                    <div class="col-1 text-center title">ACCOUNT</div>
                    <div class="col-1 text-center title">PASSWORD</div>
                    <div class="col-3 text-center title">ADDRESS</div>
                    <div class="col-2 text-center title">EMAIL</div>
                    <div class="col-2 text-center title">PHONE NUMBER</div>
                    <div class="col-2 text-center title">UPDATE/BLOCK</div>
                </div>
                <c:forEach items="${list}" var = "o">
                <div class="conatiern-fluid row-order d-flex">
                    <div class="col-1 text-center order" style="word-wrap: break-word"><p>${o.id_customer }</p></div>
                    <div class="col-1 text-center order" style="word-wrap: break-word"><p>${o.accountName }</p></div>
                    <div class="col-1 text-center order" style="word-wrap: break-word"><p>${o.passWord}</p></div>
                    <div class="col-3 text-center order" style="word-wrap: break-word"><p>${o.address}</p></div>
                    <div class="col-2 text-center order" style="word-wrap: break-word"><p>${o.email}</p></div>
                    <div class="col-2 text-center order" style="word-wrap: break-word"><p>${o.phone}</p></div>
                    <div class="col-2 text-center order btn-de-up">
                        <!-- <button class="btn but-update">UPDATE</button> -->
                        <a href="updateuser?id_c=${o.id_customer}" class="btn but-update" >UPDATE</a>
                        <c:if test="${o.status != 1}">
                        <a href="blockuser?id_c=${o.id_customer}" class="btn but-update" >BLOCK</a>
                        </c:if>
                        <c:if test="${o.status == 1}">
                        <a href="blockuser?id_c=${o.id_customer}" class="btn but-update" >UNBLOCK</a>
                        </c:if>
                    </div>
                </div>
                </c:forEach>
            </div>
        </div>
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

            function OnSubmit(){
                confirm("Do you agree to change this information?");
            }
        </script>
    </body>
</html>