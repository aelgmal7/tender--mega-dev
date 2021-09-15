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
    @NonNull
    private String subItemName;
    private Float price;
    private String unit;
    private String desc;
    private String mainItemName;
    private String remark;

}
