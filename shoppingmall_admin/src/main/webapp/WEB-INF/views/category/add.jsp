<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>카테고리</title>
    <link rel="stylesheet" href="/assets/css/reset.css">
    <link rel="stylesheet" href="/assets/css/category.css">
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="/assets/js/category.js"></script>
</head>
<body>
    <%@include file="/WEB-INF/views/includes/header.jsp"%>
    <div class="container">
        <h1>카테고리 추가</h1>
        <div class="cate_wrap">
            <input type="text" id="cate_name">
            <button id="add">추가</button>
        </div>
        <div id="cate_list">
            <table id="cate_table">
                <thead>
                    <tr data-seq='${list.seq}'>
                        <td>번호</td>
                        <td>이름</td>
                    </tr>
                </thead>
                <tbody id="cate_table_body">
                    
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>    