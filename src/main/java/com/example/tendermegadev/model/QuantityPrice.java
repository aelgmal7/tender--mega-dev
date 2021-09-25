package com.example.tendermegadev.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class QuantityPrice {
    private Float quantity;
    private String subItemName;
}
