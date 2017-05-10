package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class testPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/partials/header.jsp");
    _jspx_dependants.add("/partials/footer.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_url_value_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_url_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_url_value_nobody.release();
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

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        \r\n");
      out.write("        ");
 if( request.getSession().getAttribute("user_data") == null){ 
      out.write("\r\n");
      out.write("            <title>Welcome to QuickTest</title>\r\n");
      out.write("        ");
}else{
      out.write("\r\n");
      out.write("            <title>Dashboard</title>\r\n");
      out.write("        ");
}
      out.write("\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"https://fonts.googleapis.com/css?family=Tangerine|Signika|Jura|Ruluko|Marcellus SC\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"https://fonts.googleapis.com/css?family=Oxygen|Muli|Lato|Asar|Cormorant+SC\" />\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      if (_jspx_meth_c_url_0(_jspx_page_context))
        return;
      out.write("\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      if (_jspx_meth_c_url_1(_jspx_page_context))
        return;
      out.write("\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      if (_jspx_meth_c_url_2(_jspx_page_context))
        return;
      out.write("\">\r\n");
      out.write("        <script src=\"");
      if (_jspx_meth_c_url_3(_jspx_page_context))
        return;
      out.write("\" ></script>\r\n");
      out.write("        <script src=\"");
      if (_jspx_meth_c_url_4(_jspx_page_context))
        return;
      out.write("\" ></script>\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      if (_jspx_meth_c_url_5(_jspx_page_context))
        return;
      out.write("\" />\r\n");
      out.write("        <script type=\"text/javascript\" src=\"");
      if (_jspx_meth_c_url_6(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <nav>\r\n");
      out.write("        <span class=\"qt\">\r\n");
      out.write("            <span class=\"q\">Q</span>uick Test\r\n");
      out.write("        </span>\r\n");
      out.write("        \r\n");
      out.write("\t<span class=\"toggle\">\r\n");
      out.write("            <div class=\"line\"></div>\r\n");
      out.write("            <div class=\"line\"></div>\r\n");
      out.write("            <div class=\"line\"></div>\r\n");
      out.write("\t</span>\r\n");
      out.write("        \r\n");
      out.write("        <ul class=\"list-item\">\r\n");
      out.write("          ");
if( request.getSession().getAttribute("user_data") == null){
      out.write("      \r\n");
      out.write("                  <li  class=\"on-right\"><button id=\"register\" >Register</button></li>\r\n");
      out.write("          ");
}else{
      out.write(" \r\n");
      out.write("                  <li><a class=\"pro\" href=\"");
      out.print(request.getSession().getAttribute("user_data").getClass().getSimpleName());
      out.write("Dash\">Dashboard</a></li>\r\n");
      out.write("                  <li class=\"on-right\"><button><a href=\"logout\">LogOut</a></button></li>\r\n");
      out.write("          ");
}
      out.write("\r\n");
      out.write("        </ul>\r\n");
      out.write("            \r\n");
      out.write("      </nav>\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      if (_jspx_meth_c_url_7(_jspx_page_context))
        return;
      out.write("\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      if (_jspx_meth_c_url_8(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      if (_jspx_meth_c_url_9(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("\r\n");
 int time = 10;
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"row\">\r\n");
      out.write("            \r\n");
      out.write("                <div class=\"eight columns test random-class\">\r\n");
      out.write("                    <div id=\"10\" class=\"00\"></div>\r\n");
      out.write("                    <div id=\"time\">\r\n");
      out.write("                            <span id=\"hour\" class=\"num\">00</span>\r\n");
      out.write("                            <span id=\"colon\">:</span>\r\n");
      out.write("                            <span id=\"minutes\" class=\"num\">00</span>\r\n");
      out.write("                            <span id=\"colon\">:</span>\r\n");
      out.write("                            <span id=\"seconds\" class=\"num\">00</span>\r\n");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("        \r\n");
      out.write("                    <div id=\"slider\">\r\n");
      out.write("                    <a href=\"#\" class=\"control_next\"><i class=\"fa fa-chevron-right right\" style=\"font-size:60px;color:black;\"></i></a>\r\n");
      out.write("                    <a href=\"#\" class=\"control_prev\"><i class=\"fa fa-chevron-left left\" style=\"font-size:60px;color:black;\"></i></a></div>\r\n");
      out.write("            <form>\r\n");
      out.write("                <div class=\"questions\">\r\n");
      out.write("                    <div class=\"question\" style=\"display:none;\">    \r\n");
      out.write("                        <span class=\"bm bm1\" ><i class=\"fa fa-bookmark \" id=\"bm\"></i></span><br>\r\n");
      out.write("                        <div class=\"question-content\">Q1. </div>\r\n");
      out.write("                        <input type=\"radio\" name=\"option1\" value=\"a\"> a) <br>\r\n");
      out.write("                        <input type=\"radio\" name=\"option1\" value=\"b\" > b) <br>\r\n");
      out.write("                        <input type=\"radio\" name=\"option1\" value=\"c\"> c) <br>\r\n");
      out.write("                        <input type=\"radio\" name=\"option1\" value=\"d\"> d) <br>\r\n");
      out.write("                        <input type=\"radio\" name=\"option1\" value=\"e\" style=\"display:none;\" checked>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    </form>\r\n");
      out.write("                    <div class=\"question\" style=\"display:none;\">\r\n");
      out.write("                       \r\n");
      out.write("                        \r\n");
      out.write("                        <span class=\"bm bm1\" ><i class=\"fa fa-bookmark \" id=\"bm\"></i></span><br>\r\n");
      out.write("                        <div class=\"question-content\">Q2. </div>\r\n");
      out.write("                        <input type=\"radio\" name=\"option2\" value=\"a\"> a) <br>\r\n");
      out.write("                        <input type=\"radio\" name=\"option2\" value=\"b\" > b) <br>\r\n");
      out.write("                        <input type=\"radio\" name=\"option2\" value=\"c\"> c) <br>\r\n");
      out.write("                        <input type=\"radio\" name=\"option2\" value=\"d\"> d) <br>\r\n");
      out.write("                        <input type=\"radio\" name=\"option2\" value=\"e\" style=\"display:none;\" checked>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    \r\n");
      out.write("                    <div class=\"question\" style=\"display:none;\">\r\n");
      out.write("                       \r\n");
      out.write("                        \r\n");
      out.write("                        <span class=\"bm bm1\" ><i class=\"fa fa-bookmark \" id=\"bm\"></i></span><br>\r\n");
      out.write("                        <div class=\"question-content\">Q3. </div>\r\n");
      out.write("                        <input type=\"radio\" name=\"option3\" value=\"a\"> a) <br>\r\n");
      out.write("                        <input type=\"radio\" name=\"option3\" value=\"b\" > b) <br>\r\n");
      out.write("                        <input type=\"radio\" name=\"option3\" value=\"c\"> c) <br>\r\n");
      out.write("                        <input type=\"radio\" name=\"option3\" value=\"d\"> d) <br>\r\n");
      out.write("                        <input type=\"radio\" name=\"option3\" value=\"e\" style=\"display:none;\" checked>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            \r\n");
      out.write("                <div class=\"ques-iterators\">\r\n");
      out.write("                    \r\n");
      out.write("                    <div class=\"goto-ques\" style=\"text-align: center\">\r\n");
      out.write("                        <input type=\"text\" class=\"search-ques\" placeholder=\"Go to question number\">\r\n");
      out.write("                        <button id=\"search-ques-button\" type=\"button\"><i class=\"fa fa-arrow-circle-right\"></i></button>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    \r\n");
      out.write("                </div>\r\n");
      out.write("             \r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"four columns test right-side\" >\r\n");
      out.write("                    \r\n");
      out.write("                    <div class=\"another-random-class\">\r\n");
      out.write("                    \r\n");
      out.write("                        <div class=\" row answer-panel\">\r\n");
      out.write("                            <strong>NAME : </strong>AAAA AAAA <br>\r\n");
      out.write("                            <strong>ROLL NUMBER. : </strong>15/313 <br>\r\n");
      out.write("                            <strong>SEMESTER:</strong> THIRD <br>\r\n");
      out.write("                            <strong>BRANCH: </strong>CSE <br>\r\n");
      out.write("                            \r\n");
      out.write("                            \r\n");
      out.write("                           \r\n");
      out.write("                            \r\n");
      out.write("                            \r\n");
      out.write("                        </div>\r\n");
      out.write("                    \r\n");
      out.write("                       \r\n");
      out.write("                    </div>\r\n");
      out.write("                    <br>\r\n");
      out.write("                    <div class=\"side\" id=\"color_panel\">\r\n");
      out.write("                    \r\n");
      out.write("                        <strong>SUBJECT: </strong>FLAT\r\n");
      out.write("                        \r\n");
      out.write("                    </div>\r\n");
      out.write("    \r\n");
      out.write("                    <div><br><br><br>\r\n");
      out.write("                        <button id=\"submit\" class=\"on-right submit\">Submit</button>\r\n");
      out.write("                        \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
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

  private boolean _jspx_meth_c_url_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_0.setPageContext(_jspx_page_context);
    _jspx_th_c_url_0.setParent(null);
    _jspx_th_c_url_0.setValue("/assets/lib/font-awesome-4.7.0/css/font-awesome.min.css");
    int _jspx_eval_c_url_0 = _jspx_th_c_url_0.doStartTag();
    if (_jspx_th_c_url_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_0);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_0);
    return false;
  }

  private boolean _jspx_meth_c_url_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_1 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_1.setPageContext(_jspx_page_context);
    _jspx_th_c_url_1.setParent(null);
    _jspx_th_c_url_1.setValue("/assets/lib/skeleton-2.0.4/css/normalize.css");
    int _jspx_eval_c_url_1 = _jspx_th_c_url_1.doStartTag();
    if (_jspx_th_c_url_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_1);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_1);
    return false;
  }

  private boolean _jspx_meth_c_url_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_2 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_2.setPageContext(_jspx_page_context);
    _jspx_th_c_url_2.setParent(null);
    _jspx_th_c_url_2.setValue("/assets/lib/skeleton-2.0.4/css/skeleton.css");
    int _jspx_eval_c_url_2 = _jspx_th_c_url_2.doStartTag();
    if (_jspx_th_c_url_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_2);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_2);
    return false;
  }

  private boolean _jspx_meth_c_url_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_3 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_3.setPageContext(_jspx_page_context);
    _jspx_th_c_url_3.setParent(null);
    _jspx_th_c_url_3.setValue("/assets/lib/jquery/jquery-3.2.0.min.js");
    int _jspx_eval_c_url_3 = _jspx_th_c_url_3.doStartTag();
    if (_jspx_th_c_url_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_3);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_3);
    return false;
  }

  private boolean _jspx_meth_c_url_4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_4 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_4.setPageContext(_jspx_page_context);
    _jspx_th_c_url_4.setParent(null);
    _jspx_th_c_url_4.setValue("/assets/lib/jquery-ui-1.12.1/jquery-ui.min.js");
    int _jspx_eval_c_url_4 = _jspx_th_c_url_4.doStartTag();
    if (_jspx_th_c_url_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_4);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_4);
    return false;
  }

  private boolean _jspx_meth_c_url_5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_5 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_5.setPageContext(_jspx_page_context);
    _jspx_th_c_url_5.setParent(null);
    _jspx_th_c_url_5.setValue("/assets/styles/navbar_styles.css");
    int _jspx_eval_c_url_5 = _jspx_th_c_url_5.doStartTag();
    if (_jspx_th_c_url_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_5);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_5);
    return false;
  }

  private boolean _jspx_meth_c_url_6(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_6 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_6.setPageContext(_jspx_page_context);
    _jspx_th_c_url_6.setParent(null);
    _jspx_th_c_url_6.setValue("/assets/scripts/nav.js");
    int _jspx_eval_c_url_6 = _jspx_th_c_url_6.doStartTag();
    if (_jspx_th_c_url_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_6);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_6);
    return false;
  }

  private boolean _jspx_meth_c_url_7(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_7 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_7.setPageContext(_jspx_page_context);
    _jspx_th_c_url_7.setParent(null);
    _jspx_th_c_url_7.setValue("/assets/styles/test_page.css");
    int _jspx_eval_c_url_7 = _jspx_th_c_url_7.doStartTag();
    if (_jspx_th_c_url_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_7);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_7);
    return false;
  }

  private boolean _jspx_meth_c_url_8(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_8 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_8.setPageContext(_jspx_page_context);
    _jspx_th_c_url_8.setParent(null);
    _jspx_th_c_url_8.setValue("/assets/scripts/test_page.js");
    int _jspx_eval_c_url_8 = _jspx_th_c_url_8.doStartTag();
    if (_jspx_th_c_url_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_8);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_8);
    return false;
  }

  private boolean _jspx_meth_c_url_9(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_9 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_9.setPageContext(_jspx_page_context);
    _jspx_th_c_url_9.setParent(null);
    _jspx_th_c_url_9.setValue("/assets/scripts/testPageTimer.js");
    int _jspx_eval_c_url_9 = _jspx_th_c_url_9.doStartTag();
    if (_jspx_th_c_url_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_9);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_9);
    return false;
  }
}
