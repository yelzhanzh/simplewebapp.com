<%--
  Created by IntelliJ IDEA.
  User: Zhangariny
  Date: 10/07/2015
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title></title>
</head>
<body>

<h1>List of teams</h1>
<p>Here you can see the list of the teams, edit them, remove or update.</p>
<table border="1">
  <thead>
  <tr>
    <th width="10%">id</th>
    <th width="15%">first name</th>
    <th width="10%">last name</th>
    <th>action</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="user" items="${users}">
    <tr>
      <td>${user.id}</td>
      <td>${user.firstName}</td>
      <td>${user.lastName}</td>
      <td>
        <a href="${pageContext.request.contextPath}/user/edit/${user.id}">Edit</a><br>
        <a href="${pageContext.request.contextPath}/user/delete/${user.id}">Delete</a><br>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>

<p><a href="${pageContext.request.contextPath}/index">Home page</a></p>

</body>
</html>
