<?php 

include("includes/connection.php");

   session_start();
	$id = $_SESSION['id']; 
	$email = $_SESSION['email']; 



if(isset($_POST['sign_up'])){	
		$docs_description = $_POST['docs_descripition'];
	
		$document_type = $_POST['docs_type'];
		$ss = $_FILES['my_file']['name'];
		
}

if (($_FILES['my_file']['name']!="")){

	$target_dir = "includes/";
	$file = $_FILES['my_file']['name'];
	$path = pathinfo($file);
	$filename = $path['filename'];
	$ext = $path['extension'];
	
	$file_name= $filename.".".$ext;
	



// API endpoint URL
$apiUrl = 'localhost:8080/upload';

// Path to the file to send


$byte_array = file_get_contents($file_name);
$image = base64_encode($byte_array);

		$parameters = array(			
				    "image" => $image,
					"id" => $id,
					"dname" => $document_type
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
	
	   
    header("Location: index.php?id='$response'");
 
} else {
    // API call failed
    echo 'API call failed with response code: ' . $responseCode;
}
    

 
}
?>