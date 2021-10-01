$(function(){
    $(".add").click(function(){
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
                location.reload();
            }
        })
    })

    $.ajax({
        type:"get",
        url:"/category/all",
        success:function(r){
            //console.log(r.list);
            for(let i=0; i<r.list.length; i++){
                let tag = 
                        '<tr>'+
                            '<td>'+(i+1)+'</td>'+
                            '<td>'+r.list[i].cate_name+'</td>'+
                            '<td>'+
                            '<button data-seq="'+r.list[i].cate_seq+'" class="cate_del">삭제</button>'+
                            '</td>'+
                        '</tr>';
                $("#cate_table_body").append(tag);
            }

            $(".cate_del").click(function(){
                console.log( $(this).attr("data-seq") );
                if(confirm("삭제하시겠습니까?")) {
                    // 삭제 동작
                    let seq=$(this).attr("data-seq");
                    console.log("삭제동작");
                    $.ajax({
                        type:"delete",
                        url:"/category/delete?seq="+seq,
                        success:function(r){
                            alert(r.message);
                            location.reload();
                        }
                    })
                }
            });
            
        }
    });
    

})