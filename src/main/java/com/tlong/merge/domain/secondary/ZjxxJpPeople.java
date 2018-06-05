package com.tlong.merge.domain.secondary;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "zjxx_jp_people")
@DynamicUpdate
public class ZjxxJpPeople {

    @Id
    private String id;

    //用户名 基础表title和account一样，用户真实姓名用人员信息表存
    private String title;

    //登录用户名
    private String account;

    //登录密码
    private String password;

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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
