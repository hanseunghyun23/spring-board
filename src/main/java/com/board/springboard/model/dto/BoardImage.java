package com.board.springboard.model.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class BoardImage {
    private Integer Id;
    private Integer board_no;
    private String img_path;
    private LocalDateTime created_at;

}
