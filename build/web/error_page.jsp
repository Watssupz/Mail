<%-- 
    Document   : index1
    Created on : Jan 15, 2024, 4:29:21 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%
            String mail = (String) request.getAttribute("MAIL");
            String name = (String) request.getAttribute("NAME");
        %>

        <form action="mail" method="post">
            <div>

                <table>
                    <tr>
                        <td>Mail: </td>
                        <td><input type="text" name="txtMail" value="<%=mail%>"></td>
                    </tr>
                    <tr>
                        <td>Name: </td>
                        <td><input type="text" name="txtName" value="<%=name%>"></td>
                    </tr>
                    <tr>
                        <td>Capcha: </td>
                        <td><input type="text" name="txtCapcha"></td>
                        <td>
                            <input type="submit" name="btAction" value="Send">
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" name="btAction" value="Submit"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <%
                            String error_empty = (String) request.getAttribute("ERROR_EMPTY");
                            if(error_empty != null){
                            %>
                            <p style="color: red"><%=error_empty%></p>
                            <%
                                }
                            %>
                            
                            <%
                            String ses = (String) request.getSession().getAttribute("CAPCHA");
                            
                            %>
                            <p><%=ses%></p>
                        </td>
                    </tr>
                </table>

            </div>
        </form>

    </body>
</html>
