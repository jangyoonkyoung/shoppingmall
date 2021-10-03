$(function(){
    $.ajax({
        type:"get",
        url:"/member/list",
        success:function(r){
            // console.log(r);
            for(let i=0; i<r.data.length; i++){
                let tag = 
                '<tr>'+
                    '<td>'+r.data[i].mi_seq+'</td>'+
                    '<td>'+r.data[i].mi_id+'</td>'+
                    '<td>'+r.data[i].mi_name+'</td>'+
                    '<td>'+r.data[i].mi_email+'</td>'+
                    '<td>'+r.data[i].mi_address+'</td>'+
                    '<td>'+r.data[i].mi_birth+'</td>'+
                    '<td>'+r.data[i].mi_gen+'</td>'+
                    '<td>'+r.data[i].mi_phone+'</td>'+
                    '<td>'+r.data[i].mi_grade+'</td>'+
                    '<td>'+r.data[i].mi_point+'</td>'+
                    '<td>'+r.data[i].mi_status+'</td>'+
                    '<td>'+
                        '<button data-seq="'+r.data[i].mi_seq+'" class="member_delete">삭제</button>'+
                    '</td>'+
                '</tr>'
                $("#member_list_body").append(tag);
            }
            $(".member_delete").click(function(){
                if(confirm("삭제하시겠습니까?")){
                    $.ajax({
                        type:"delete",
                        url:"/member/delete?seq="+$(this).attr("data-seq"),
                        success:function(r){
                            alert(r.message);
                            location.reload();
                        }
                    })
                }
            })
        }
    })
})