<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>게시물 작성</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="/board/write" style="max-width: 600px;">
    <div class="card p-4 shadow-sm">
        <h2 class="mb-4">새 게시물 작성</h2>

        <form action="/write" method="post">
            <div class="mb-3">
                <label class="form-label">제목</label>
                <input type="text" name="title" class="form-control" placeholder="제목을 입력하세요" required>
            </div>

            <div class="mb-3">
                <label class="form-label">작성자</label>
                <input type="text" name="$writer" class="form-control" required>
            </div>

            <div class="mb-3">
                <label class="form-label">내용</label>
                <textarea name="content" class="form-control" rows="5" required></textarea>
            </div>

            <div class="text-center mt-4">
                <button type="submit" class="btn btn-dark px-4">저장하기</button>
                <!--
                <button>태그
                버튼 태그에서 type를 작성하지 않은 버튼의 기본값
                <button type="submit">저장하기</button>
                type = submit
                    form에 작성된 데이터를 action주소로 전송
                    별도의 자바스크립트가 없어도 페이지가 새로고팀되어 데이터만 서버로 보냄

                <button type="button">저장하기<button>
                        산순 버튼 이 버튼은 클릭해도 아무런 변화가 일어나지 않는버튼
                        자체적으로 전송도 초기화도 하지 않는 깡통버튼
                        javaScript와 연결할 때 사용
                        데이터를 sql 특정 사이트로 전송하기 전 입력값 검증(빈칸 체크 등)을 하고 싶을때 사용
                       form 내부에 button이 존재하는지에 대해 크게 개연을 받지 않음 form 외부에 있어도 자바스크립트로 기능 연결만 태그에 잘 해준다면 form외부에 존재해도 되는 버튼


                <button type="reset">초기화<button>
                    <button type><





                    <button type="reset" 초기화
                    매부에 버튼이 존재하고 form안에 입력된 몯ㄴ 값을 첨 상태로 되돌림, 사
                    사용자가

                -->
                <a href="/board/list" class="btn btn-outline-secondary">취소</a>
            </div>
        </form>
    </div>
</div>

</body>
</html>