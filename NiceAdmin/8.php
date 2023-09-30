<?php

// API endpoint URL
$apiUrl = 'localhost:8080/upload';

// Path to the file to send
$filePath = '/Readme.txt';

// Create a cURL file object
$file = new CURLFile($filePath);

// Request parameters (if any)
$parameters = array(

);

// Initialize cURL session
$ch = curl_init();

// Set the cURL options
curl_setopt($ch, CURLOPT_URL, $apiUrl);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
curl_setopt($ch, CURLOPT_POST, true);

// Create the multipart/form-data payload
$postData = array_merge($parameters, array('image' => $file));
curl_setopt($ch, CURLOPT_POSTFIELDS, $postData);

// Execute the cURL request
$response = curl_exec($ch);

// Check for cURL errors
if (curl_errno($ch)) {
    echo 'cURL error: ' . curl_error($ch);
}

// Get the HTTP response code
$responseCode = curl_getinfo($ch, CURLINFO_HTTP_CODE);

// Close the cURL session
curl_close($ch);

// Process the response
if ($responseCode === 200) {
    // Successful API call
    // Process the response data
    echo $response;
} else {
    // API call failed
    echo 'API call failed with response code: ' . $responseCode;
}

?>