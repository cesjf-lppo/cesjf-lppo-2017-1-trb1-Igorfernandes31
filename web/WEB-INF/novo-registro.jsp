<%-- 
    Document   : novo-registro
    Created on : 05/04/2017, 22:10:05
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
        <h1>Entrada de Equipamentos</h1>
        
        <form method="post">
            
            <div><label>Número de serie: <input type="text" name="serie" class="form-control"></label></div>
            
            <div><label>Local: <input type="text" name="local" class="form-control"></label></div>
            
            <div><label>Descricao: <textarea name="descricao" class="form-control"></textarea></label></div>
            
            <select name="estado">
                
                 <option value="0">0: Novo</option>
                 
                <option value="1">1: Em uso</option>
                
                <option value="2">2: Danificado</option>
                
                <option value="3">3: Perdido</option>
                
            </select><br><br>
            
            <div><input type="submit" class="btn btn-default"></div>
            
        </form>
    </body>  
</html>
