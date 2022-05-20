<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<h1>検索条件または登録情報を入力してください</h1>
	<p>${ msg }</p>
	<form action="SearchServlet" method="post">
	    product_name: <input type="text" name="name"><c:if test="${flag eq '10' || flag eq '11'}"> product_nameは必須です</c:if><br>
	    price: <input type="number" name="price"><c:if test="${flag eq '1' || flag eq '11'}"> priceは必須です</c:if><br>
	    <button type="submit" name="btn" value="search">検索</button>
	    <button type="submit" name="btn" value="register">登録</button>
  	</form>
</div>
</body>
</html>