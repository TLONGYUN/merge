package com.tlong.merge.domain.primary;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "tlong_order")
@DynamicUpdate
public class WebOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //用户id
    private Long userId;

    //商品id
    private Long goodsId;

    //订单状态
    private Integer state;

    //下单时间
    private String placeOrderTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getPlaceOrderTime() {
        return placeOrderTime;
    }

    public void setPlaceOrderTime(String placeOrderTime) {
        this.placeOrderTime = placeOrderTime;
    }
}
