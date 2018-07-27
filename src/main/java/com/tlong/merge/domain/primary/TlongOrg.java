package com.tlong.merge.domain.primary;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: francis
 * @Date: created in 11:08 2018/6/4
 */
@Entity
@Table(name = "tlong_org")
@DynamicUpdate
public class TlongOrg {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id = 2L;

    //机构名称
    private String orgName;

    //父级机构id
    private Long parentOrgId;

    //机构级别(0省 1市 2区(县))
    private Integer orgLevel;

    //机构地址
    private String orgAddress;

    //机构邮箱
    private String orgEmail;

    //机构电话
    private String orgPhone;

    //机构法人
    private String legalOrg;

    //机构描述
    private String orgDesc;

    //机构规模
    private String orgSize;

    //当前状态
    private Integer curState;

    //是否删除
    private Integer isDeleted;

    //创建时间
    private Date createDate;

    //最后修改时间
    private Date lastUpdateDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Long getParentOrgId() {
        return parentOrgId;
    }

    public void setParentOrgId(Long parentOrgId) {
        this.parentOrgId = parentOrgId;
    }

    public Integer getOrgLevel() {
        return orgLevel;
    }

    public void setOrgLevel(Integer orgLevel) {
        this.orgLevel = orgLevel;
    }

    public String getOrgAddress() {
        return orgAddress;
    }

    public void setOrgAddress(String orgAddress) {
        this.orgAddress = orgAddress;
    }

    public String getOrgEmail() {
        return orgEmail;
    }

    public void setOrgEmail(String orgEmail) {
        this.orgEmail = orgEmail;
    }

    public String getOrgPhone() {
        return orgPhone;
    }

    public void setOrgPhone(String orgPhone) {
        this.orgPhone = orgPhone;
    }

    public String getLegalOrg() {
        return legalOrg;
    }

    public void setLegalOrg(String legalOrg) {
        this.legalOrg = legalOrg;
    }

    public String getOrgDesc() {
        return orgDesc;
    }

    public void setOrgDesc(String orgDesc) {
        this.orgDesc = orgDesc;
    }

    public String getOrgSize() {
        return orgSize;
    }

    public void setOrgSize(String orgSize) {
        this.orgSize = orgSize;
    }

    public Integer getCurState() {
        return curState;
    }

    public void setCurState(Integer curState) {
        this.curState = curState;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}
