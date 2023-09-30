<?php
    session_start();
    if (isset($_REQUEST['email'])) {

        $email    = stripslashes($_REQUEST['email']);

        $password = stripslashes($_REQUEST['password']);
		
		$name = stripslashes($_REQUEST['name']);
		

		$apiUrl = 'localhost:8080/boardMerchant1';


		$parameters = array(			
				    "email"=> $email,
	
					"password"=> $password
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
	   header("Location: pages-login.html");
	   
  //  header("Location: index.php?id='$response'");
 
} else {
    // API call failed
    echo 'API call failed with response code: ' . $responseCode;
}
    }
?>