package com.tlong.merge.domain.secondary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "zjxx_commodity")
public class ZjxxCommodity {

    @Id
    private String id;

    //商品名称
    private String title;

    //商品编码
    private String number;

    //商品发布人
    private String cpeopleid;

    //商品分类(小分类)
    private String cltype;

    //商品分类(中分类)
    private String cmtype;

    //商品分类(大分类)
    private String ctype;

    //审核状态(系统字段。1为已审核，0为未审核)
    private Integer checked;

    //商品描述
    private String introduction;

    //商品详情
    private String information;

    //商品星级
    private String star;

    //商品真实评星值
    private String starreal;

    //上传类别
    private String uploadtype;

    //商品视频
    private String cvideo;

    //商品证书
    private String ccertificate;

    //商品图片地址
    private String cpicture;

    //图片类型(0为图片中只有一件，1为图片中有多件)
    private String picturetype;

    //圈口大小
    private String ringsize;

    //题材
    private String theme;

    //款式
    private String style;

    //种水
    private String zhongshui;

    //颜色
    private String color;

    //商品出厂价格
    private String price4;

    //创始人价格
    private String price1;

    //旗舰店价格
    private String price2;

    //专卖店价格
    private String price3;

    //发布价
    private String price0;

    //价格区间
    private String pricerang;

    //数量
    private String count;

    //价格类型
    private String pricetype;

    //微信客服
    private String serviceweixin;

    //服务电话
    private String servicephone;

    //发布时间(1512528320 建议不采用)
    private String newstime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCpeopleid() {
        return cpeopleid;
    }

    public void setCpeopleid(String cpeopleid) {
        this.cpeopleid = cpeopleid;
    }

    public String getCltype() {
        return cltype;
    }

    public void setCltype(String cltype) {
        this.cltype = cltype;
    }

    public Integer getChecked() {
        return checked;
    }

    public void setChecked(Integer checked) {
        this.checked = checked;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getStarreal() {
        return starreal;
    }

    public void setStarreal(String starreal) {
        this.starreal = starreal;
    }

    public String getUploadtype() {
        return uploadtype;
    }

    public void setUploadtype(String uploadtype) {
        this.uploadtype = uploadtype;
    }

    public String getCvideo() {
        return cvideo;
    }

    public void setCvideo(String cvideo) {
        this.cvideo = cvideo;
    }

    public String getCcertificate() {
        return ccertificate;
    }

    public void setCcertificate(String ccertificate) {
        this.ccertificate = ccertificate;
    }

    public String getCpicture() {
        return cpicture;
    }

    public void setCpicture(String cpicture) {
        this.cpicture = cpicture;
    }

    public String getPicturetype() {
        return picturetype;
    }

    public void setPicturetype(String picturetype) {
        this.picturetype = picturetype;
    }

    public String getRingsize() {
        return ringsize;
    }

    public void setRingsize(String ringsize) {
        this.ringsize = ringsize;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getZhongshui() {
        return zhongshui;
    }

    public void setZhongshui(String zhongshui) {
        this.zhongshui = zhongshui;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPrice4() {
        return price4;
    }

    public void setPrice4(String price4) {
        this.price4 = price4;
    }

    public String getPrice1() {
        return price1;
    }

    public void setPrice1(String price1) {
        this.price1 = price1;
    }

    public String getPrice2() {
        return price2;
    }

    public void setPrice2(String price2) {
        this.price2 = price2;
    }

    public String getPrice3() {
        return price3;
    }

    public void setPrice3(String price3) {
        this.price3 = price3;
    }

    public String getPrice0() {
        return price0;
    }

    public void setPrice0(String price0) {
        this.price0 = price0;
    }

    public String getPricerang() {
        return pricerang;
    }

    public void setPricerang(String pricerang) {
        this.pricerang = pricerang;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getPricetype() {
        return pricetype;
    }

    public void setPricetype(String pricetype) {
        this.pricetype = pricetype;
    }

    public String getServiceweixin() {
        return serviceweixin;
    }

    public void setServiceweixin(String serviceweixin) {
        this.serviceweixin = serviceweixin;
    }

    public String getServicephone() {
        return servicephone;
    }

    public void setServicephone(String servicephone) {
        this.servicephone = servicephone;
    }

    public String getNewstime() {
        return newstime;
    }

    public void setNewstime(String newstime) {
        this.newstime = newstime;
    }

    public String getCmtype() {
        return cmtype;
    }

    public void setCmtype(String cmtype) {
        this.cmtype = cmtype;
    }

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }
}
