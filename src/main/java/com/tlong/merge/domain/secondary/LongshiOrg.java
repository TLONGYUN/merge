package com.tlong.merge.domain.secondary;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author: francis
 * @Date: created in 10:57 2018/6/4
 */

@Entity
@Table(name = "zjxx_orgnization")
@DynamicUpdate
public class LongshiOrg {

    @Id
    private String id;

    //名称
    private String title;

    //描述
    private String description;

    //父级机构
    private String parentOrg;

    //机构法人
    private String legalOrg;

    //规模
    private String orgSize;

    //子级机构
    private String childOrg;

    //创建时间
    private Date createDate;

    //机构地址
    private String orgAddress;

    //机构邮箱
    private String orgEmail;

    //机构电话
    private String orgPhone;

    //是否删除
    private Boolean isdelete;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getParentOrg() {
        return parentOrg;
    }

    public void setParentOrg(String parentOrg) {
        this.parentOrg = parentOrg;
    }

    public String getLegalOrg() {
        return legalOrg;
    }

    public void setLegalOrg(String legalOrg) {
        this.legalOrg = legalOrg;
    }

    public String getOrgSize() {
        return orgSize;
    }

    public void setOrgSize(String orgSize) {
        this.orgSize = orgSize;
    }

    public String getChildOrg() {
        return childOrg;
    }

    public void setChildOrg(String childOrg) {
        this.childOrg = childOrg;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}
