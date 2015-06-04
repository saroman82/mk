<%-- 
    Document   : posterqr
    Created on : 27-may-2015, 10:24:49
    Author     : santi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>

    <table>
        <tr>
            <td>
                <h1>Proveedor : </h1> 
                
            </td>
        </tr>
        
         <tr>
            <td>
                <h1>Hello World!</h1>
                <% String proveedor  = request.getParameter("proveedor");
                    String tipomueble = request.getParameter("tipomueble");
                    String ru = request.getSession().getServletContext().getRealPath("/");
                    String rutaimagen= "file:///home/santi/NetBeansProjects/proyectomk/imagenesqr/91/rustico.png";
                    out.println(rutaimagen);
                %>
                <img src="file:///home/santi/NetBeansProjects/proyectomk/imagenesqr/91/rustico" height="125" width="150" alt="nada"></img>
            </td>
        </tr>
        
        <tr>
            <td>
                <h1>Tipo mueble : </h1>
            </td>
        </tr>
    </table>

</html>

