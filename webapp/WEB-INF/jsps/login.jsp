<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta name="viewpoint" content="width=device-width, initial-scale=1">
    <title>Login - Inspiration</title>
  </head>
  <body>
    <form action="<c:url value='j_spring_security_check' />" method="POST">
              用户名：<input type="text" name="j_username">
	  密　码：<input type="text" name="j_password">
	 <input type="submit" name="submit" value="提交">
	 <input type="reset" value="清空">
	</form>
  </body>
</html>