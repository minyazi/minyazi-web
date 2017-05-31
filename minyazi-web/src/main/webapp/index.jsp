<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    String title = "JSP模板";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <base href="<%=basePath%>" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title><%=title%></title>
        <!--
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <script type="text/javascript" src="js/jquery-1.8.0.js"></script>
        <script type="text/javascript"></script>
        -->
    </head>
    <body>
        <h1>JSP模板</h1>
    </body>
</html>
