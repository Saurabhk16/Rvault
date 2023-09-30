<?php

$url = 'http://localhost:8081/AlertController'; // Added "http://" to the URL
$data = array(
    "escalationName" => "Receipt Printer Fault",
    "cdmStatus" => "INSERVICE"
);
$dataString = json_encode($data); // Fixed the variable name and added missing semicolon
echo $dataString;
$ch = curl_init($url); // Fixed the variable name
curl_setopt($ch, CURLOPT_CUSTOMREQUEST, "POST");
curl_setopt($ch, CURLOPT_POSTFIELDS, $dataString); // Removed "array()" wrapper from $dataString
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true); // Added CURLOPT_RETURNTRANSFER to capture the response
curl_setopt($ch, CURLOPT_HTTPHEADER, array(
    'Content-Type: application/json',
    'Content-Length: ' . strlen($dataString) // Fixed the variable name and added missing closing parenthesis
));

$result = curl_exec($ch); // Fixed the variable name
curl_close($ch);

echo $result; // Display the response from the API


?>