package com.ezen.store.DTO;

import com.ezen.store.Entity.StoreEntity;
import lombok.*;

import javax.persistence.Id;
import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class StoreDTO {

    long id;
    @NotBlank(message = "상품명은 필수입력 사항입니다.")
    String name;
    @Digits(integer = 6,fraction = 0)
    @Min(value = 1,message = "최소 수량은 1개 입니다.")
    @Max(value = 999,message = "최대 수량은 999개 입니다.")
    int ea;
    @Digits(integer = 6,fraction = 0)
    @Min(value = 1,message = "최소 가격은 1원 입니다.")
    @Max(value = 9999999,message = "최대 단가는 9,999,999원 입니다.")
    int price;

    public StoreEntity toEntity(){
        return new StoreEntity(id, name, ea, price);
    }
}
