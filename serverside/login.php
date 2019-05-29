<?php
 
  if($_SERVER['REQUEST_METHOD']=='POST'){
 
 $username = $_POST['username'];
 $password =  $_POST['password'];

 require_once('dbConnect.php');
 
 $sql = "SELECT * FROM login_table WHERE username = '$username' AND password = '$password'";
 $result = mysqli_query($con,$sql);
 
 if(mysqli_num_rows($result) > 0){
 echo "Successful";
 }else{
 echo "Unsuccessful";
 
   mysqli_close($con);

 }
 

}
?>