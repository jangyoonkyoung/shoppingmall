$(function(){
    $("#cate_all, .categoryList").mouseover(function(){
        $(".categoryList").css("display","block");
    });
    $("#cate_all, .categoryList").mouseout(function(){
        $(".categoryList").css("display", "");
    });
    
})