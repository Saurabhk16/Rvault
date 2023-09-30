<?php
	

   session_start();
	$id = $_SESSION['id']; 
	$email = $_SESSION['email']; 
	$dname = $_GET['docName']; 

	

// API endpoint URL
$apiUrl = 'http://localhost:8080/download';

// Request parameters
//

$parameters = array(
		"merchantId" => $id,
		"dname" => $dname
	);

// Initialize cURL session
$ch = curl_init();

// Set the cURL options
curl_setopt($ch, CURLOPT_URL, $apiUrl);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
curl_setopt($ch, CURLOPT_POST, true);
curl_setopt($ch, CURLOPT_POSTFIELDS, http_build_query($parameters));

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

	$imgData = base64_encode($response);
	$img = "<img src= 'data:image/jpeg;base64  , $response' />";
	//print($img);
	echo $img;
/*
header('Content-Type: image/png');
header('Content-Disposition: attachment; filename="image.png"');

// Write the image byte array to a temporary file
$tempFilePath = tempnam(sys_get_temp_dir(), 'image');
file_put_contents($tempFilePath, $imgData);

// Read and output the temporary file to the browser
readfile($tempFilePath);

// Delete the temporary file
unlink($tempFilePath);
exit;
*/
} else {
    // API call failed
    echo 'API call failed with response code: ' . $responseCode;
}

?>