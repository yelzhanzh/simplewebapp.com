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

<h1>List of teams</h1>
<p>Here you can see the list of the teams, edit them, remove or update.</p>
<c:foreach var="team" items="${teams}">
</c:foreach><table border="1px" cellpadding="0" cellspacing="0">
  <thead>
  <tr>
    <th width="10%">id</th><th width="15%">name</th><th width="10%">rating</th><th width="10%">actions</th>
  </tr>
  </thead>
  <tbody>
  <tr>
    <td>${team.id}</td>
    <td>${team.name}</td>
    <td>${team.rating}</td>
    <td>
      <a href="${pageContext.request.contextPath}/team/edit/${team.id}.html">Edit</a><br>
      <a href="${pageContext.request.contextPath}/team/delete/${team.id}.html">Delete</a><br>
    </td>
  </tr>

  </tbody>
</table>

<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>

</body>
</html>
