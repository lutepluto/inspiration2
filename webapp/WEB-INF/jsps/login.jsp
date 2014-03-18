<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
  	
  	<fmt:setBundle basename="ApplicationMessage" />
  	<fmt:setLocale value="zh_CN"/>
  
    <meta charset="utf-8">
    <meta name="viewpoint" content="width=device-width, initial-scale=1">
    <title>Login - Inspiration</title>
  </head>
  <body>
  
  	<c:if test="${not empty errorMessage}">
  		<fmt:message key="${errorMessage}" />
  	</c:if>
  	
    <form action="<c:url value='j_spring_security_check' />" method="POST">
              用户名：<input type="text" name="j_username">
	  密　码：<input type="password" name="j_password">
	 <input type="submit" name="submit" value="提交">
	 <input type="reset" value="清空">
	</form>
  </body>
</html>