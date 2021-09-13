package com.example.tendermegadev.model;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class SubItemPass {
    private Long subItemId;
    private String subItemName;
    private Float price;

}
