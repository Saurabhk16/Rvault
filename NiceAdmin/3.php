<?php

$url = 'localhost:8080/AlertController';
//$url =  'https://stackoverflow.com/questions/58696598/object-of-class-curlfile-could-not-be-converted-to-string';
$data = array(
	"escalationName"=>"Receipt Printer Fault",
"terminalID"=>"00010002",
"institutionID"=>"I0001",
"escalationId" => "007",
"cdmStatus" => "INSERVICE"
	);
	
$data_string = json_encode($data);

$ch=curl_init($url);
curl_setopt($ch, CURLOPT_CUSTOMREQUEST, "POST");
curl_setopt($ch, CURLOPT_POSTFIELDS, array("customer"=>$data_string));
curl_setopt($ch, CURLOPT_HEADER, false);
curl_setopt($ch, CURLOPT_HTTPHEADER,
    array(
        'Content-Type:application/json',
        'Content-Length: 250' 
    )
);

$result = curl_exec($ch);
curl_close($ch);
?>







 

 