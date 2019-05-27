<%-- 
    Document   : locacoes
    Created on : 26/05/2019, 23:57:57
    Author     : mirel
--%>

<%@page import="db.Locacao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
                <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gerenciar Locação</title>
    </head>
    <body>
        <%@include file="../WEB-INF/jspf/header.jspf" %>
         <div class="container">
    
    <center>
        <div class="alert alert-secondary" role="alert">
            <img src="logotipo.png" class="rounded float-left" width="200px" height="70px">
    <br>  
        <h2>Gerenciar Locação</h2>
          <br> 
        <fieldset>
            
           <div class="alert alert-light" role="alert">
               <div class="alert alert-warning" role="alert">Adicionar Locação</legend>
            </div>
             <div class="container">

                    <form>
                        <div class="form-group">
                         <strong> 
                Data de Alguel: <input type="date" class="form-control" name="aluguel"/>
                Data de Devolução:<input type="date"class="form-control"  name="devollucao"/>
                Id Cliente:<input type="text"class="form-control"  name="id"/>
                <br>
                <input type="submit" name="novoFilme"class="btn btn-primary btn-lg" value="Adicionar"/>
            </form>
        </fieldset>
       
       <table class="table table-striped table-dark">
  <thead>
    <tr>
        <th scope="col">ID</th>
                <th>Data Aluguel</th>
                <th>Data Devolução</th>
            </tr>
            <%for(Locacao l: Locacao.getLocacao()){%>
            <tr>
                <td><%=l.getId()%></td>
                <td><%=l.getAluguel()%></td>
                <td><%=l.getDevolucao()%></td>
                
                <td>
                    <form>
                    <input type="hidden" name="id" value="<%=l.getId()%>"/>
                    <input type="submit" name="excluirfilme" class="btn btn-primary btn-sm"  value="Remover"/>
                    </form>
                    
                    
                    

                    
                </td>
            </tr>
            
            <%}%>
        </table>
        
    </body>
</html>