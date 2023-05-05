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
        </div>
        <div class="col-2 nav float-left">
            <h2 style="color:white;padding-bottom: 20px;">Panacea</h2>
            <div class="nav-item"><a href="admin.html"><span class="material-symbols-outlined">home</span>Home</a></div>
            <div class="nav-item"><a href="manageproduct.html"><span class="material-symbols-outlined">category</span>Manage Products</a></div>
            <div class="nav-item"><a href="manageuser.html"><span class="material-symbols-outlined">manage_accounts</span>Manage Users</a></div>
            <div class="nav-item"><a href="manageorder.html"><span class="material-symbols-outlined">list_alt</span>Manage Orders</a></div>
        </div>
        <div class="col-10 float-left">
            <div class="addproduct">
                <div class="header-form"><h3>ADD NEW USER</h3></div>
                <form id="myForm" onsubmit="myFunction()" action="adduseradmin">
                    <label for="name">User name</label><br>
                    <input class="name" type="text" id="name" name="accountname" value=""  required><br>
                    <label for="password">Password</label><br>
                    <input class="name" type="password" id="password" name="password" value=""  required><br>
                    <label for="address">Address</label><br>
                    <textarea class="descr" id="address" name="address" rows="4" cols="70"></textarea>
                     <label for="name">Gender (Male/Female)</label><br>
                    <input class="name" type="text" id="name" name="gender" value=""  required><br>
                    <label for="name">Name</label><br>
                    <input class="name" type="text" id="name" name="name" value=""  required><br>
                    <div class="container-price-cate my-3 d-flex">
                        <div class="price">
                            <label for="price">Email</label><br>
                            <input class="price-cate" type="email" id="email" name="email" value="" required><br>
                            <label for="phone">Phone number</label><br>
                            <input class="price-cate" type="tel" id="phone" name="phone" pattern="(84|0[3|5|7|8|9])+([0-9]{8})\b">
                        </div>
                    </div>
                    <div class="id-number my-3">
                        <label for="id">ID User</label><br>
                        <input type="text" name="id" id="id" value="${id}"  required> 
                    </div>
                    <input class="submit" type="submit" value="SUBMIT">
                </form> 
            </div>
        </div>
        <script>
            function myFunction() {
                alert("The user was added");
            }
        </script>
    </body>
</html>
