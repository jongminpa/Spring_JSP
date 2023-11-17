<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2023-11-16
  Time: 오후 1:43
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시판</title>
    <link rel="stylesheet" type="text/css" href="/css/boardlist.css">
</head>
<body>
<div id="board-container">
    <h1>목록</h1>
    <div id="search-section">
        <!-- 검색 폼 -->
        <form action="search" method="get">
            제목: <input type="text" name="title">
            작성자: <input type="text" name="author">
            작성일: <input type="text" name="startDate"> ~ <input type="text" name="endDate">
            <input type="submit" value="검색">
        </form>
    </div>
    <div id="board-list">
        <table>
            <thead>
            <tr>
                <th class = "col1">번호</th>
                <th class = "col2">구분</th>
                <th class = "col3">제목</th>
                <th class = "col4">첨부</th>
                <th class = "col5">작성일</th>
                <th class = "col6">작성자</th>
                <th class = "col7">조회수</th>
            </tr>
            </thead>
            <tbody>
            <!-- 게시글 목록 반복 -->
            <c:forEach items="${boards}" var="board">
                <tr>
                    <td class = "col1">${board.id}</td>
                    <td class = "col2">${board.division}</td>
                    <td class = "col3" onclick = "location.href = '/board/${board.id}/show' ">${board.title}</td>
                    <td class = "col4">${board.filePath ? "첨부" : ""}</td>
                    <td class = "col5">${board.createdAt}</td>
                    <td class = "col6">${board.userName}</td>
                    <td class = "col7">${board.click}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div id="pagination">
        <!-- 페이징 처리 -->
        <c:if test="${totalPages > 1}">
            <a href="?page=1"><<</a>
            <c:forEach begin="1" end="${totalPages}" var="pageNum">
                <a href="?page=${pageNum}">${pageNum}</a>
            </c:forEach>
            <a href="?page=${totalPages}">>></a>
        </c:if>
    </div>
    <div>
        <input type = "button" value = "글등록" onclick = "location.href = '/create'">
    </div>
</div>
</body>
</html>
