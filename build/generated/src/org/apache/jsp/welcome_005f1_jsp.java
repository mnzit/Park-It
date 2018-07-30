package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class welcome_005f1_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/header.jsp");
    _jspx_dependants.add("/footer.jsp");
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/materialize.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/materialize.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/tippy.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\n");
      out.write("        <link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.1.0/css/all.css\" integrity=\"sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt\" crossorigin=\"anonymous\">\n");
      out.write("        <title>Park it!</title>\n");
      out.write("    </head>\n");
      out.write("    <div class=\"navbar-fixed\">\n");
      out.write("        <nav>\n");
      out.write("            <div class=\"nav-wrapper\">\n");
      out.write("                <a href=\"#!\" class=\"brand-logo ml-4\">Park It!</a>\n");
      out.write("                <a href=\"#\" data-target=\"mobile-demo\" class=\"sidenav-trigger\"><i class=\"material-icons\">menu</i></a>\n");
      out.write("                <ul class=\"right hide-on-med-and-down\">\n");
      out.write("                    <li><a href=\"index.jsp\">HOME</a></li>\n");
      out.write("                    <li><a href=\"aboutus.jsp\">ABOUT US</a></li>\n");
      out.write("                    <li><a href=\"contactus.jsp\">CONTACT US</a></li>\n");
      out.write("                    ");
if (session.getAttribute("username") != null) { 
      out.write("<li><a href=\"welcome.jsp\" class=\"toUpper\">dashboard</a></li> ");
}
      out.write("      \n");
      out.write("                    <li><a href=\"\" class=\"toUpper cs\">");
if (session.getAttribute("username") != null) { 
      out.write(" Logged in by ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${username}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(' ');
      out.write('|');
}
      out.write("</a></li>\n");
      out.write("                    ");
if (session.getAttribute("username") != null) {
      out.write("<li><form action=\"Logout\"><a href=\"\"><button class=\"btn btn-success\" type=\"submit\">Logout</button></a></form></li>");
}
      out.write("\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("    </div>\n");
      out.write("    <ul class=\"sidenav\" id=\"mobile-demo\">\n");
      out.write("        ");
if (session.getAttribute("username") != null) { 
      out.write(" <li><a href=\"welcome.jsp\" class=\"nav-item nav-link toUpper\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${username}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" dashboard </a></li>");
}
      out.write("\n");
      out.write("        <li><a href=\"index.jsp\">HOME</a></li>\n");
      out.write("        <li><a href=\"aboutus.jsp\">ABOUT US</a></li>\n");
      out.write("        <li><a href=\"contactus.jsp\">CONTACT US</a></li>\n");
      out.write("        ");
 if (session.getAttribute("username") != null) {  
      out.write("<li><form action=\"Logout\"><button class=\"btn btn-success logoutm\" type=\"submit\">Log out</button></form></li>");
}
      out.write("\n");
      out.write("    </ul>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\" style=\"margin-top:100px;margin-bottom:100px;\">");
      out.write('\n');
  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Expries", "0");
    if (session.getAttribute("username") == null) {
        response.sendRedirect("login.jsp");
    }

      out.write("\n");
      out.write("\n");
      out.write("    <div class=\"d-flex align-items-stretch col\">\n");
      out.write("        <div class=\"card\">\n");
      out.write("            <h5 class=\"card-header\">Members</h5>\n");
      out.write("            <img class=\"card-img-top\" src=\"data:image/jpeg;base64,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\">\n");
      out.write("            <div class=\"card-body\">\n");
      out.write("                <h5 class=\"card-title\">Manage your Members</h5>\n");
      out.write("                <p class=\"card-text\">Manage members, Add, Update and delete functionality</p>\n");
      out.write("                <a href=\"MemberController\" class=\"btn btn-primary\">Begin</a>\n");
      out.write("            </div>\n");
      out.write("        </div>    \n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"d-flex align-items-stretch col\">\n");
      out.write("        <div class=\"card\">\n");
      out.write("            <h5 class=\"card-header\">Parking</h5>\n");
      out.write("            <img class=\"card-img-top\" src=\"http://autostrat.com/images/parking-lot.jpg\">\n");
      out.write("            <div class=\"card-body\">\n");
      out.write("                <h5 class=\"card-title\">Members and non-members parking</h5>\n");
      out.write("                <p class=\"card-text\">Add,update vehicle park history</p>\n");
      out.write("                <a href=\"ParkingController\" class=\"btn btn-primary memberBtn\">Begin</a>\n");
      out.write("            </div>\n");
      out.write("        </div>    \n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("<script src=\"js/jquery-3.2.1.min.js\"></script>\n");
      out.write("<script src=\"js/materialize.js\"></script>\n");
      out.write("<script src=\"js/materialize.min.js\"></script>  \n");
      out.write("<script src=\"js/popper.min.js\"></script>\n");
      out.write("<script src=\"js/tippy.min.js\"></script>\n");
      out.write("<script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("<script src=\"js/script.js\"></script>\n");
      out.write("<footer class=\"page-footer\">\n");
      out.write("    <div class=\"footer-copyright\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            © 2018 Copyright by Park It!\n");
      out.write("            <a class=\"grey-text text-lighten-4 right mr-4 ml-4\" href=\"#\"><i class=\"fab fa-facebook\"></i></a>\n");
      out.write("            <a class=\"grey-text text-lighten-4 right mr-4 ml-4\" href=\"#\"><i class=\"fas fa-envelope-square\"></i></a>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</footer>\n");
      out.write("</html>");
      out.write("\t\n");
      out.write("\n");
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
