  <%@page import="db.Filme"%>
<%-- 
    Document   : usuarios
    Created on : 25/05/2019, 17:15:35
    Author     : john
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
    String error = null;
 
        
    if(request.getParameter("excluirfilme") !=null){
        try{
            long id = Long.parseLong(request.getParameter("id"));
            Filme.ExcluirFilme(id);
            response.sendRedirect(request.getRequestURI());
        }catch(Exception e){
            error = e.getMessage();
        }
            
        }
        
    
    if(request.getParameter("novoFilme") != null){
        String nome = request.getParameter("nome");
        String genero = request.getParameter("genero");
        Double preco = Double.parseDouble(request.getParameter("preco"));
    
        try{
        Filme.AddFilme(nome, genero, preco );
        response.sendRedirect(request.getRequestURI());
        }catch(Exception e){
            error = e.getMessage();
            
        }
    }



 %>

<!DOCTYPE html>


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
        <h2>Gerenciar Filmes</h2>
          <br> 
        <fieldset>
            
           <div class="alert alert-light" role="alert">
               <div class="alert alert-warning" role="alert">Adicionar Filme</div>
             <div class="container">

                    <form>
                        <div class="form-group">
                         <strong> Nome:<input type="text" class="form-control" name="nome"/>
                Gênero <select class="form-control">
  <option>
                            <option value="comedia">Comédia</option>
                            <option value="suspense">Suspense</option>
                            <option value="terror">Terror</option>
                            <option value="drama">Drama</option>
                        </select>
                Preço:<input type="number" class="form-control" name="preco" step="0.01"/>
                <br>
                <input type="submit" name="novoFilme" class="btn btn-primary btn-lg" value="Adicionar"/>
            </form></div>
        </fieldset>
        <%if(error != null){%>
        <h3><%=error%></h3>
        <%}%>
       <table class="table table-striped table-dark">
  <thead>
    <tr>
        <th scope="col">ID</th>
                <th>Nome</th>
                <th>Gênero</th>
                <th>Preço</th>
                <th>Opções</th>
            </tr>
            <%for(Filme f: Filme.getTodosFilmes()){%>
            <tr>
                <td><%=f.getId()%></td>
                <td><%=f.getNome()%></td>
                <td><%=f.getGenero()%></td>
                <td><%=f.getPreco()%></td>
                
                <td>
                    <form>
                    <input type="hidden" name="id" value="<%=f.getId()%>"/>
                    <input type="submit" name="excluirfilme" class="btn btn-primary btn-sm"  value="Remover"/>
                    </form>
                    
                    
                    

                    
                </td>
            </tr>
            
            <%}%>
        </table>
        
    </body>
</html>