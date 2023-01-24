package com.framework.study.order;

public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice);

}
