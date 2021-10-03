<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="/assets/js/recommand.js"></script>
    <link rel="stylesheet" href="/assets/css/recommand.css">
</head>
<body>
    <%@include file="/WEB-INF/views/includes/admin_header.jsp"%>
    <h1 class="title">상품추천</h1>
    <div class="recommand_area">
        <button id="add_recommand_button">추천 상품 추가</button>
    </div>
    <div class="container">
        <table class="recommand_table">
            <thead class="recommand_thead">
                <tr>
                    <td>번호</td>
                    <td>제품명</td>
                    <td>이미지</td>
                    <td>카테고리</td>
                    <td>업체명</td>
                    <td></td>
                </tr>
            </thead>
            <tbody class="recommand_tbody">

            </tbody>
        </table>
    </div>
    <div class="add_recommand">
        <div class="add_recommand_wrap">
            <h1 class="pop_title">추천상품 추가</h1>
            <button class="close">닫기</button>
            <table class="add_recommand_tbody">
                <thead>
                    <tr>
                        <td>번호</td>
                        <td>제품명</td>
                        <td>제품이미지</td>
                        <td>카테고리</td>
                        <td>업체명</td>
                        <td></td>
                    </tr>
                </thead>
                <tbody class="not_recommand_list">

                </tbody>
            </table>
        </div>
    </div>
</body>
</html>    