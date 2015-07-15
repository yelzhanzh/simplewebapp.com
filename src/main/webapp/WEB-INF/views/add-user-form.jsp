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

<h1>Add user page</h1>
<p>Here you can add a new user.</p>
<form:form method="POST" commandName="user" action="${pageContext.request.contextPath}/user/add/process">
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
      <td><input type="submit" value="Add"></td>
      <td></td>
    </tr>
    </tbody>
  </table>
</form:form>

<p><a href="${pageContext.request.contextPath}/user/">Home page</a></p>

</body>
</html>
