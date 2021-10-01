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
    <title>마켓컬리:: 내일의 장보기, 마켓컬리</title>
    <link rel="stylesheet" href="/assets/css/reset.css">
    <link rel="stylesheet" href="/assets/css/market_header.css">
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="/assets/js/header.js"></script>
    
</head>
<body>
    <header>
        <div class="header_top">
            <div class="container">
                <p>지금 가입하고 인기상품 <b>100원</b>에 받아가세요</p>
                <a href = "#">
                    <img src = "/assets/images/ico_close_999_32x32.png">
                </a>
            </div>
        </div>
            <div class="header_content">
                <div class="hc_top">
                    <a href="#" id="delivery">
                        <img src = "/assets/images/샛별_ 택배 배송안내.png">
                    </a>
                <div class="user_menu">
                    <a href ="#">로그인</a>
                    <span>|</span>
                    <a href ="/member">회원가입</a>
                    <span>|</span>
                    <a href ="#">고객선터<img src = "/assets/images/ico_quick_down_hover.png"></a>
                    <span>|</span>
                    <a href="/admin">관리자 페이지</a>
                </div>
            </div>
            <div class="hc_mid">
                <a href="/" id="logo">
                <img src ="/assets/images/마켓컬리 로고.png"></a>
            </div>
            <div class="hc_bot">
                <div class="main_menu">
                    <a href= "#" id="cate_all">전체 카테고리</a>
                    <a href = "#">신상품</a>
                    <a href = "#">베스트</a>
                    <a href = "#">알뜰쇼핑</a>
                    <a href = "#">특가 / 세일</a>
                </div>
                
                <div class="search_area">
                    <div class="search_box">
                        <input type="text" id="keyword">
                        <button id="search_btn">
                            <img src = "/assets/images/ico_search_x2.png">
                        </button>
                    </div>
                    <a href="#">
                        <img src = "/assets/images/ico_delivery_setting.svg">
                    </a>
                    <a href="#">
                        <img src = "/assets/images/ico_cart.svg">
                    </a>
                </div>
            </div>  
            <div class="categoryList">
                <div class="cate_list">
                    <c:forEach items="${cateList}" var="cate">
                        <a href = "#">${cate.cate_name}</a>
                    </c:forEach>   
                </div>
            </div>
            
        </div>
        
    </header>
</body>
</html>    