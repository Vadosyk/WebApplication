<%--
  Created by IntelliJ IDEA.
  User: Vados
  Date: 27.10.2019
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>AddClients</title>
  </head>
  <body>
  <h2>Add Clients</h2>
  <form action="/addClients" method="POST">
    <table>
      <tr>
        <td style="font-weight:bold;">Enter your Name:</td>
        <td><input type="text" name="name" value=" "></td>
      </tr>
      <tr>
        <td style="font-weight:bold;">Enter your Surname:</td>
        <td><input type="text" name="surname" value=" "></td>
      </tr>
      <tr>
        <td style="font-weight:bold;">Enter your Email:</td>
        <td><input type="text" name="email" value=" "></td>
      </tr>
      <tr>
        <td style="font-weight:bold;">Enter your Phone:</td>
        <td><input type="text" name="phone" value=" "></td>
      </tr>
      </table>
    <button type="submit" class="btn btn-default navbar-btn">Send files</button>
  </form>
  <br><br>
  <a href="statistics.jsp">Get clients list</a>
  </body>
</html>
