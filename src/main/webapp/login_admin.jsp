<!DOCTYPE html>
<head>
    <link rel="stylesheet" href="login.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
</head>
<body>
    <a class="home" href="admin.html"><i class="material-icons">home</i></a>
    <div class="formlogin">
        <form action="loginad" method="post" id="myform">
            <div class="imgcontainer">
              <img src="images/logoPA.png" alt="Avatar" class="avatar">
            </div>
          
            <div class="container">
              <label for="uname"><b>Username</b></label>
              <input type="text" placeholder="Enter Username" name="accountName1" required>
          
              <label for="psw"><b>Password</b></label>
              <input type="password" placeholder="Enter Password" name="passWord1" required>
          
              <button type="submit">Login</button>
              <label>
                <input type="checkbox" checked="checked" name="remember"> Remember me
              </label>
            </div>
          
            <div class="container" style="background-color:#f1f1f1">
              <button type="button" class="cancelbtn">Cancel</button>
              <span class="psw"><a href="#">Sign Up</a></span>
            </div>
          </form>
    </div>
    <script>
        const cancelBtn = document.querySelector('.cancelbtn');

        cancelBtn.addEventListener('click', function() {
            const myForm = document.getElementById('myform');
            myForm.reset();
        });
    </script>
</body>