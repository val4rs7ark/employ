/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.47
 * Generated at: 2020-02-03 03:46:56 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class boardDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/jstl-jstl-1.2.jar", Long.valueOf(1576677787597L));
    _jspx_dependants.put("jar:file:/D:/Java/workspace_pjt/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/employment/WEB-INF/lib/jstl-jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/js/ckeditor/ckeditor.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<div class=\"form-group col-md-12\" data-ng-app=\"angularApp\" data-ng-controller=\"angularCtrl\" data-ng-init=\"getBoardDetailInit()\" data-ng-class=\"{loading:IsLoading}\">\r\n");
      out.write("   \t<div class=\"form-group col-md-12 pickBorder\">\r\n");
      out.write("   \t\t<div class=\"row\">\r\n");
      out.write("   \t\t\t<div class=\"col-md-12\" data-ng-bind=\"boardDetailMap.BOARD_TITLE\"></div>\r\n");
      out.write("   \t\t</div>\r\n");
      out.write("   \t\t<hr class=\"my-2\">\r\n");
      out.write("   \t\t<div class=\"row\">\r\n");
      out.write("\t  \t\t<div class=\"col-md-2\" data-ng-bind=\"boardDetailMap.BOARD_WRITER\"></div>\r\n");
      out.write("\t  \t\t<div class=\"col-md-6\"></div>\r\n");
      out.write("\t  \t\t<div class=\"col-md-2\" data-ng-bind=\"boardDetailMap.BOARD_DATE\"></div>\r\n");
      out.write("\t  \t\t<div class=\"col-md-1\" align=\"right\">조회</div>\r\n");
      out.write("\t  \t\t<div class=\"col-md-1\" data-ng-bind=\"boardDetailMap.BOARD_HIT\"></div>\r\n");
      out.write("  \t\t</div>\r\n");
      out.write("   \t</div>\r\n");
      out.write("    <div class=\"form-group pickBorder\">\r\n");
      out.write("        <div class=\"col-md-12\" data-ng-bind-html=\"boardDetailMap.BOARD_CONTENT\" style=\"min-height : 250px;\"></div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"form-group pickBorder\">\r\n");
      out.write("    \t<div class=\"row\">\r\n");
      out.write("    \t\t<ul class=\"col-md-12 comment_ul\" data-ng-repeat=\"list in boardCommentList\">\r\n");
      out.write("\t\t\t\t<li class=\"col-md-12\" data-ng-init=\"replyForm(list,$index)\">\r\n");
      out.write("\t\t\t\t\t<div class=\"row\" data-ng-style=\"replyStyle[$index]\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"col-md-1\"  data-ng-bind-html=\"list.BOARD_WRITER\"></span>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-md-9 comment_content\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span data-ng-bind=\"replyMark[$index]\" style=\"color : blue; margin-right : 5px;\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span data-ng-click=\"btn_selectComment($index)\" data-ng-bind-html=\"list.BOARD_CONTENT\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<span class=\"col-md-2\"  data-ng-bind-html=\"list.BOARD_DATE\"></span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div><hr class=\"my-2\"></div>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("   \t\t\t\t<li class=\"row reply_box\" data-ng-if=\"replyYn[$index]\" data-ng-init=\"replyOnload()\">\r\n");
      out.write("   \t\t\t\t\t<div class=\"col-md-10\">\r\n");
      out.write("   \t\t\t\t\t\t<textarea id=\"reply_content\" maxlength=\"400\" placeholder=\"댓글을 입력하세요.\"></textarea>\r\n");
      out.write("   \t\t\t\t\t</div>\r\n");
      out.write("   \t\t\t\t\t<div class=\"col-md-2\" style=\"align-self: flex-end;\">\r\n");
      out.write("   \t\t\t\t\t\t<button type=\"button\" style=\"margin-top : 5px;\" class=\"btn btn-secondary\" data-ng-click=\"btn_insertReply('");
      if (_jspx_meth_c_005fout_005f0(_jspx_page_context))
        return;
      out.write("',list)\">댓글등록</button>\r\n");
      out.write("   \t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("   \t\t\t</ul>\r\n");
      out.write("\r\n");
      out.write("\t    \t<div class=\"col-md-10\"><textarea class=\"col-md-12\" id=\"comment_content\" maxlength=\"400\" placeholder=\"댓글을 입력하세요.\"></textarea></div>\r\n");
      out.write("\t        <div class=\"col-md-2\" align=\"justify\">\r\n");
      out.write("\t            <button type=\"button\" style=\"margin-top : 5px;\" class=\"btn btn-secondary\" data-ng-click=\"btn_insertComment('");
      if (_jspx_meth_c_005fout_005f1(_jspx_page_context))
        return;
      out.write("')\">댓글등록</button>\r\n");
      out.write("\t            <button type=\"button\" style=\"margin-top : 5px;\" class=\"btn btn-secondary\" data-ng-click=\"btn_pageBack()\">이전으로</button>\r\n");
      out.write("\t        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("    <div class=\"loadingModal\"></div>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("    $(function(){\r\n");
      out.write("    \tvar comment_editor = CKEDITOR.replace( 'comment_content', {//해당 이름으로 된 textarea에 에디터를 적용\r\n");
      out.write("        \ttoolbar : [],\r\n");
      out.write("            width:'100%',\r\n");
      out.write("            height: '80px',\r\n");
      out.write("            extraPlugins : 'confighelper'\r\n");
      out.write("        });\r\n");
      out.write("    \tCKEDITOR.instances.comment_content.on('instanceReady',function(){\r\n");
      out.write("    \t});\r\n");
      out.write("    \tcomment_editor.on(\"key\",function(e){\r\n");
      out.write("        \tvar keyCode = e.data.keyCode;\r\n");
      out.write("        \t// Filter movement keys and related\r\n");
      out.write("\t\t\tif ( keyCode == 46 ||keyCode == 8 || keyCode == 2228240 ||  \r\n");
      out.write("\t\t\t\t keyCode == 1114129 || keyCode == 4456466){}else{\r\n");
      out.write("\t\t\t\t var txt= comment_editor.getData();\r\n");
      out.write("\t            if (txt.length > 50){\r\n");
      out.write("\t            \talert(\"댓글길이 최대치입니다.\");\r\n");
      out.write("\t            \tcomment_editor.setData(txt);\r\n");
      out.write("\t            }\r\n");
      out.write("\t\t\t}\r\n");
      out.write("       \t})\r\n");
      out.write("    });\r\n");
      out.write("</script>\r\n");
      out.write("</div>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fout_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    boolean _jspx_th_c_005fout_005f0_reused = false;
    try {
      _jspx_th_c_005fout_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fout_005f0.setParent(null);
      // /WEB-INF/views/boardDetail.jsp(45,115) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fout_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.remoteUser}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      int _jspx_eval_c_005fout_005f0 = _jspx_th_c_005fout_005f0.doStartTag();
      if (_jspx_th_c_005fout_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
      _jspx_th_c_005fout_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fout_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fout_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f1 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    boolean _jspx_th_c_005fout_005f1_reused = false;
    try {
      _jspx_th_c_005fout_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fout_005f1.setParent(null);
      // /WEB-INF/views/boardDetail.jsp(52,121) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fout_005f1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.remoteUser}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      int _jspx_eval_c_005fout_005f1 = _jspx_th_c_005fout_005f1.doStartTag();
      if (_jspx_th_c_005fout_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f1);
      _jspx_th_c_005fout_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fout_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fout_005f1_reused);
    }
    return false;
  }
}
