<?php 

/*require ('products/History.php');

	echo 'dentro de insert';*/

	 //open connection to mysql db
    $connection = mysqli_connect("localhost","root","root","productsAndroid") or die("Error " . mysqli_error($connection));

    if($_SERVER['REQUEST_METHOD']=='POST') {
		$tittle = $_REQUEST['tittle'];
 		$image = $_REQUEST['image'];
        $units = $_REQUEST['units'];
        $pvp = $_REQUEST['pvp'];
        $rating = $_REQUEST['rating'];
        
        echo $tittle;
        echo $image;
        echo $units;
        echo $pvp;
        echo $rating;
        
	}

	$sql = "INSERT INTO HISTORICO (tittle,imgUrl,uds,precio,rating) 
            VALUES ( '".$tittle."','".$image."', '".$units."', '".$pvp."' , '".$rating."')";
	echo $sql;

	 $result = mysqli_query($connection, $sql) or die("Error in inserting " . mysqli_error($connection));

/*INSERT INTO `HISTORICO`(`TITTLE`, `IMGURL`, `uds`, `precio`, `rating`)
VALUES ("Grand Theft Auto V", "/img/Games/gtaV.jpg" ,200, 29.95, 10.0)*/
 
	/* if(mysqli_query($connection,$sql)){
	 	//file_put_contents($path,base64_decode($image));
	 	echo "Successfully Uploaded";
	 }
	 
	 mysqli_close($connection);
	 	}else{
	 	echo "Error";
	 }*/

 	


	//$register = new History ($tittle, $image);
	//$register->insertNewHistory();
	
	//echo "Successfully inserted";




 ?>