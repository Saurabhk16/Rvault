<?php

// API endpoint URL
$url = 'http://localhost:8081/AlertController';

// Request parameters
$params = array(
    'param1' => 'value1',
    'param2' => 'value2'
);

// Initialize cURL session
$ch = curl_init();

// Set the URL and request method
curl_setopt($ch, CURLOPT_URL, $url);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true); // Return the response instead of outputting it

// Set the request headers (optional)
$headers = array(
    'Authorization: Bearer your_access_token',
    'Content-Type: application/json'
);
curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);


// Set the request method (POST, GET, PUT, DELETE, etc.)
curl_setopt($ch, CURLOPT_CUSTOMREQUEST, 'POST');

// Set the request parameters
curl_setopt($ch, CURLOPT_POSTFIELDS, json_encode($params));

// Execute the request
$response = curl_exec($ch);

// Check for errors
if ($response === false) {
    echo 'cURL error: ' . curl_error($ch);
} else {
    // Handle the response
    $responseData = json_decode($response, true);
    // Process the response data
    // ...
    // ...
}

// Close the cURL session
curl_close($ch);

?>