package com.myblog.restController;

import com.myblog.been.Board;
import com.myblog.been.BoardDesc;
import com.myblog.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/Api/boardRest")
//, method={RequestMethod.GET, RequestMethod.POST,RequestMethod.DELETE, RequestMethod.PUT}
public class BoardRestController {
    @Autowired
    BoardRepository boardRepository;

    //기동
    @PutMapping
    public String updateBoard() {

        return "";
    }
    //상태확인
    @GetMapping
    public String selectBoard() {
        System.out.println("selectBoard");
        return "뭔가나오나?";
    }

    //비상정지
    @DeleteMapping
    public String deleteBoard() {
        return "";
    }


    //유저 요청
    @PostMapping
    public String insertBoard(@RequestBody Map<String, Object> param) {
        System.out.println("insertBoard");
        String title = (String)param.get("title");
        String menuId = (String)param.get("menuId");
        String text = (String)param.get("text");

        System.out.println("title = " + title);
        System.out.println("menuId = " + menuId);
        System.out.println("text = " + text);
        Board board = new Board();
        board.setTitle(title);
        board.setMenuId(Integer.parseInt(menuId));
        board.setCreateDatetime(LocalDateTime.now());
        board.setUpdateDatetime(LocalDateTime.now());

        BoardDesc boardDesc = new BoardDesc();
        boardDesc.setCreateDatetime(LocalDateTime.now());
        boardDesc.setUpdateDatetime(LocalDateTime.now());
        boardDesc.setText(text);

        board.setBoardDesc(boardDesc);
        boardRepository.save(board);

        return "Y";
    }
}
