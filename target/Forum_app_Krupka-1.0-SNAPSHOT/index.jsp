<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>


<form action="Home" method="POST">
    NICKNAME:      <input type="text" name="nickname"> <br>
    PWD:        <input type="text" name="pwd"> <br>

    <input type="hidden" name="operacia" value="login">
    <input type="submit" value="SUBMIT">
</form>



<a href="hello-servlet">Hello Servlet</a>
</body>
</html>