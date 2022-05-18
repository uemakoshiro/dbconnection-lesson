<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>result</title>
</head>
<body>
	<h1>検索結果</h1>
	<p>データを取得しました</p>
	<p>
	product_id:${product.getProductId()}<br>
	product_name:${product.getProductName()}<br>
	price:${product.getPrice()}<br></p>
	<a href="top.jsp">戻る</a>
</body>
</html>