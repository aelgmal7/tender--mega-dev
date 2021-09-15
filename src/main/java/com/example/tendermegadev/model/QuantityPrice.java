package com.example.tendermegadev.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class QuantityPrice {
    private Integer Quantity;
    private String subItemName;
}
