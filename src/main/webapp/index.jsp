<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<h1><%= "ENTER CREDENTIALS: " %>
</h1>
<br/> <br>


<form action="Home" method="POST">
    NICKNAME:      <input type="text" name="nickname"> <br> <br>
    PASSWORD:           <input type="password" name="pwd"> <br>  <br> <br>

    <input type="hidden" name="operacia" value="login">
    <input type="submit" value="SUBMIT">
</form>
<br>
<br>
<br>

VALID CREDENTIALS: <br>
NICKNAME  | PWD  <br>
Janko123  | pouz1 <br>
Ferko123  | pouz2 <br>
Martin123 | pouz3 <br>
Ignac123  | pouz4 <br>
Spekulant123 | spek1 <br>


</body>
</html>