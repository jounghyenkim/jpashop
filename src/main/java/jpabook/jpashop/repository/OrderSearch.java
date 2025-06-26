package jpabook.jpashop.repository;

import jpabook.jpashop.domain.OderStatus;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderSearch {

    private String memberName; // 회원 이름
    private OderStatus oderStatus; // 주문 상태[ORDER,CANCEL]


}
