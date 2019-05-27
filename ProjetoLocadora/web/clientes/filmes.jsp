<%-- 
    Document   : filmes
    Created on : 26/05/2019, 12:11:20
    Author     : john
--%>

<%@page import="db.Filme"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
                        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gerenciar Filmes</title>
    </head>
    <body>
        <%@include file="../WEB-INF/jspf/header.jspf" %>
        <div class="container">
    
    <center>
        <div class="alert alert-secondary" role="alert">
            <img src="logotipo.png" class="rounded float-left" width="200px" height="70px">
    <br>  
        <h2>Lista Filmes</h2>
        
        <table class="table table-striped table-dark">
  <thead>
    <tr>
        <th scope="col">ID</th>
                <th>Nome</th>
                <th>Gênero</th>
                <th>Preço</th>
                
            </tr>
            <%for(Filme f: Filme.getTodosFilmes()){%>
            <tr>
                <td><%=f.getId()%></td>
                <td><%=f.getNome()%></td>
                <td><%=f.getGenero()%></td>
                <td><%=f.getPreco()%></td>
                
            </tr>
            
            <%}%>
        </table>
        
    </body>
</html>