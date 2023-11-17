<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2023-11-16
  Time: 오후 1:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="/css/boardview.css">
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판 조회</title>
</head>
<body>
<h1>조회</h1>
<div class="form-container">
<table>
    <tr>
        <th>구분</th>
        <td>${form.division}</td>
    </tr>
    <tr>
        <th>작성자</th>
        <td>${form.username}</td>
    </tr>
    <tr>
        <th>분류</th>
        <td>${form.classification}</td>
    </tr>
    <tr>
        <th>고객유형</th>
        <td>${form.usertype}</td>
    </tr>
    <tr>
        <th>제목</th>
        <td>${form.title}</td>
    </tr>
    <tr>
        <th>내용</th>
        <td>${form.content}</td>
    </tr>
    <tr>
        <th>첨부파일</th>
        <td>${form.path}</td>
    </tr>
</table>
</div>
</body>
</html>
