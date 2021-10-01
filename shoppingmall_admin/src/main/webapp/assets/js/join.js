$(function(){

    //아이디랑 이메일 중복 여부 체크
    let idChk= false;
    let emailChk =false;
    
    //회원가입
    $("#join").click(function(){
        const pattern = /\s/g;

        let user_id = $("#user_id").val();
        if (user_id == "" || user_id == null || user_id == undefined) {
            alert("아이디를 입력하세요.");
            return;
        }
        if (user_id.match(pattern)) {
            alert("아이디에는 공백문자가 들어갈 수 없습니다.");
            return;
        }
        if(idChk==false){
            alert("아이디 중복여부를 확인해주세요.");
            return;
        }
        let user_pwd = $("#user_pwd").val();
        if (user_pwd == "" || user_pwd == null || user_pwd == undefined) {
            alert("비밀번호를 입력하세요.");
            return;
        }
        if (user_pwd.match(pattern)) {
            alert("비밀번호에는 공백문자가 들어갈 수 없습니다.");
            return;
        }
        let user_pwd_confirm = $("#user_pwd_confirm").val();
        if (user_pwd != user_pwd_confirm) {
            alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
            return;
        }
        let user_name = $("#user_name").val();
        if (user_name == "" || user_name == null || user_name == undefined) {
            alert("이름을 입력하세요");
            return;
        }
        if (user_name.match(pattern)) {
            alert("이름에는 공백문자가 들어갈 수 없습니다.");
            return;
        }
        const patternEmail = /^[0-9a-zA-Z]([-_\.?]?[0-9a-zA-Z])*@[0-9a-zA]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
        let user_email = $("#user_email").val();
        if (user_email == "" || user_email == null || user_email == undefined) {
            alert("이메일을 입력하세요");
            return;
        }
        if (user_email.match(pattern)) {
            alert("이메일에는 공백문자가 들어갈 수 없습니다.");
            return;
        }
        if (!user_email.match(patternEmail)) {
            alert("올바른 이메일 형식을 입력하세요 \n 예시:nnn@naver.com");
            return;
        }
        if(emailChk==false){
            alert("이메일 중복여부를 확인해주세요.");
            return;
        }
        let user_birth_year = $("#user_birth_year").val();
        let user_birth_month = $("#user_birth_month").val();
        let user_birth_date = $("#user_birth_date").val();
        let user_address = $("#user_address").val();
        let user_address_detail = $("#user_address_detail").val();
        let user_phone = $("#user_phone").val();
        let user_gen = $("#user_gen option:selected").val();
        
        if(!inputValidation(user_birth_year,"생년월일")){return;}
        if(!inputValidation(user_birth_month,"생년월일")){return;}
        if(!inputValidation(user_birth_date,"생년월일")){return;}
        if(!inputValidation(user_address,"주소")){return;}
        if(!inputValidation(user_address_detail,"상세주소")){return;}
        if(!inputValidation(user_phone,"전화번호")){return;}
        let birth = user_birth_year+leadingZero(user_birth_month)+leadingZero(user_birth_date);

        let data={
            mi_id: user_id,
            mi_name: user_name,
            mi_email: user_email,
            mi_pwd: user_pwd,
            mi_birth: birth,
            mi_gen: user_gen,
            mi_address: user_address,
            mi_address_detail: user_address_detail,
            mi_phone: user_phone   
        };    
    
        $.ajax({
            type:"post",
            url:"/member/join",
            data:JSON.stringify(data),
            contentType:"application/json",
            success:function(r) {
                alert(r.message);
                if(r.status) {
                    location.href="/";
                }
            },
            error:function(e){
                alert(e.message);
            }
        })
    });
    
    //아이디 중복값 체크
    $("#chk_id").click(function(){
        const pattern = /\s/g;
        let user_id = $("#user_id").val();
        if(user_id == "" || user_id == null || user_id == undefined) {
            alert("아이디를 입력해주세요");
            return;
        }
        if(user_id.match(pattern)) {
            alert("아이디에는 공백문자가 들어갈 수 없습니다.");
            return;
        }
        $.ajax({
            type:"get",
            url:"/member/id_check?id="+user_id,
            success:function(r){
                alert(r.message);
                idChk=r.status;
            }
        })
    });

    //이메일 중복값 체크
    $("#chk_email").click(function(){
        //alert("클릭");
        const pattern = /\s/g;
        const patternEmail = /^[0-9a-zA-Z]([-_\.?]?[0-9a-zA-Z])*@[0-9a-zA]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
        let user_email = $("#user_email").val();
        if (user_email == "" || user_email == null || user_email == undefined) {
            alert("이메일을 입력하세요");
            return;
        }
        if (user_email.match(pattern)) {
            alert("이메일에는 공백문자가 들어갈 수 없습니다.");
            return;
        }
        if (!user_email.match(patternEmail)) {
            alert("올바른 이메일 형식을 입력하세요 \n 예시:nnn@naver.com");
            return;
        }
        $.ajax({
            type:"get",
            url:"/member/email_check?email="+user_email,
            success:function(r){
                alert(r.message);
                emailChk = r.status;
            }
        })
    })

    //중복 체트 했는데 또 수정할 시 다시 중복하라고 체크해주기
    $("#user_id").change(function(){
        idChk=false;
    });
    $("#user_email").change(function(){
        emailChk=false;
    });

});

function inputValidation(input,type){
    if(input=""|| input==null|| input==undefined){
        alert(type+"을/를 입력하세요");
        return false;
    }
    return true;
}

//입력된 데이터를 숫자 형태로 형 변환
function leadingZero(n) {
    let num = Number(n);
    return num<10?"0"+num:""+num;
}