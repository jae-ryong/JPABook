package com.practice.jpa.chapter4;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ORDER_ITEM")
@Data
public class OrderItem {
    @Id
    @GeneratedValue
    @Column(name = "ORDER_ITEM_ID")
    private Long id;

    @Column(name = "ITEM_ID")
    private Long imemId;

    @Column(name = "ORDER_ID")
    private Long orderId;

    private int orderPrice;
    private int count;
}
