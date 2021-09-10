$(function(){
    //아이디 중복 체크
    let idChk= false;

    $("#regist").click(function(){
        
        let id = $("#seller_id").val();
        let pwd= $("#seller_pwd").val();
        let pwd_con= $("#seller_pwd_con").val();
        let name= $("#seller_name").val();
        let addr= $("#seller_addr").val();
        let email= $("#seller_email").val();
        let phone= $("#seller_phone").val();
        
        if(idChk==false){
            alert("아이디 중복여부를 확인해주세요.");
            return;
        }

        if(id == '') {
            alert("아이디를 입력하세요");
            return;
        }
        if(id.length < 4) {
            alert("아이디는 4자 이상으로 입력해주세요");
            return;
        }

        if(pwd == '') {
            alert("비밀번호를 입력하세요.");
            return;
        }
        if(pwd.length < 6) {
            alert("비밀번호는 6글자 이상 입력하세요.");
            return;
        }
        if(pwd != pwd_con) {
            alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
            return;
        }
        if(name == '') {
            alert("이름을 입력해주세요");
            return;
        }
        if(addr == '') {
            alert("주소를 입력해주세요");
            return;
        }
        if(email == '') {
            alert("이메일을 입력해주세요");
            return;
        }
        if(phone == '') {
            alert("전화번호를 입력해주세요");
            return;
        }
        let sellerInfo = {
            si_id:id,
            si_pwd:pwd,
            si_name:name,
            si_address:addr,
            si_email:email,
            si_phone:phone
        };
        $.ajax({
            type:"post",
            url:"/seller/regist",
            data:JSON.stringify(sellerInfo),
            contentType:"application/json",
            success:function(r){
                console.log(r);
            }
        })    
    })

    $("#dup_check").click(function(){
        // alert("중복체크");
        let id = $("#seller_id").val();
        if(id==''){
            alert("아이디를 입력하세요.")
            return;
        }
        if(id.length<4){
            alert("아이디는 4자 이상으로 입력하세요.")
            return;
        }
        $.ajax({
            type:"get",
            url:"/seller/isDuplicated?id="+id,
            success:function(r){
                console.log(r);
                alert(r.message);
                //입력한 값 그래도 가지고 있기
                idChk=r.status;
            }
        })
    })
    //아이디 중복체크를 하고 다시 바꾸면 가입하기 전 다시 중복체크하기
    $("#seller_id").change(function(){
        idChk=false;
    });
})