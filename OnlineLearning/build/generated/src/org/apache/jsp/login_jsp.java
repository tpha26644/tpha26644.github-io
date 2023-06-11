package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("    <head>\r\n");
      out.write("        <title>Login</title>\r\n");
      out.write("\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("        <meta name=\"keywords\" content=\"Space Login Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements\" />\r\n");
      out.write("        <script type=\"application/x-javascript\"> addEventListener(\"load\", function() { setTimeout(hideURLbar, 0); }, false);\r\n");
      out.write("            function hideURLbar(){ window.scrollTo(0,1); } </script>\r\n");
      out.write("\r\n");
      out.write("        <link href=\"css/login.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" />\r\n");
      out.write("\r\n");
      out.write("        <link href=\"//fonts.googleapis.com/css?family=Montserrat:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&amp;subset=latin-ext,vietnamese\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");

            String mess = (String) request.getAttribute("mess");
        
      out.write("\r\n");
      out.write("        <div class=\"main fadeInDown \">\r\n");
      out.write("            <div class=\"main-w3l\">\r\n");
      out.write("                <h1 class=\"logo-w3 active\">Heath Care System</h1>\r\n");
      out.write("                <div class=\"w3layouts-main\">\r\n");
      out.write("                    <h2><span class=\"fadeIn first\">Login now</span></h2>\r\n");
      out.write("                    <form action=\"login\" method=\"POST\">\r\n");
      out.write("                        <input class=\"fadeIn second\" placeholder=\"Username\" name=\"user\" type=\"text\" required=\"\">\r\n");
      out.write("                        <input class=\"fadeIn second\" placeholder=\"Password\" name=\"pass\" type=\"password\" required=\"\">\r\n");
      out.write("                        <h3>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mess}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h3>\r\n");
      out.write("                        <input type=\"submit\" class=\"fadeIn fifth\" value=\"Login\" name=\"submit\">\r\n");
      out.write("                    </form>\r\n");
      out.write("                    <h6><a class=\"fadeIn fifth\" href=\"resetPassword\">Forget Password</a></h6> \r\n");
      out.write("                    <h6><a class=\"fadeIn fifth\" href=\"RegisterServlet\">Register</a></h6>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"footer-w3l\"></div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
