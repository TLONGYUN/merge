package com.tlong.merge.domain.secondary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "zjxx_orders")
public class ZjxxOrders {

    @Id
    private String id;

    //用户id
    private String peopleid;

    //商品id
    private String commodityid;

    //订单状态(0为待付费，1为已下单（即为订单完成），2已失效)
    private Integer ordersstate;

    //下单时间
    private String newstime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPeopleid() {
        return peopleid;
    }

    public void setPeopleid(String peopleid) {
        this.peopleid = peopleid;
    }

    public String getCommodityid() {
        return commodityid;
    }

    public void setCommodityid(String commodityid) {
        this.commodityid = commodityid;
    }

    public Integer getOrdersstate() {
        return ordersstate;
    }

    public void setOrdersstate(Integer ordersstate) {
        this.ordersstate = ordersstate;
    }

    public String getNewstime() {
        return newstime;
    }

    public void setNewstime(String newstime) {
        this.newstime = newstime;
    }
}
