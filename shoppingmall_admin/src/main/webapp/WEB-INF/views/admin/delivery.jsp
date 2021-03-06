<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>배송사 </title>
    <link rel="stylesheet" href="/assets/css/reset.css">
    <link rel="stylesheet" href="/assets/css/delivery.css">
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="/assets/js/delivery.js"></script>
</head>

<body>
    <%@include file="/WEB-INF/views/includes/admin_header.jsp"%>
    <h1 class="title">배송사 관리 페이지</h1>
    <table class="del_table">
        <tbody>
            <tr>
                <td>배송사명</td>
                <td><input type="text" id="di_name"></td>
                <td><button type="button" id="dup_check_name">중복체크</button></td>
            </tr>
            <tr>
                <td>전화번호</td>
                <td><input type="text" id="di_phone"></td>
            </tr>
            <tr>
                <td>배달비</td>
                <td><input type="number" id="di_price">원</td>
            </tr>
            <tr>
                <td colspan="2">
                    <button id="add">등록</button>
                </td>
            </tr>
        </tbody>
    </table>
    <div class="delivery_list">
        <table class="delivery_table">
            <thead class="delivery_thead">
                <tr>
                    <td>번호</td>
                    <td>배송사</td>
                    <td>전화번호</td>
                    <td>비용</td>
                    <td></td>
                </tr>
            </thead>
            <tbody class="delivery_tbody">
                
            </tbody>

        </table>

    </div>
</body>

</html>