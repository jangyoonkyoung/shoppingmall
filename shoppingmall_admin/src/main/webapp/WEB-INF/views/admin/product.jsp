<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="/assets/js/product.js"></script>
    <link rel="stylesheet" href="/assets/css/product.css">
    <style>
    #img_preview img {
        width: 200px;
    }
    </style>
</head>
<body>
    <%@include file="/WEB-INF/views/includes/admin_header.jsp"%>
    <h1 class="title">상품관리</h1>
    <div class="product_form">
        <table class="product_table">
            <tbody>
                <tr>
                    <td>상품명</td>
                    <td><input type="text" id="pi_name"></td>
                </tr>
                <tr>
                    <td>가격</td>
                    <td><input type="number" id="pi_price"></td>
                </tr>
                <tr>
                    <td>카테고리</td>
                    <td>
                        <select id="pi_cate_seq">
                            <c:forEach items="${clist}" var="cate">
                                <option value="${cate.cate_seq}">${cate.cate_name}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>재고</td>
                    <td><input type="number" id="pi_stock"></td>
                </tr>
                <tr>
                    <td>업체명</td>
                    <td>
                        <select id="pi_si_seq">
                            <option>전체</option>
                            <c:forEach items = "${slist}" var="seller">
                                <option value="${seller.si_seq}">${seller.si_name}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>할인률</td>
                    <td><input type="number" id="pi_discount_rate" min="0" max="100"></td>
                </tr>
                <tr>
                    <td>적립</td>
                    <td><input type="number" id="pi_point_rate" min="0" max="100"></td>
                </tr>
                <tr>
                    <td>주의사항</td>
                    <td>
                        <textarea id="pi_caution"></textarea>
                    </td>
                </tr>
                <tr>
                    <td>무게(g)</td>
                    <td><input type="number"id="pi_weight" min="0" ></td>
                </tr>
                <tr>
                    <td>배송사</td>
                    <td>
                        <select id="pi_di_seq">
                            <c:forEach items = "${dlist}" var="delivery">
                                <option value="${delivery.di_seq}">${delivery.di_name}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>이미지</td>
                    <td class="img_form_td" colspan="4">
                        <span id="img_preview">
                            
                        </span>
                        <form id="image_form">
                            <input type = "file" accept="image/gif, image/jpeg, image/png" name="file" value="제품이미지 선택">
                            <button type= "button" id="img_save">등록</button>
                            <button type= "button" id="img_delete" disabled>삭제</button>
                        </form>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <button id="save">등록</button>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
    <div class="product_list list">
        <div class="search_area">
            <span>카테고리</span>
            <select id="cate_search">
                <option>전체</option>
                <c:forEach items="${clist}" var="cate">
                    <option value="${cate.cate_seq}">${cate.cate_name}</option>
                </c:forEach>
            </select>
            <input type="text" id="search_keyword" placeholder="제품명검색">
            <button id="search">검색</button>
        </div>
    <table id="product_list_table">
        <thead>
            <tr>
                <td>번호</td>
                <td>제품명</td>
                <td>제품이미지</td>
                <td>카테고리</td>
                <td>재고</td>
                <td>업체명</td>
                <td>등록일</td>
                <td>할인율</td>
                <td>적립률</td>
                <td>주의사항</td>
                <td>무게</td>
                <td>배송사</td>
                <td>가격</td>
                <td></td>
            </tr>
        </thead>
        <tbody id="product_tbody">
        </tbody>
    </table>
</body>
</html>    