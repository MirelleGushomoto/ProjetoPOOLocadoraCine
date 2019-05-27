package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import db.Usuarios;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/WEB-INF/jspf/header.jspf");
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("<h1>Locadora - WebApp</h1>\n");

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
      out.write("\n");
      out.write("\n");
if(session.getAttribute("usuario")==null){
      out.write("\n");
      out.write("<form method=\"post\">\n");
      out.write("    Login: <input type=\"text\" name=\"login\"/>\n");
      out.write("    Senha: <input type=\"password\" name=\"senha\"/>\n");
      out.write("    <input type=\"submit\" name=\"logon\" value=\"Entrar\"/>\n");
      out.write("</form>\n");
      out.write("\n");
}else{
      out.write("\n");
      out.write("<form action=\"http://localhost:8084/ProjetoLocadora/home.jsp\">\n");
      out.write("    ");
 Usuarios usuario = (Usuarios) session.getAttribute("usuario"); 
      out.write("\n");
      out.write("    Bem vindo, ");
      out.print(usuario.getNome());
      out.write(' ');
      out.write('[');
      out.print(usuario.getRole());
      out.write("]\n");
      out.write("    <input type=\"submit\" name=\"logoff\" value=\"Sair\"/>\n");
      out.write("    </form>  \n");
      out.write("    \n");
      out.write("    ");
if(usuario.getRole().equals("Administrador")){
      out.write("\n");
      out.write("    [<a href=\"");
      out.print(path);
      out.write("/admin/usuarios.jsp\">Usuarios Cadastrados</a>]    \n");
      out.write("    [<a href=\"");
      out.print(path);
      out.write("/admin/gfilmes.jsp\">Gerenciar Filmes</a>]    \n");
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
      out.write("\n");
      out.write("    \n");
}
      out.write('\n');
if(errorMessage != null){
      out.write("\n");
      out.write("<h3>");
      out.print(errorMessage);
      out.write("</h3>\n");
}
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
