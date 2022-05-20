<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>完了画面</title>
</head>
<body>
	<h1>更新完了</h1>
	【更新前】<br>
	product_id:${before.getProductId()}<br>
	product_name:${before.getProductName()}<br>
	price:${before.getPrice()}<br>
	【更新後】<br>
	product_id:${after.getProductId()}<br>
	product_name:${after.getProductName()}<br>
	price:${after.getPrice()}<br>
	<p><a href="update.jsp">戻る</a></p>
</body>
</html>