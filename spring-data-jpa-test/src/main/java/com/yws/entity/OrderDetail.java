package com.yws.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "orderdetails")
@Entity
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 3334567156385690553L;

    @NotNull
    @Id
    private Integer orderDetailId;

    private Integer quantityOrdered;
    private BigDecimal priceEach;
    private Integer orderLineNumber;

    @MapsId("orderNumber")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderNumber", referencedColumnName = "orderNumber")
    private Order order;

    public Integer getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Integer orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Integer getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(Integer quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public BigDecimal getPriceEach() {
        return priceEach;
    }

    public void setPriceEach(BigDecimal priceEach) {
        this.priceEach = priceEach;
    }

    public Integer getOrderLineNumber() {
        return orderLineNumber;
    }

    public void setOrderLineNumber(Integer orderLineNumber) {
        this.orderLineNumber = orderLineNumber;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
