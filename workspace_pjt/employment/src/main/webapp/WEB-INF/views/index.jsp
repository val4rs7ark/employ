<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Hello Security</title>
    <c:url var="faviconUrl" value="/resources/favicon.ico"/>
    <link rel="icon" type="image/x-icon" href="${faviconUrl}"/>
    <c:url var="bootstrapUrl" value="/resources/bootstrap.css"/>
    <link href="${bootstrapUrl}" rel="stylesheet"></link>
    <c:url var="bootstrapResponsiveUrl" value="/resources/bootstrap-responsive.css"/>
    <link href="${bootstrapResponsiveUrl}" rel="stylesheet"></link>
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="https://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
  </head>

  <body>
  
    <div class="container">
      <h1>This is secured!</h1>
      <p>
        Hello <b><c:out value="${pageContext.request.remoteUser}"/><c:out value="${errormsg}"/></b>
      </p>
      <c:url var="logoutUrl" value="/logout"/>
      <form class="form-inline" action="${logoutUrl}" method="post">
          <input type="submit" value="Log out" />
          <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
      </form>
    </div>
    
  </body>
</html>
