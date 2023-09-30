        <table class="table table-borderless datatable">
                    <thead>
                      <tr>
             
                      </tr>
                    </thead>
                    <tbody>
					<?php  
					$conn = mysqli_connect('10.82.2.100:3306','PobodyNerfect','PobodyNerfect#1234','PobodyNerfect');
					
				if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}

$sql = "SELECT * FROM merchant";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
  // output data of each row
  while($row = $result->fetch_assoc()) {
    echo $row["Id"];
  }
} else {
  echo "0 results";
}
$conn->close();
					?>

                    </tbody>
                  </table>
