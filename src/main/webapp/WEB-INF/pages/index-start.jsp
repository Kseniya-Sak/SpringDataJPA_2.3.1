<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Users</title>
</head>
<body>
<h2>All Users</h2>
    <table width="40%">
    <tr align="center">
        <th>ID</th>
        <th>NAME</th>
        <th>LAST NAME</th>
        <th>AGE</th>
        <th>BIRTHDAY</th>
    </tr>
    <c:forEach var="user" items="${allUsers}">
        <c:url var="updateButton" value="/updateUser">
            <c:param name="userId" value="${user.id}"/>
        </c:url>

        <c:url var="deleteButton" value="/deleteUser">
            <c:param name="userId" value="${user.id}"/>
        </c:url>
        <tr align="center">
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.lastName}</td>
                <td>${user.age}</td>
                <td>${user.birthDay}</td>
            <td >
                <input type="button" value="Update" onclick="window.location.href = '${updateButton}'">
            </td>
            <td>
                <input type="button" value="Delete" onclick="window.location.href = '${deleteButton}'">
            </td>
        </tr>

    </c:forEach>

    </table>
    <br>
    <input type="button" value="Add" onclick="window.location.href='addNewUser'">
</body>
</html>