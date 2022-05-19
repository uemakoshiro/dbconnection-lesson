<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>result</title>
</head>
<body>
	<h1>検索結果</h1>
	<table border="1">
    <tr>
      <th>product_id</th>
      <th>product_name</th>
      <th>price</th>
    </tr>
	<c:forEach var="pro" items="${list}">
      <tr>
        <td>${fn:escapeXml(pro.getProductId())}</td>
        <td>${fn:escapeXml(pro.getProductName())}</td>
        <td>${fn:escapeXml(pro.getPrice())}</td>
      </tr>
    </c:forEach>
    </table>
	<a href="top.jsp">戻る</a>
</body>
</html>