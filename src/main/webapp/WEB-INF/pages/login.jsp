<%--
  Created by IntelliJ IDEA.
  User: zhy53
  Date: 2018/8/3
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    // request/setCharacterEncoding("UTF-8");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html">
    <title>Shiro登录</title>
</head>
<body>
    <form action="/loginUrl.action" method="post">
        用户名：<<input type="text" name="mid" id="mid"><br>
        密码：<<input type="password" name="password" id="password">
        <input type="submit" value="登录">
    </form>
</body>
</html>
