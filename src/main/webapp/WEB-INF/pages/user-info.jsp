<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <h2>User Info</h2>
    <form:form action="saveUser" modelAttribute="user">
    <form:hidden path="id"/>
    <table>
        <tr>
            <td>Name</td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td>Last Name</td>
            <td><form:input path="lastName"/></td>
        </tr>
        <tr>
            <td>Age</td>
            <td><form:input path="age"/></td>
        </tr>
        <tr>
            <td>Birthday</td>
            <td><form:input path="birthDay"/></td>
        </tr>
    </table>
    <input type="submit" value="Ok">
</form:form>
</body>
</html>