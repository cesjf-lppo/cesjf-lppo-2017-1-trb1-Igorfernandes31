<%-- 
    Document   : edita-registro
    Created on : 05/04/2017, 20:51:15
    Author     : Igor Fernandes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Editar Equipamento</h1>
        
        <form method="post">
            
            <div><input type="hidden" name="id" value="${equipamento.id}"/>id: ${equipamento.id}</div>
            
            <div><label>Serie: <input type="text" name="serie" value="${equipamento.serie}"</label></div>
            
            <div><label>Local: <input type="text" name="local" value="${equipamento.local}"</label></div>
            
            <div><label>Descricao: <textarea name="descricao">${equipamento.descricao}</textarea></label></div>
            
            <select name="estado" value="${equipamento.estado}">
                
                <option value="0" ${equipamento.estado==0?"selected":""}>0: Novo</option>
                
                <option value="1" ${equipamento.estado==1?"selected":""}>1: Em uso</option>
                
                <option value="2" ${equipamento.estado==2?"selected":""}>2: Danificado</option>
                <option value="3" ${equipamento.estado==3?"selected":""}>3: Perdido</option>
                
            </select>
                
            <div><input type="submit"></div>
        </form>
    </body>
</html>