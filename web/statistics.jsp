<%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core"%>
<%--Created by IntelliJ IDEA.
  User: Vados
  Date: 27.10.2019
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>


  <html>
    <head>
    <title>ALL_CLIENTS</title>
    </head>
        <body>
            <h2>CLIENTS LIST</h2>

            <form action="GetListServlet" method="GET">
               <p> <input type="submit" value="Get list"></p>
            </form>
                    <table border="5">
                        <tr><th>ID</th>
                            <th>Name</th>
                            <th>Surname</th>
                            <th>Email</th>
                            <th>Phone</th><th></th></tr>
                            <tbody>


                             <c:forEach items="${clientsList}" var="clientsList" >
                                 <tr>
                                     <td>${clientsList.id}><</td>
                                     <td>${clientsList.name}</td>
                                     <td>${clientsList.surname}</td>
                                     <td>${clientsList.email}</td>
                                     <td>${clientsList.phone}></td>
                                 </tr>>
                             </c:forEach>

                            </tbody>
                    </table>
                             <br><br>
                            <a href="index.jsp?correct=1">Back</a>
        </body>
</html>