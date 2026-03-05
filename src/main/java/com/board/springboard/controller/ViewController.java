package com.board.springboard.controller;


import com.board.springboard.model.dto.Board;
import com.board.springboard.model.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller // jsp 나 html 템플릿과 소비자가 연결해야하는 api 주소 작성
@RequiredArgsConstructor //이 한중리 생성자 코드를 자동 생성해준다
public class ViewController {
    private final BoardService boardService;

/*
* 아래 생성자 매개변수 코드를 @RequiredArgsConstructor 어노테이션으로 대체해 사용 가능
* */
   /* public ViewController(BoardService boardService) {
        this.boardService = boardService; -> 클래스 필드에 직접 대입해서 사용하겠다
    }*/
/*
메인 페이지로 이동
 */
    @GetMapping("/")
    public String indexView() {
        return "index";
    }

    /*
    <a href="/board/detail?no=${board.board_no}">
        ${board.title}
    </a>
     */

    /*게시물 상세 페이지로 이동
    *   조회할 게시물 번호
    *   단일 게시물
    * */

    @GetMapping("/board/detail")
    public String detailView(@RequestParam("no") int board_no, Model model) {
        // 조회수 증가 및 상세 데이터 가져오기 처리
        // 가져온 데이터를 board 폴더 내에 있는 detail 전달

        Board boardData = boardService.boardDetail(board_no);
        model.addAttribute("board", boardData);
        return "board/detail";
    }


    /*
    * 게시물 목록 조회 및 페이지 이동
    *  매개변수  model-  게시물 리스트 데이터를 전달하기 위한 객체
    *
    * */


    // /board/list
    @GetMapping("/board/list")
    public String listView(Model model) {
        List<Board> boardListData = boardService.findAllBoard();
        model.addAttribute("boardLists", boardListData);
        /*
        Model model 모듈 사용해서 SQL에서 가져온 전체 게시물을 board/list 전달
        list.jsp에 전달할 변수이름 : boardLists
        service에서 데이터를 담아올 변수이름 : boardListData
         */
        return "board/list";
    }
    //게시물 작성 페이지로 이동

    // /board/write
    @GetMapping("/board/write")
    public String writeView() {
        return "board/write";
    }
/*
* 게시물 작성 처리
* 매개변수board - 작성된 페이지가 담긴DTO
* 반환    게히물 목록으로 리다리렉트
* */
    @PostMapping("/board/write")
    public String wrtieBoard(Board board) {
        boardService.writeBoard(board);
        return "redirect:/board/list";
    }

    // ViewController.java

    /*
    * 게시물 수정 실행(DB 업데이트)
    * @Param board_no 수정해야하는 게시물 번호
    * @param model      기존 데이터를 전달하기 위한 객체
    * @return           board 폴더 안에 있는 edit 파일로 이동
    * */

    @GetMapping("/board/edit")
    public String editView(@RequestParam("no") int board_no, Model model) {


        Board board = boardService.boardDetail(board_no);
       model.addAttribute("board", board);


        return "board/edit";
    }
/*게시물 삭제처리
* @Param board_no : JSP에서 'no'라는 이름으로 보낸 게시물 번호
* @return : 삭제 후 게시물 목록 페이지로 이동
*
* redirect : 서버가 웹 사이트에게 다른 주소로 다시 가라고 명령하는 것
* 사용자가 보낸 요청을 서버가 처리하고 나서, 현재 페이지에 머무는 것이 아니라
* 새로운 페이지를 첨부터 다시 호출하게 만들 때 사용
* ->저장하고, 삭제할 일 다했으니 지금 페이지에 있지 마시고 ㅇㅇㅇ페이지로 이동하세요
*
* */


    @GetMapping("/board/delete")
    public String deleteBoard(@RequestParam("no") int board_no) {


        boardService.deleteBoard(board_no);


        return "redirect:/board/list";
    }
}