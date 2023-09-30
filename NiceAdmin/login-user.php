<?php
  //  require('db.php');
  require('includes/connection.php');
    session_start();
    // When form submitted, check and create user session.
    if (isset($_POST['email'])) {
        $username = stripslashes($_REQUEST['email']);    // removes backslashes

        $password = stripslashes($_REQUEST['password']);

		
         
       
        // Check user is exist in the database
        $query    = "SELECT * FROM `merchant` WHERE email='$username'
                     AND password='$password'";
        $result = mysqli_query($con, $query) or die(mysql_error());
        $rows = mysqli_num_rows($result);
      
        if ($rows == 1) {
            $row = mysqli_fetch_assoc($result);
            $_SESSION['id'] = $row['Id'];
			$_SESSION['name'] = $row['NAME'];
			$_SESSION['email'] = $row['EMAIL'];
            header("Location: index.php");
        } else {
            echo "<div class='form'>
                  <h3>Incorrect Username/password.</h3><br/>
                  <p class='link'>Click here to <a href='pages-login.html'>Login</a> again.</p>
                  </div>";
        } 
    } 
?>