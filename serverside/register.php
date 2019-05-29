<?php
 
 if($_SERVER['REQUEST_METHOD']=='POST'){
    $username = $_POST['username'];
    $email = $_POST['email'];
    $phone_number = $_POST['phone_number'];
    $password = $_POST['password'];

 
    require_once('dbConnect.php');
    
    $sql = "INSERT INTO login_table (username,email,phone_number,password) VALUES ('$username','$email','$phone_number','$password')";
    
    
    if(mysqli_query($con,$sql)){ 
        echo "Successful";
    }else{
        echo "Unsuccessful";
    
    }
 }/*else{
echo 'error';
  mysqli_close($con);

}*/
?>