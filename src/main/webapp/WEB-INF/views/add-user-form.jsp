<%--
  Created by IntelliJ IDEA.
  User: Zhangariny
  Date: 10/07/2015
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>
</head>
<body>

<h1>Add team page</h1>
<p>Here you can add a new team.</p>
<form:form method="POST" commandname="team" action="${pageContext.request.contextPath}/team/add/process.html">
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
      <td><input type="submit" value="Add"></td>
      <td></td>
    </tr>
    </tbody>
  </table>
</form:form>

<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>

</body>
</html>
