<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>회원가입</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body class="bg-light">

<div class="container mt-5" style="max-width: 500px;">
    <div class="card p-4 shadow-sm">
        <h2 class="mb-4 text-center fw-bold">회원가입</h2>

       <div id="알림창" class="d-none mb-3"></div>

        <form action="/user/register" method="post">

            <div class="mb-3">
                <label class="form-label">이름</label>
                <input type="text"  id="name"
                       name="name"
                       class="form-control"
                       placeholder="이름을 입력하세요" >
            </div>

            <div class="mb-3">
                <label class="form-label">이메일</label>
                <div class="input-group">
                <input type="email" id="name"
                       name="email" class="form-control"
                       placeholder="이메일을 입력하세요">
                <button class="btn btn-outline-dark" type="button" onclick="인증번호발송()">
                    인증번호발송
                </button>
            </div>
            </div>
            '
            <div class="mb-3" id="인증번호영역" sytle="display:none">
                <label class="form-label">인증번호</label>
                <div class="input-group">
                    <input type="text" id="code"
                           class="form-control"
                           placeholder="6자리 숫자를 입력하세요">
                    <button clas="btn btn-outline-success"
                            type="button"
                            onclick="인증번호확인()">확인</button>
                </div>
                <div class="인증결과" class="mt-1 small"></div>
                <div class="mb-3">
                    <label class="form-label">비밀번호</label>
                    <input type="password"
                           id="password"
                           class="form-control"
                           placeholder="비밀번호를 입력하세요">

                </div>
            </div>
            <!--
            type="email" @ .이 존재하게끔 클라이언트는 작성했는지 체크
            name="email" jsp -> java -> sql로 전달할 때 데이터가 들어있는 운반상자 명칭

            type="email"  = 클라이언트가 이메일을 작성할 때 @ . 를 작성했는지 확인하는 타입
            name="email"  = model.dto.User.java 파일에서 private String email로
                            데이터를 SQL에 운반할동안 잠시 담아두는 명칭으로 사용되고 있다.
                            그리고 그명칭을 프론트엔드 에서도 똑같이 맞춰서 email로 사용할 것이다.
            -->
            <div class="d-grid mt-4">
                <button class="btn btn-dark">가입하기</button>
            </div>

            <div class="text-center mt-3">
                <a href="/user/login" class="text-muted">이미 계정이 있으신가요? 로그인</a>
            </div>

        </form>
    </div>
</div>
<script>
    //const : 내부 이미지 변동 불가 let : 내부데이터 변동 가능 변수
    let 이메일인증완료 = false
    //const 이메일인증완료로 작성하면 이메일인증완료 공간은 데이터 변경 불가능한 공간으로 처리되어 true변경할 수 없다
    //var -> 심하게 레거시한 코드 추천XXX

    async function 인증번호발송()
    {
        const email=document.getElementById("email").value.trim();
        if(!email){
            alert("이메일을 입력하세요")
            return;
        }
        const res = await  fetch("/user/send-code"),{
            method : "POST"
                headers : {"Content-Type" : "application/json"},
            body: JSON.stringify({email})
        if(res.ok){
            document.getElementById("인증번호영역").style.display = "block";
            showAlert("info","인증번호가 발송되었습니다.(5분유효)")
            else{
                showAlert("danger","발송에 실패했습니다");
            }
        }
        }
    }</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
<script>
    let 이메일인증완료 = false;  // 인증 완료 여부 저장 변수

    async function 인증번호발송() {
        const email = document.getElementById("email").value.trim();

        const res = await fetch("", {
            method: "",
            headers: { "Content-Type": "" },
            body: JSON.stringify({ })
        });

        if (res.ok) {
            // TODO : 인증번호 입력란 노출 코드 작성
        }
    }

    async function 인증번호확인() {
        const email = document.getElementById("email").value.trim();
        const code  = document.getElementById("code").value.trim();

        const res = await fetch("", {
            method: "",
            headers: { "Content-Type": "" },
            body: JSON.stringify({  })
        });

        if (res.ok) {
            이메일인증완료 = true;
            // TODO : 성공 메시지 표시 + 입력란 비활성화 코드 작성
        } else {
            // TODO : 실패 메시지 표시 코드 작성
        }
    }

    async function 회원가입() {
        if (!이메일인증완료) {
            // TODO : 인증 미완료 안내 코드 작성
            return;
        }

        const name     = document.getElementById("name").value.trim();
        const email    = document.getElementById("email").value.trim();
        const password = document.getElementById("password").value.trim();

        const res = await fetch("", {
            method: "",
            headers: { "Content-Type": "" },
            body: JSON.stringify({  })
        });

        if (res.ok) {
            // TODO : 성공 시 이동 코드 작성
        } else {
            // TODO : 실패 시 에러 메시지 표시 코드 작성
        }
    }


</script>
</body>
</html>