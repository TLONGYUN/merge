package com.tlong.merge.domain.secondary;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "tsign_company")
@DynamicUpdate
public class TsignCompany {

    @Id
    private String id;

    //用户id
    private Long userId;

    //集团名称
    private String companyname;

    //企业编号
    private String codeorg;

    //社会统一信用代码
    private String codeusc;

    //法人姓名
    private String legalname;

    //法人身份证号
    private String legalidno;

    //对公账户户名（一般来说即企业名称）
    private String name;

    //企业对公银行账号
    private String cardno;

    //企业银行账号开户行支行全称
    private String subbranch;

    //企业银行账号开户行名称
    private String bank;

    //企业银行账号开户行所在省份
    private String provice;

    //企业银行账号开户行所在城市
    private String city;

    //服务id
    private String serviceid;

    //记录企业校验时间
    private Date time;

    //记录打款时间
    private Date timePay;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getCodeorg() {
        return codeorg;
    }

    public void setCodeorg(String codeorg) {
        this.codeorg = codeorg;
    }

    public String getCodeusc() {
        return codeusc;
    }

    public void setCodeusc(String codeusc) {
        this.codeusc = codeusc;
    }

    public String getLegalname() {
        return legalname;
    }

    public void setLegalname(String legalname) {
        this.legalname = legalname;
    }

    public String getLegalidno() {
        return legalidno;
    }

    public void setLegalidno(String legalidno) {
        this.legalidno = legalidno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public String getSubbranch() {
        return subbranch;
    }

    public void setSubbranch(String subbranch) {
        this.subbranch = subbranch;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getProvice() {
        return provice;
    }

    public void setProvice(String provice) {
        this.provice = provice;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getServiceid() {
        return serviceid;
    }

    public void setServiceid(String serviceid) {
        this.serviceid = serviceid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getTimePay() {
        return timePay;
    }

    public void setTimePay(Date timePay) {
        this.timePay = timePay;
    }
}
