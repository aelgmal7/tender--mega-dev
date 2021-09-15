package com.example.tendermegadev.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "mainItem")
@Builder
public class SubItem {
    @Id
    @SequenceGenerator(
            name = "sub_item_sequence",
            sequenceName = "sub_item_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sub_item_sequence"
    )
    private Long subItemId;
    @NonNull
    private String subItemName;
    private Float price;
    private String unit;
    private String desc;
    @ManyToOne(
            cascade =CascadeType.MERGE,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name ="main_item_id",
            referencedColumnName = "mainItemId"
    )
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @NonNull
    private MainItem mainItem;
    private String remark;

}
