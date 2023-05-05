<!DOCTYPE html>
<html>
    <head>
        <title>ADD NEW PRODUCT</title>
        <meta name='viewport' content='width=device-width, initial-scale=1'>
        <link rel="stylesheet" href="grid.css">
        <link rel="stylesheet" href="styleaddproduct.css">

        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">
         
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    </head>
    <body>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
        <div class="col-2 nav float-left">
            <h2 style="color:white;padding-bottom: 20px;">Panacea</h2>
            <div class="nav-item"><a href="admin.html"><span class="material-symbols-outlined">home</span>Home</a></div>
            <div class="nav-item"><a href="manageproduct.html"><span class="material-symbols-outlined">category</span>Manage Products</a></div>
            <div class="nav-item"><a href="manageuser.html"><span class="material-symbols-outlined">manage_accounts</span>Manage Users</a></div>
            <div class="nav-item"><a href="manageorder.html"><span class="material-symbols-outlined">list_alt</span>Manage Orders</a></div>
        </div>
        <div class="col-10 float-left">
            <div class="addproduct">
                <div class="header-form"><h3>ADD YOUR PRODUCT</h3></div>
                <form action="addroductadmin" id="myForm" enctype="multipart/form-data" method="post">
                    <label for="name">Product name</label><br>
                    <input class="name" type="text" id="name" name="productName" value=""  required><br>
                    <label for="name-producer">Producer</label><br>
                    <input class="name" type="text" id="name-producer" name="nameProducer" value="Levents"><br>
                    <div class="cate">
                            <label for="cate">Name Size</label><br>
                            <select class="price-cate" name="id_size" id="cate"  required>
                                	<option value="001">S</option>
                                    <option value="002">M</option>
                                    <option value="003">L</option>
                                    <option value="004">XL</option>
                                    <option value="005">XXL</option>
                            </select>
                        </div>
                    <label for="name">Quantity</label><br>
                    <input class="name" type="text" id="name" name="quantity" value=""  required><br>
                    <input type="hidden" name="id_producer" value="001">
                    <label for="descr">Product description</label><br>
                    <textarea class="descr" id="descr" name="description" rows="4" cols="70"></textarea>
                    <div class="container-price-cate my-3 d-flex">
                        <div class="price">
                            <label for="price">Price</label><br>
                            <input class="price-cate" type="text" id="price" name="price" value=""  required>
                        </div>
                        <div class="cate">
                            <label for="cate">Category</label><br>
                            <select class="price-cate" name="cate" id="cate"  required>
                                	<option value="A01">Shirt</option>
                                    <option value="A02">Hoodie</option>
                                    <option value="A03">Sweater</option>
                                    <option value="A04">Cardigan</option>
                                    <option value="A05">Jacket</option>
                                    <option value="Q01">Pant</option>
                            </select>
                        </div>
                    </div>
                    <label for="img">Select image</label><br>
                    <div class="btn-img">
                        <input type="file" id="img" name="img" accept="image/*" required > 
                    </div>
                    <div class="id-number my-3">
                        <label for="id">ID Product</label><br>
                        <input type="text" name="id" id="id" value="${id}" placeholder="${id}" required> 
                    </div>
                    <input class="submit" type="submit" value="SUBMIT">
                </form> 
            </div>
        </div>
        <script>
            function myFunction() {
                alert("The product was added");
            }
        </script>
    </body>
</html>
