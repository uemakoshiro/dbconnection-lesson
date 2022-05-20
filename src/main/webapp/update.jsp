<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java 演習問題15</title>
<style>
.waku {
	border-width: 2px;
	border-color: blue;
}
</style>
</head>
<body>
<div class = "waku">
	<h1>更新する情報を入力してください</h1>
	<p>${ msg }</p>
	<form action="UpdateServlet" method="post">
		product_id: <input type="number" name="id" value="${fn:escapeXml(param.id)}"><c:if test="${flag eq '100' || flag eq '101' || flag eq '110' || flag eq '111'}"> product_idは必須です</c:if><br>
	    product_name: <input type="text" name="name" value="${fn:escapeXml(param.name)}"><c:if test="${flag eq '10' || flag eq '11' || flag eq '110' || flag eq '111'}"> product_nameは必須です</c:if><br>
	    price: <input type="number" name="price" value="${fn:escapeXml(param.price)}"><c:if test="${flag eq '1' || flag eq '11' || flag eq '101' || flag eq '111'}"> priceは必須です</c:if><br>
	    <button type="submit">更新</button>
  	</form>
</div>
</body>
</html>