package com.ezen.store.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "Store")
@SequenceGenerator(
        name = "store_seq_Generator",
        sequenceName = "store_seq",
        initialValue = 1,allocationSize = 1
)
public class StoreEntity {

    @Id
    @Column
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "store_seq_Generator")
    long id;
    @Column
    String name;
    @Column
    int ea;
    @Column
    int price;
}
