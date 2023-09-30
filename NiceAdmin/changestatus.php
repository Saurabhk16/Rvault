<?php

    // When form submitted, check and create user session.
	$conn = mysqli_connect('10.82.2.100:3306','PobodyNerfect','PobodyNerfect#1234','PobodyNerfect');

	$status = $_POST['approval'];
	$id = $_GET['id'];


     $query    = "SELECT * FROM `emaildetails` WHERE Id='$id'";
     $result = mysqli_query($conn, $query) or die(mysql_error());
     $rows = mysqli_num_rows($result);
	  $row = mysqli_fetch_assoc($result);
	


		$time = strtotime($row['DATE']);

		$curtime = time();

	/*	if(($curtime-$time) > 6000) {     //1800 seconds
			header("Location: 404.php");
		}else{ */
				$sql = "UPDATE emaildetails SET flag='$status' WHERE Id='$id'";

		if ($conn->query($sql) === TRUE) {
			echo '<script>alert("Response Upated successfully")</script>';
			 header("Location: pages-error-404.html");
		} else {
			echo "Error updating record: " . $conn->error;
			header("Location: pages-error-404.html");
			} 
		/*}*/
		



$conn->close();
	
	
?>