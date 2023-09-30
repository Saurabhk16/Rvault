<?php

   session_start();
	$id = $_SESSION['id']; 
	$email = $_SESSION['email']; 

	$doc_id =  $_GET['docName'];
					
		$conn = mysqli_connect('10.82.2.100:3306','PobodyNerfect','PobodyNerfect#1234','PobodyNerfect');
					
					if ($conn->connect_error) {
						die("Connection failed: " . $conn->connect_error);
						}
						
						$sql = "DELETE FROM document_master_test WHERE dname = '$doc_id'";
						$result = $conn->query($sql);
						
					    header("Location: index.php");
					?>
	

