$(function(){

    let nameChk= false;

    $("#add").click(function(){
    if(nameChk==false){
        alert("배송자명 중복여부를 확인해주세요.");
        return;
    }

    let di_name = $("#di_name").val(); 
    if(di_name=="" || di_name==null || di_name==undefined){
        alert("배달자 명을 입력하세요");
        return;    
    }  
    let di_phone = $("#di_phone").val(); 
    if(di_phone=="" || di_phone==null || di_phone==undefined){
        alert("전화번호를 입력하세요");    
        return;
    } 
    let di_price = $("#di_price").val(); 
    if(di_price=="" || di_price==null || di_price==undefined){
        alert("배송비를 입력하세요");   
        return; 
    } 

    let data = {
        di_name: di_name,
        di_phone: di_phone,
        di_price: di_price
    }
    $.ajax({
        type:"post",
        url:"/delivery/add",
        data:JSON.stringify(data),
        contentType:"application/json",
        success:function(r){
            console.log(r);
            alert(r.message);
            location.reload();
        }
    })
    });

    $("#dup_check_name").click(function(){

        let di_name = $("#di_name").val(); 
        if(di_name=="" || di_name==null || di_name==undefined){
            alert("배달자 명을 입력하세요");
            return;    
        }  

        $.ajax({
            type:"get",
            url:"/delivery/chk?name="+di_name,
            success:function(r){
                alert(r.message);
                nameChk=r.status
            }
        })
    })
    $("#di_name").change(function(){
        nameChk=false;
    });

    $.ajax({
        type:"get",
        url:"/delivery/list",
        success:function(r){
            // console.log(r);
            for(let i=0; i<r.data.length; i++){
                // console.log(r.data);
                let tag = 
                '<tr>'+
                    '<td>'+(i+1)+'</td>'+
                    '<td>'+r.data[i].di_name+'</td>'+
                    '<td>'+r.data[i].di_phone+'</td>'+
                    '<td>'+r.data[i].di_price+'</td>'+
                    '<td>'+
                        '<button class="delete" data-seq="'+r.data[i].di_seq+'">삭제</button>'+
                    '</td>'+
                '</tr>'
                $(".delivery_tbody").append(tag);
            }
            $(".delete").click(function(){
                // alert("클릭")
                let seq=$(this).attr("data-seq");
                // console.log(seq);
                if(confirm("삭제하시겠습니까?"));
                $.ajax({
                    type:"delete",
                    url:"/delete/delivery?seq="+seq,
                    success:function(r){
                        // console.log(r);
                        alert(r.message);
                        location.reload();
                    }
                })
            })
        }
    })


})