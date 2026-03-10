<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>${board.title} - 상세보기</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5" style="max-width: 800px;">
    <div class="card shadow-sm p-4">
        <h2 class="fw-bold">${board.title}</h2>

        <div class="text-muted mb-4">
            작성자: ${board.writer} | 작성일: ${created_at} | 조회수: ${board.view_count}
            작성자: ${board.writer} | 작성일: ${board.created_at} | 조회수: ${board.view_count}
        </div>

        <hr>

        <div class="py-3" style="min-height: 200px; white-space: pre-wrap;">
            ${board.content}
        </div>
        <c:if test="${not empty board.attach_img}">
        <img src="${board.attach_img}">
        <c:if test="${not empty images}">
        <c:forEach var="이미지한장씩" items="${images}">
        <img src="${이미지한장씩.img_path}" class="img-fluid">
        </c:forEach>
        </c:if>
        <hr>

        <div class="text-end">
            <a href="/board/list" class="btn btn-outline-secondary">목록으로</a>

            <a href="/board/edit?no=${board.board_no}" class="btn btn-warning">수정</a>


                <%-- <button type="button" class="btn btn-danger"
                        onclick="location.href='/board/delete?no=${board.board_no}'">삭제</button>

    @@ -42,7 +39,6 @@

                <! --  -- >   은 자바에서 가져오는 변수는 주석처리가 안됨 jsp 확장자 안에서는 되도록이면 % 주석 사용
                --%>

            <button type="button" class="btn btn-danger"
                    onclick="게시물삭제기능(${board.board_no})">삭제
            </button>