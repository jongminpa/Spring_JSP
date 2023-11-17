<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2023-11-16
  Time: 오후 1:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="css/boardview.css">
<html>
<head>
    <title>게시판 등록</title>
    <script>
        function vaildationForm(){
            var division = document.forms["create"]["division"].value;
            var username = document.forms["create"]["username"].value;
            var classification = document.forms["create"]["classification"].value;
            var title = document.forms["create"]["title"].value;

            var errors = "";
            if(division == "" || username == "" || classification == "" || title == ""){
                errors += "필수 입력 란이 공란 입니다. 입력해주세요.\n"
            }
            if(username != "" && username.length > 15){
                errors += "이름은 15글자를 초과할 수 없습니다.\n";
            }
            if(title != "" && title.length > 100){
                errors += "제목은 100글자를 초과할 수 없습니다.\n";
            }
            if(errors){
                alert(errors);
                return false;
            }
            alert("저장에 성공하였습니다.")
            return true;
        }
    </script>
</head>
<body>
<div class="form-container">
    <h1>등록</h1>
    <form name = "create" action = "/create" method = "post" onsubmit = "return vaildationForm()">
        <table>
        <tr>
            <th>구분(필수)</th>
            <td>
                <select class="select1" name = "division">
                    <option value = "" selected disabled>선택해주세요</option>
                    <option value = "유지보수">유지보수</option>
                    <option value = "문의사항">문의사항</option>
                </select>
            </td>
        </tr>
        <tr>
            <th>작성자(필수)</th>
            <td>
                <input class = "input1" name = "username" type = "text">
            </td>
        </tr>
        <tr>
            <th>분류(필수)</th>
            <td>
                <input type = "radio" id = "option1" name = "classification" value="홈페이지">
                <label for = "option1">홈페이지</label>
                <input type = "radio" id = "option2" name = "classification" value="네트워크">
                <label for = "option2">네트워크</label>
                <input type = "radio" id = "option3" name = "classification" value="서버">
                <label for = "option3">서버</label>
            </td>
        </tr>
        <tr>
            <th>고객유형</th>
            <td>
                <input type = "checkbox" id = "usertype1" name = "usertype[]" value = "호스팅">
                <label for = "usertype1">호스팅</label>

                <input type = "checkbox" id = "usertype2" name = "usertype[]" value = "유지보수">
                <label for = "usertype2">유지보수</label>

                <input type = "checkbox" id = "usertype3" name = "usertype[]" value = "서버임대">
                <label for = "usertype3">서버임대</label>

                <input type = "checkbox" id = "usertype4" name = "usertype[]" value = "기타">
                <label for = "usertype4">기타</label>
            </td>
        </tr>
        <tr>
            <th>제목(필수)</th>
            <td>
                <input class = "input2" name = "title" type = "text">
            </td>
        </tr>
        <tr>
            <th>내용(필수)</th>
            <td>
                <textarea name = "content" cols = "10" rows = "10"></textarea>
            </td>
        </tr>
        <tr>
            <th>첨부파일</th>
            <td>
                <input type = "text" id = "filename" placeholder="선택된 파일 없음" readonly>
                <input type = "file" name = "path" value="찾아 보기">
            </td>
        </tr>
        </table>
        <div class = submit-buttons>
            <input type = "submit" value = "저장">
            <input type = "button" value = "취소" onclick = "location.href = '/' ">
        </div>
    </form>
</div>
</body>
</html>
