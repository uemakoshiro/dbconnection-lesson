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
	<h1>削除対象のproduct_idを入力してください</h1>
	<p>${ msg }</p>
	<form action="DeleteServlet" method="post">
	    product_id: <input type="text" name="id"><c:if test="${flag eq '1'}"> product_idは必須です</c:if><br>
	    <button type="submit">削除</button>
  	</form>
</div>
</body>
</html>