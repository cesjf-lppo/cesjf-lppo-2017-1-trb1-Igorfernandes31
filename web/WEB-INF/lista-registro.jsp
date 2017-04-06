<%-- 
    Document   : lista-registro
    Created on : 05/04/2017, 21:51:36
    Author     : Igor Fernandes
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="get">
        <h1>Listar Equipamentos</h1>
        
        <select name="filtro">
                 <option value="" ${(filtro=="")?"selected":""}>Todos</option>
                 <option value="WHERE estado=0" ${(filtro=="WHERE estado=0")?"selected":""}>0: Novo</option>
                 
                 <option value="WHERE estado=1" ${(filtro=="WHERE estado=1")?"selected":""}>1: Em uso</option>
                 
                 <option value="WHERE estado=2" ${(filtro=="WHERE estado=2")?"selected":""}>2: Danificado</option>  
                 <option value="WHERE estado=3" ${(filtro=="WHERE estado=3")?"selected":""}>3: Perdido</option>
                 
        </select>
        <div><input type="submit" value="Filtrar" class="btn btn-default"></div>
        </form>    
        <table>
            <tr>
                <th>Id</th> <th>Serie</th><th>Local</th><th>Descricao</th> <th>Estado</th>
            </tr>
            
            <c:forEach var="equipamento" items="${equipamentos}">
                <tr>
                    <td><a href="edita.html?id=${equipamento.id}">${equipamento.id}</a></td>
                    <td>${equipamento.serie}</td><td>${equipamento.local}</td><td>${equipamento.descricao}</td>
                    <td>
                        <c:choose>
                            <c:when test="${equipamento.estado == 0}">
                                0: Novo    
                            </c:when>
                                
                            <c:when test="${equipamento.estado == 1}">
                                1: Em uso
                            </c:when>
                                
                            <c:when test="${equipamento.estado == 2}">
                                2: Danificado
                            </c:when>
                                
                            <c:when test="${equipamento.estado == 3}">
                                3: Perdido
                            </c:when>
                                
                        </c:choose>
                    <td><a href="exclui.html?id=${equipamento.id}">X</a></td>
                </tr>
                
            </c:forEach>
        </table>
    </body>
</html>