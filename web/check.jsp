<%-- 
    Document   : enterCapcha
    Created on : Jan 15, 2024, 8:02:59 AM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>

        dung
        
        
        <%
            String mail = (String) request.getAttribute("MAIL");
            String name = (String) request.getAttribute("NAME");
            if(mail != null && name != null){
            
            }
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
                        </td>
                    </tr>
                </table>

            </div>
        </form>

    </body>
</html>

