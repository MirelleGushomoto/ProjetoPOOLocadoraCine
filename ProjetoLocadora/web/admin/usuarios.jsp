    <%-- 
    Document   : usuarios
    Created on : 25/05/2019, 17:15:35
    Author     : gabri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String error = null;
 
        
    if(request.getParameter("excluirusuario") !=null){
        try{
            long id = Long.parseLong(request.getParameter("id"));
            Usuarios.ExcluirUsuario(id);
            response.sendRedirect(request.getRequestURI());
        }catch(Exception e){
            error = e.getMessage();
        }
            
        }
        
    
    if(request.getParameter("novocliente") != null){
        String nome = request.getParameter("nome");
        String role = request.getParameter("role");
        String rg = (request.getParameter("rg"));
        String login = request.getParameter("login");
        long senha = request.getParameter("senha").hashCode();
        try{
        Usuarios.AddUsuario(nome, role, rg, login, senha);
        response.sendRedirect(request.getRequestURI());
        }catch(Exception e){
            error = e.getMessage();
            
        }
    }



 %>



<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">


        <meta charset="UTF-8">
        <title>Usúarios</title>
  <link rel="stylesheet" href="css/font-awesome.min.css">
  <link rel="stylesheet" href="css/bootstrap.css">
  <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <%@include file="../WEB-INF/jspf/header.jspf" %>
        <div class="container">
    
    <center>
        <div class="alert alert-secondary" role="alert">
            <img src="logotipo.png" class="rounded float-left" width="200px" height="70px">
    <br>  
        <h2>Usuários Cadastrados</h2>
        <br> 
        <fieldset>
            
           <div class="alert alert-light" role="alert">
               <div class="alert alert-warning" role="alert">
                 Novo Usuário</div>
         <div class="container">

                    <form>
                        <div class="form-group">
                         <strong>  Nome:<input type="text" class="form-control" name="nome"/>
                Função: <select name="role" class="form-control">
                            <option value="Administrador">Admin</option>
                            <option value="Cliente">Cliente</option>
                        </select>
                RG:<input type="text" class="form-control" name="rg"/>
                Login:<input type="text" class="form-control" name="login"/>
                Senha:<input type="password"class="form-control"  name="senha"/>
                <br>
                <center> <input type="submit" name="novocliente" class="btn btn-primary btn-lg" value="Adicionar"/>
                    </form>  </div>
        </fieldset>
        <%if(error != null){%>
        <h3><%=error%></h3>
        <%}%>
        <table class="table table-striped table-dark">
  <thead>
    <tr>
        <th scope="col">ID</th>
                <th>Nome</th>
                <th>Função</th>
                <th>RG</th>
                <th>Login</th>
                <th>Opções</th>
            </tr>
            <%for(Usuarios x: Usuarios.getTodos()){%>
            <tr>
                <td><%=x.getId()%></td>
                <td><%=x.getNome()%></td>
                <td><%=x.getRole()%></td>
                <td><%=x.getRg()%></td>
                <td><%=x.getLogin()%></td>
                <td>
                    <form>
                    <input type="hidden" name="id" value="<%=x.getId()%>"/>
                    <input type="submit" class="btn btn-primary btn-sm"  name="excluirusuario" value="Remover"/>
                    </form>
                    
                    

                    
                </td>
            </tr>
            
            <%}%>
        </table>
        
    </body>
</html>
