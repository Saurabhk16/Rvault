<?php
    session_start();
    if(!isset($_SESSION["id"])) {
        header("Location: pages-login.html");
        exit();
    }else{
        require('config.php');
    }
?>