<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Sinners</title>
</head>
<body>


<table id = "data" class="table table-primary table-hover">
    <tr>
        <th>ID</th>
        <th>Nickname</th>
        <th>Banned</th>
        <th></th>
    </tr>


    <c:forEach items="${bannedUsers}" var="bannedUser">
        <tr>
            <td>${bannedUser.id}</td>
            <td>${bannedUser.nickname}</td>
            <td>${bannedUser.banned}</td>
            <td>
                <form action="banned">
                    <input type="hidden" name="unban" value="${bannedUser.id}">
                    <input type="submit" value="UNBAN" class="btn btn-warning btn-sm btn-block">
                </form>
            </td>

        </tr>
    </c:forEach>





</table>

<div class="d-flex justify-content-center align-items-center">
    <form action="home">
        <input type="submit" value="BACK" class="btn btn-primary btn-lg btn-block">
    </form>
</div>

</body>
</html>
