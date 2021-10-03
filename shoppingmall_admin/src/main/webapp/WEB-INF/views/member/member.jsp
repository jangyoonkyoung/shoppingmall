<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원정보:: 조회 및 삭제</title>
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="/assets/js/member.js"></script> 
    <link rel="stylesheet" href="/assets/css/member.css">
</head>
<body>
    <%@include file="/WEB-INF/views/includes/admin_header.jsp"%>
    <h1 class="title">회원 관리</h1>
    <div>
        <table class="member_list">
            <thead>
                <tr>
                    <td>번호</td>
                    <td>아이디</td>
                    <td>이름</td>
                    <td>이메일</td>
                    <td>주소</td>
                    <td>생일</td>
                    <td>성별</td>
                    <td>전화번호</td>
                    <td>회원등급</td>
                    <td>포인트</td>
                    <td>계정상태</td>
                    <td></td>
                </tr>
            </thead>
            <tbody id="member_list_body">

            </tbody>
        </table>
    </div>
</body>

</html>    