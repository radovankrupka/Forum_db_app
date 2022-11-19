<%--
  Created by IntelliJ IDEA.
  User: Radko
  Date: 19 Nov 2022
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

YOUR POST:
<br>
<form name="post-form" method="get" action="save">

   <textarea rows = "4" cols = "40" name = "post-text" placeholder="Enter text of your post here: ">
   </textarea>
    <br>
    <input type="submit" value="SUBMIT"  class="btn btn-primary btn-lg btn-block ">

</form>
</body>
</html>
