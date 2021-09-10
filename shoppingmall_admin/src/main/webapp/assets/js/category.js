$(function(){
    $("#add").click(function(){
        let cate_name = $("#cate_name").val();
        if(cate_name == '' || cate_name == null || cate_name==undefined){
            alert("카테고리 명을 입력하세요");
            return;
        }
        let data = {
            cate_name : cate_name
        }
        $.ajax({
            type:"post",
            url:"/add/category",
            data:JSON.stringify(data),
            contentType:"application/json",
            success:function(r){
                console.log(r);
                alert(r.message);
            }
        })
    })
})