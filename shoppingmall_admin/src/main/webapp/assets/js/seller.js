$(function(){
    //아이디 중복 체크
    let idChk= false;
    let emailChk =false;

    $("#regist").click(function(){
        
        let id = $("#seller_id").val();
        let pwd= $("#seller_pwd").val();
        let pwd_con= $("#seller_pwd_con").val();
        let name= $("#seller_name").val();
        let addr= $("#seller_addr").val();
        let email= $("#seller_email").val();
        let phone= $("#seller_phone").val();
        
        const pattern = /\s/g;

        if(idChk==false){
            alert("아이디 중복여부를 확인해주세요.");
            return;
        }
        if (id == "" || id == null || id == undefined) {
            alert("아이디를 입력하세요.");
            return;
        }
        if (id.match(pattern)) {
            alert("아이디에는 공백문자가 들어갈 수 없습니다.");
            return;
        }
        if(id.length < 4) {
            alert("아이디는 4자 이상으로 입력해주세요");
            return;
        }

        if (pwd == "" || pwd == null || pwd == undefined) {
            alert("비밀번호를 입력하세요.");
            return;
        }
        if (pwd.match(pattern)) {
            alert("비밀번호에는 공백문자가 들어갈 수 없습니다.");
            return;
        }
        if(pwd.length < 6) {
            alert("비밀번호는 6글자 이상 입력하세요.");
            return;
        }
        if (pwd != pwd_con) {
            alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
            return;
        }
        if (name == "" || name == null || name == undefined) {
            alert("이름을 입력하세요");
            return;
        }
        if (name.match(pattern)) {
            alert("이름에는 공백문자가 들어갈 수 없습니다.");
            return;
        }
        if(addr == "" || name == null || name == undefined) {
            alert("주소를 입력해주세요");
            return;
        }
        const patternEmail = /^[0-9a-zA-Z]([-_\.?]?[0-9a-zA-Z])*@[0-9a-zA]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
        if (email == "" || email == null || email == undefined) {
            alert("이메일을 입력하세요");
            return;
        }
        if (email.match(pattern)) {
            alert("이메일에는 공백문자가 들어갈 수 없습니다.");
            return;
        }
        if (!email.match(patternEmail)) {
            alert("올바른 이메일 형식을 입력하세요 \n 예시:nnn@naver.com");
            return;
        }
        if(emailChk==false){
            alert("이메일 중복여부를 확인해주세요.");
            return;
        }
        if(phone == ''|| phone == null || phone == undefined) {
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
        const pattern = /\s/g;
        let id = $("#seller_id").val();
        if (id == "" || id == null || id == undefined) {
            alert("아이디를 입력하세요.");
            return;
        }
        if (id.match(pattern)) {
            alert("아이디에는 공백문자가 들어갈 수 없습니다.");
            return;
        }
        if(id.length < 4) {
            alert("아이디는 4자 이상으로 입력해주세요");
            return;
        }
        $.ajax({
            type:"get",
            url:"/seller/isDuplicatedId?id="+id,
            success:function(r){
                console.log(r);
                alert(r.message);
                //입력한 값 그래도 가지고 있기
                idChk=r.status;
            }
        })
    })
    $("#dup_check_Email").click(function(){
        const pattern = /\s/g;
        const patternEmail = /^[0-9a-zA-Z]([-_\.?]?[0-9a-zA-Z])*@[0-9a-zA]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
        // alert("클릭");
        let email= $("#seller_email").val();
        if (email == "" || email == null || email == undefined) {
            alert("이메일을 입력하세요");
            return;
        }
        if (email.match(pattern)) {
            alert("이메일에는 공백문자가 들어갈 수 없습니다.");
            return;
        }
        if (!email.match(patternEmail)) {
            alert("올바른 이메일 형식을 입력하세요 \n 예시:nnn@naver.com");
            return;
        }
        $.ajax({
            type:"get",
            url:"/seller/isDuplicatedEmail?email="+email,
            success:function(r){
                alert(r.message);
            }
        })
        
    })

    //아이디 중복체크를 하고 다시 바꾸면 가입하기 전 다시 중복체크하기
    $("#seller_id").change(function(){
        idChk=false;
    });
    $("#seller_email").change(function(){
        emailChk=false;
    });
})