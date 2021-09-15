$(function(){

    getProduct();

    $("#save").click(function(){
        let pi_name = $("#pi_name").val();
        let pi_price = $("#pi_price").val();
        let pi_cate_seq= $("#pi_cate_seq option:selected").val();
        let pi_stock= $("#pi_stock").val();
        let pi_si_seq = $("#pi_si_seq option:selected").val();
        let pi_discount_rate = $("#pi_discount_rate").val();
        let pi_caution= $("#pi_caution").val();
        let pi_weight= $("#pi_weight").val();
        let pi_point_rate= $("#pi_point_rate").val();
        let pi_di_seq= $("#pi_di_seq").val();

        if(pi_name == null || pi_name == "" || pi_name == undefined){
            alert("상품명을 입력하세요.")
            return;
        }
        if(pi_price == null || pi_price == "" || pi_price == undefined){
            alert("가격을 입력하세요.")
            return;
        }
        if(pi_cate_seq == null || pi_cate_seq == "" || pi_cate_seq == undefined){
            alert("카테고리를 선택하세요.")
            return;
        }
        if(pi_stock == null || pi_stock == "" || pi_stock == undefined){
            alert("재고를 입력하세요.")
            return;
        }
        if(pi_si_seq == null || pi_si_seq == "" || pi_si_seq == undefined){
            alert("판매자를 입력하세요.")
            return;
        }
        if(pi_discount_rate == null || pi_discount_rate == "" || pi_discount_rate == undefined){
            alert("할인률을 입력하세요.")
            return;
        }
        if(pi_point_rate == null || pi_point_rate == "" || pi_point_rate == undefined){
            alert("적립률을 입력하세요.")
            return;
        }
        if(pi_weight == null || pi_weight == "" || pi_weight == undefined){
            alert("무게을 입력하세요.")
            return;
        }
        if(pi_di_seq == null || pi_di_seq == "" || pi_di_seq == undefined){
            alert("배송사를 입력하세요.")
            return;
        }
        let data = {
            pi_name: pi_name,
            pi_price: pi_price,
            pi_cate_seq: pi_cate_seq,
            pi_stock: pi_stock,
            pi_si_seq: pi_si_seq,
            pi_discount_rate: pi_discount_rate,
            pi_caution: pi_caution,
            pi_weight: pi_weight,
            pi_point_rate: pi_point_rate,
            pi_di_seq: pi_di_seq
        }   
        $.ajax({
            type:"post",
            url:"/product/add",
            data:JSON.stringify(data),
            contentType:"application/json",
            success:function(r){
                alert(r.message);
                location.reload();
            }
        })
    });

    function getProduct(keyword, cate_seq, offset){
        let url = "/product/list";
        if(keyword == undefined || keyword == null) {
            keyword = "";
        }
        url += "?keyword="+keyword
        if(cate_seq != undefined && cate_seq != null) {
            url += "&category="+cate_seq;
        }
        if(offset != undefined && offset != null) {
            url += "&offset="+offset;
        }
    $.ajax({
        type:"get",
        url:url,
        success:function(r){
            for(let i=0; i<r.data.length; i++){
                // console.log(r.data.length);
                let tag =
                '<tr>'+
                '<td>'+(i+1)+'</td>'+
                '<td>'+r.data[i].pi_name+'</td>'+
                '<td>'+r.data[i].category_name+'</td>'+
                '<td>'+r.data[i].pi_stock+'</td>'+
                '<td>'+r.data[i].seller_name+'</td>'+
                '<td>'+ makeDate(new Date(r.data[i].pi_create_dt))+'</td>'+
                '<td>'+r.data[i].pi_discount_rate+'</td>'+
                '<td>'+r.data[i].pi_point_rate+'</td>'+
                '<td>'+r.data[i].pi_caution+'</td>'+
                '<td>'+r.data[i].pi_weight+'</td>'+
                '<td>'+r.data[i].delivery_name+'</td>'+
                '<td>'+r.data[i].pi_price+'</td>'+
                '<td>'+
                '<button class="product_delete" data-seq="'+r.data[i].pi_seq+'">삭제</button>'+
                '</td>'+
            '</tr>'
            $("#product_tbody").append(tag);
            }
            $(".product_delete").click(function(){
                if(!confirm("삭제 하시겠습니까?")) return;
                let seq = $(this).attr("data-seq");
                $.ajax({
                    type:"delete",
                    url:"/delete/product?seq="+seq,
                    success:function(r){
                        console.log(r);
                        alert(r.message);
                        location.reload();
                    }
                })
            })
        }
    })
    }
    // $("#search").change(function(){
    //     alert("변경");
    // })
})
function makeDate(dt) {
    return dt.getFullYear() + "-" + leadingZero(dt.getMonth() + 1) + "-" + leadingZero(dt.getDate());
}
function leadingZero(n) {
    return n < 10 ? "0" + n : "" + n;
}