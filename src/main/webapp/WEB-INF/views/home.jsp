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

<h1>Home page</h1>
<p>
  ${message}<br>
  <a href="${pageContext.request.contextPath}/user/add">Add new team</a><br>
  <a href="${pageContext.request.contextPath}/user/list">Team list</a><br>
</p>

</body>
</html>
