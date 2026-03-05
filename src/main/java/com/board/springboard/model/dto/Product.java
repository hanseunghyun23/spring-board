package com.board.springboard.model.dto;


import lombok.*;

import java.time.LocalDate;

@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class Product {
    private Long id; //Integer 보다 숫자범위가 더 넓음
    private String name;
    private int price;
    private int stock;
    private LocalDate  created_at;

}
