<%--
  Created by IntelliJ IDEA.
  User: Zhangariny
  Date: 10/07/2015
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
  <title></title>
</head>
<body>

<h1>Edit user page</h1>
<p>Here you can edit the existing user.</p>
<p>${message}</p>
<form:form method="POST" commandName="user" action="${pageContext.request.contextPath}/user/edit/${user.id}">
  <table>
    <tbody>
    <tr>
      <td>First Name:</td>
      <td><form:input path="firstName"></form:input></td>
    </tr>
    <tr>
      <td>Last Name:</td>
      <td><form:input path="lastName"></form:input></td>
    </tr>
    <tr>
      <td><input type="submit" value="Edit"></td>
      <td></td>
    </tr>
    </tbody>
  </table>
</form:form>

<p><a href="${pageContext.request.contextPath}/user/">Home page</a></p>

</body>
</html>
