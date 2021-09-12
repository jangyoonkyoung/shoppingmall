<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/assets/css/reset.css">
    <link rel="stylesheet" href="/assets/css/header.css">
</head>
<body>
    <header>
        <div class="header">
            <ul class="left_menu">
                <li>
                    <a href="/category/add">카테고리 추가</a>
                </li>
                <li>
                    <a href="/delivery/add">배송사 추가</a>
                </li>
                <li>
                    <a href="/seller/regist">판매자 추가</a>
                </li>
                <!-- <li>
                    <a href="#">oooo</a>
                </li> -->
            </ul>
            <a href="/" id="logo">
                <img src="/assets/images/logo_x2.png">
            </a>
            <ul class="right_menu">
                <li>
                    <a href="#">@</a>
                </li>
                <li>
                    <a href="#">@</a>
                </li>
                <li>
                    <a href="#">@</a>
                </li>
                <li>
                    <a href="#">@</a>
                </li>
            </ul>
        </div>
    </header>
</body>
</html>    