<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="signup.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    </head>
    <body>
        <a class="home" href="admin.html"><i class="material-icons">home</i></a>
        <div class="signup">
            <form id = "myform" action="do-register" style="border:1px solid #ccc">
                <div class="container">
                  <h1>Sign Up</h1>
                  <p>Please fill in this form to create an account.</p>
                  <hr>
              	  
              	  <label for="psw-repeat"><b>Account name</b></label>
                  <input type="text" placeholder="Enter Account Name" name="accountName" required>
              	  
                  <label for="email"><b>Email</b></label>
                  <input type="text" placeholder="Enter Email" name="email" required>
              
                  <label for="psw"><b>Password</b></label>
                  <input type="password" placeholder="Enter Password" name="passWord" required>
              
                  
                  
                  <label>
                    <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> Remember me
                  </label>
                  
                  <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>
              
                  <div class="clearfix">
                    <button type="button" class="cancelbtn">Cancel</button>
                    <button type="submit" class="signupbtn">Sign Up</button>
                  </div>
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
</html>