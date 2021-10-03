$(function(){

    loadRecommand();

    function loadRecommand(){
    $(".recommand_tbody").html("")
    $.ajax({
        type:"get",
        url:"/api/recommand",
        success:function(r){
            for(let i=0; i<r.list.length; i++){
                let tag = 
                    '<tr>'+
                        '<td>'+(i+1)+'</td>'+
                        '<td>'+r.list[i].pi_name+'</td>'+
                        '<td><img src="/image/'+r.list[i].pi_img_uri+'"></td>'+
                        '<td>'+r.list[i].category_name+'</td>'+
                        '<td>'+r.list[i].seller_name+'</td>'+
                        '<td><button class="delete" data-seq="'+r.list[i].pi_seq+'">삭제</button></td>'+
                    '</tr>';
                $(".recommand_tbody").append(tag);    
            }
            $(".delete").click(function(){
                if(confirm("삭제하시겠습니까?")){
                    $.ajax({
                        type:"delete",
                        url:"/api/deleteRecommand?prod_seq="+$(this).attr("data-seq"),
                        success:function(r){
                            alert(r.message);
                            location.reload();
                            loadRecommand();
                        }
                    })
                }
            })
        }
    })
    }

    $(".close").click(function(){
        $(".add_recommand").hide();
    })

    $("#add_recommand_button").click(function(){
        $(".add_recommand").show();
        loadNotRecommand();
    })


    function loadNotRecommand(){
        $(".not_recommand_list").html("");
        $.ajax({
            type:"get",
            url:"/api/notRecommand",
            success:function(r){
                for(let i=0; i<r.list.length; i++) {
                    let tag =
                        '<tr>'+
                            '<td>'+(i+1)+'</td>'+
                            '<td>'+r.list[i].pi_name+'</td>'+
                            '<td><img src="/image/'+r.list[i].pi_img_uri+'"></td>'+
                            '<td>'+r.list[i].category_name+'</td>'+
                            '<td>'+r.list[i].seller_name+'</td>'+
                            '<td><button class="pop_add_recommand" data-seq="'+r.list[i].pi_seq+'">추가</button></td>'+
                        '</tr>';
                    $(".not_recommand_list").append(tag);
                }
                $(".pop_add_recommand").click(function(){
                    $.ajax({
                        type:"put",
                        url:"/api/addRecommand?prod_seq="+$(this).attr("data-seq"),
                        success:function(r){
                            alert(r.message);
                            
                        }
                    })
                })
            }
        })
    }


})