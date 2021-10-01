$(function(){
    $("#cate_all, .categoryList").mouseover(function(){
        $(".categoryList").css("display","block");
    });
    $("#cate_all, .categoryList").mouseout(function(){
        $(".categoryList").css("display", "");
    });

    $("#logout").click(function(){
        if(confirm("로그아웃 하시겠습니까?")){
            location.href="/logout";
        }
    })
})