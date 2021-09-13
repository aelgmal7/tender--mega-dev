package com.example.tendermegadev.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MainItem {
    @Id
    @SequenceGenerator(
            name = "main_item_sequence",
            sequenceName = "main_item_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "main_item_sequence"
    )
    private Long mainItemId;
    private  String mainItemName;
}
