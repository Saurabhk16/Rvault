<?php
$con = mysqli_connect('10.82.2.100:3306','PobodyNerfect','PobodyNerfect#1234','PobodyNerfect');

if ($con->connect_error) {
  die("Connection failed: " . $con->connect_error);
}

?>

