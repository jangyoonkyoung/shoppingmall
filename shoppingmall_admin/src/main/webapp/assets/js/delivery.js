$(function(){
    $("#add").click(function(){
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
        }
    })
    });
})