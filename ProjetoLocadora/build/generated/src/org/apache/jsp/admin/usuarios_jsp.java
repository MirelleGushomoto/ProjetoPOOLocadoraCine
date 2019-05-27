package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import db.Usuarios;

public final class usuarios_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/admin/../WEB-INF/jspf/header.jspf");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("    ");
      out.write("\n");
      out.write("\n");
      out.write("\n");

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



 
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <title>Usúarios</title>\n");
      out.write("  <link rel=\"stylesheet\" href=\"css/font-awesome.min.css\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"css/bootstrap.css\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");

    String path = request.getContextPath();
    String errorMessage = null;

if(request.getParameter("logon")!= null){
    String login = request.getParameter("login");
    String senha = request.getParameter("senha");
    Usuarios x = Usuarios.getUsuarios(login, senha);
        if(x==null){
            errorMessage = "Usuario ou senha inválidos";
        }
        else{
            session.setAttribute("usuario", x);
            response.sendRedirect(request.getRequestURI());
        }

}

if(request.getParameter("logoff")!=null){
    session.removeAttribute("usuario");
    response.sendRedirect(request.getRequestURI());
}


      out.write("\n");
      out.write(" \n");
if(session.getAttribute("usuario")==null){
      out.write("\n");
      out.write("\n");
      out.write(" \n");
      out.write("          \n");
      out.write("<form  class=\"form-inline\" method=\"post\">\n");
      out.write("   <div class=\"form-group mb-2\">\n");
      out.write("     <label for=\"name\" class=\"sr-only\">\n");
      out.write("         Login: <input type=\"text\" name=\"login\"/>\n");
      out.write("    <label for=\"inputPassword\" class=\"sr-only\">Password</label>\n");
      out.write("    Senha: <input type=\"password\" name=\"senha\"/>\n");
      out.write("    <input type=\"submit\" name=\"logon\" value=\"Entrar\"/>\n");
      out.write("</form>\n");
      out.write("\n");
}else{
      out.write("\n");
      out.write("<form action=\"/ProjetoLocadora/home.jsp\">\n");
      out.write("    ");
 Usuarios usuario = (Usuarios) session.getAttribute("usuario"); 
      out.write("\n");
      out.write("   <div class=\"alert alert-primary\" role=\"alert\">\n");
      out.write(" Bem vindo, ");
      out.print(usuario.getNome());
      out.write(' ');
      out.write('[');
      out.print(usuario.getRole());
      out.write("]\n");
      out.write("    <input type=\"submit\" name=\"logoff\" value=\"Sair\"/>\n");
      out.write("    </form>\n");
      out.write("\n");
      out.write("    ");
if(usuario.getRole().equals("Administrador")){
      out.write("\n");
      out.write("    [<a href=\"");
      out.print(path);
      out.write("/admin/usuarios.jsp\">Usuarios Cadastrados</a>]\n");
      out.write("    [<a href=\"");
      out.print(path);
      out.write("/admin/gfilmes.jsp\">Gerenciar Filmes</a>]\n");
      out.write("    [<a href=\"");
      out.print(path);
      out.write("/admin/locacoes.jsp\"> Gerenciar Locação </a>]\n");
      out.write("    ");
}
      out.write("\n");
      out.write("    ");
if(usuario.getRole().equals("Cliente")){
      out.write("\n");
      out.write("    <a href=\"");
      out.print(path);
      out.write("/clientes/filmes.jsp\">Lista de Filmes</a>\n");
      out.write("    ");
}
      out.write('\n');
      out.write('\n');
}
      out.write('\n');
if(errorMessage != null){
      out.write("\n");
      out.write("<h3>");
      out.print(errorMessage);
      out.write("</h3>\n");
}
      out.write('\n');
      out.write("\n");
      out.write("    <br> <br> \n");
      out.write("        <h2><center>Usuários Cadastrados</h1>\n");
      out.write("        \n");
      out.write("        <fieldset>\n");
      out.write("            <legend>Novo Usuário</legend>\n");
      out.write("            <div class=\"container\">\n");
      out.write("\n");
      out.write("                <ul class=\"nav justify-content-end\">\n");
      out.write("                    <form>\n");
      out.write("                Nome:<input type=\"text\" name=\"nome\"/>\n");
      out.write("                Função: <select name=\"role\">\n");
      out.write("                            <option value=\"Administrador\">Admin</option>\n");
      out.write("                            <option value=\"Cliente\">Cliente</option>\n");
      out.write("                        </select>\n");
      out.write("                RG:<input type=\"text\" name=\"rg\"/>\n");
      out.write("                Login:<input type=\"text\" name=\"login\"/>\n");
      out.write("                Senha:<input type=\"password\" name=\"senha\"/>\n");
      out.write("                <input type=\"submit\" name=\"novocliente\" value=\"Adicionar\"/>\n");
      out.write("                    </form> </ul> </div>\n");
      out.write("        </fieldset>\n");
      out.write("        ");
if(error != null){
      out.write("\n");
      out.write("        <h3>");
      out.print(error);
      out.write("</h3>\n");
      out.write("        ");
}
      out.write("\n");
      out.write("        <table class=\"table table-striped table-dark\">\n");
      out.write("  <thead>\n");
      out.write("    <tr>\n");
      out.write("        <th scope=\"col\">ID</th>\n");
      out.write("                <th>Nome</th>\n");
      out.write("                <th>Função</th>\n");
      out.write("                <th>RG</th>\n");
      out.write("                <th>Login</th>\n");
      out.write("                <th>Opções</th>\n");
      out.write("            </tr>\n");
      out.write("            ");
for(Usuarios x: Usuarios.getTodos()){
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print(x.getId());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(x.getNome());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(x.getRole());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(x.getRg());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(x.getLogin());
      out.write("</td>\n");
      out.write("                <td>\n");
      out.write("                    <form>\n");
      out.write("                    <input type=\"hidden\" name=\"id\" value=\"");
      out.print(x.getId());
      out.write("\"/>\n");
      out.write("                    <input type=\"submit\" name=\"excluirusuario\" value=\"Remover\"/>\n");
      out.write("                    </form>\n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("\n");
      out.write("                    \n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("            \n");
      out.write("            ");
}
      out.write("\n");
      out.write("        </table>\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
