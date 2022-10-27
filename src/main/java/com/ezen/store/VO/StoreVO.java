package com.ezen.store.VO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class StoreVO {
    long id;
    String name;
    int ea;
    int price;
    int total;
}
