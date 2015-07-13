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

<h1>Edit team page</h1>
<p>Here you can edit the existing team.</p>
<p>${message}</p>
<form:form method="POST" commandname="team" action="${pageContext.request.contextPath}/user/edit/${team.id}">
  <table>
    <tbody>
    <tr>
      <td>Name:</td>
      <td><form:input path="name"></form:input></td>
    </tr>
    <tr>
      <td>Rating:</td>
      <td><form:input path="rating"></form:input></td>
    </tr>
    <tr>
      <td><input type="submit" value="Edit"></td>
      <td></td>
    </tr>
    </tbody>
  </table>
</form:form>

<p><a href="${pageContext.request.contextPath}/index">Home page</a></p>

</body>
</html>
