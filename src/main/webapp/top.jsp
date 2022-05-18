<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java 演習問題14 基本</title>
<style>
.waku {
	border-width: 2px;
	border-color: blue;
}
</style>
</head>
<body>
<div class = "waku">
	<h1>検索条件を入力してください</h1>
	<p>${ msg }</p>
	<form action="SearchServlet" method="post">
	    product_id: <input type="text" name="id"><br>
	    <button type="submit">検索</button>
  	</form>
</div>
</body>
</html>