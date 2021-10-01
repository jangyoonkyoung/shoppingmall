<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>판매자 페이지</title>
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="/assets/js/seller.js"></script>
</head>
<body>
    <%@include file="/WEB-INF/views/includes/admin_header.jsp"%>
    <div>
        <table>
            <tbody>
                <tr>
                    <td>아이디</td>
                    <td><input type="text" id="seller_id"></td>
                    <td><button type="button" id="dup_check">중복체크</button></td>
                </tr>
                <tr>
                    <td>비밀번호</td>
                    <td><input type="password" id="seller_pwd"></td>
                </tr>
                <tr>
                    <td>비밀번호 확인</td>
                    <td><input type="password" id="seller_pwd_con"></td>
                </tr>
                <tr>
                    <td>판매자명</td>
                    <td><input type="text" id="seller_name"></td>
                </tr>
                <tr>
                    <td>이메일</td>
                    <td><input type="text" id="seller_email"></td>
                    <td><button type="button" id="dup_check_Email">중복체크</button></td>
                </tr>
                <tr>
                    <td>전화번호</td>
                    <td><input type="text" id="seller_phone"></td>
                </tr>
                <tr>
                    <td><button id="regist">등록하기</button></td>
                </tr>
            </tbody>
        </table>
        <div class="seller_list">
            <table class="seller_table">
                <thead>
                    <tr>
                        <td>번호</td>
                        <td>아이디</td>
                        <td>판매자명</td>
                        <td>이메일</td>
                        <td>전화번호</td>
                        <td>등급</td>
                    </tr>
                </thead>
                <tbody class="seller_tbody">

                </tbody>
            </table>
        </div>
    </div>
</body>
</html>    