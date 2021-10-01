$(function(){
    $("#login_btn").click(function(){
        const pattern = /\s/g;

        let id = $("#user_id").val();
        if (id == "" || id == null || id == undefined) {
            alert("아이디를 입력하세요.");
            return;
        }
        if (id.match(pattern)) {
            alert("아이디에는 공백문자가 들어갈 수 없습니다.");
            return;
        }
        let pwd = $("#user_pwd").val();
        if (pwd == "" || pwd == null || pwd == undefined) {
            alert("비밀번호를 입력하세요.");
            return;
        }
        if (pwd.match(pattern)) {
            alert("비밀번호에는 공백문자가 들어갈 수 없습니다.");
            return;
        }
        let data={
            id: id,
            pwd: pwd
        };

        $.ajax({
            type:"post",
            url:"/member/login",
            data:JSON.stringify(data),
            contentType:"application/json",
            success:function(r){
                if(r.status){
                    location.href="/";  
                }
                else{
                    alert(r.message);
                }
            }
        })
    })
    
})