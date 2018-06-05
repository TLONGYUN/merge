package com.tlong.merge.domain.secondary;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "zjxx_people")
@DynamicUpdate
public class ZjxxPeople{

    @Id
    private String id;

    //用户名(非登录名)
    private String title;

    //密码
    private String servicephone;

    //当前状态(价格分享代理人id集合)
    private String priceshareids;

    //营业执照照片
    private String bpicture;

    //用户类型
    private String ptype;

    //身份证照片
    private String ipicture;

    //头像
    private String head;

    //年龄
    private String age;

    //性别
    private String sex;

    //手机号
    private String phone;

    //微信号
    private String pweixin;

    //真实姓名
    private String realname;

    //头像地址
    private String headImage;

    //昵称
    private String nickname;

    //是否开启价格分享
    private String shareprice;

    //是否通过e签宝
    private Integer echecktype;

    //每日重新发布数
    private String republishNum;

    //每日商品发布数
    private String releaseNum;

    //微信
    private String dayReleasNum;

    //商品发布数统计时间
    private Integer dayReleaseTime;

    //每日重新发布数
    private Integer dayRedistributionNum;

    //商品重新发布数时间统计
    private Integer dayRedistributionTime;

    //证书编号
    private String evid;

    //企业类型
    private String organType;

    //父id 系统字段，用来记录是哪个代理人添加了自己。
    private String pid;

    //是否审核 系统字段，用来记录该供应商是否认证。1为已审核，0为未审核，2为待审核
    private Integer checked;

    //人员编号 自增，唯一索引
    private Integer idnum;

    //用户编码 XX+4位人员编号，分公司10开头、总代理20、一代30、二代50、企业供应商80、个人供应商90
    private String peoplenum;

    //显示出厂价 默认为1。0关闭。1为开启。
    private String onlyprice;

    //营业执照照片
    private String businessLicense;

    //是否企业
    private String iscompany;

    //是否免检
    private String passcheck;

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

    public String getServicephone() {
        return servicephone;
    }

    public void setServicephone(String servicephone) {
        this.servicephone = servicephone;
    }

    public String getPriceshareids() {
        return priceshareids;
    }

    public void setPriceshareids(String priceshareids) {
        this.priceshareids = priceshareids;
    }

    public String getBpicture() {
        return bpicture;
    }

    public void setBpicture(String bpicture) {
        this.bpicture = bpicture;
    }

    public String getPtype() {
        return ptype;
    }

    public void setPtype(String ptype) {
        this.ptype = ptype;
    }

    public String getIpicture() {
        return ipicture;
    }

    public void setIpicture(String ipicture) {
        this.ipicture = ipicture;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPweixin() {
        return pweixin;
    }

    public void setPweixin(String pweixin) {
        this.pweixin = pweixin;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getShareprice() {
        return shareprice;
    }

    public void setShareprice(String shareprice) {
        this.shareprice = shareprice;
    }

    public Integer getEchecktype() {
        return echecktype;
    }

    public void setEchecktype(Integer echecktype) {
        this.echecktype = echecktype;
    }

    public String getRepublishNum() {
        return republishNum;
    }

    public void setRepublishNum(String republishNum) {
        this.republishNum = republishNum;
    }

    public String getReleaseNum() {
        return releaseNum;
    }

    public void setReleaseNum(String releaseNum) {
        this.releaseNum = releaseNum;
    }

    public String getDayReleasNum() {
        return dayReleasNum;
    }

    public void setDayReleasNum(String dayReleasNum) {
        this.dayReleasNum = dayReleasNum;
    }

    public Integer getDayReleaseTime() {
        return dayReleaseTime;
    }

    public void setDayReleaseTime(Integer dayReleaseTime) {
        this.dayReleaseTime = dayReleaseTime;
    }

    public Integer getDayRedistributionNum() {
        return dayRedistributionNum;
    }

    public void setDayRedistributionNum(Integer dayRedistributionNum) {
        this.dayRedistributionNum = dayRedistributionNum;
    }

    public Integer getDayRedistributionTime() {
        return dayRedistributionTime;
    }

    public void setDayRedistributionTime(Integer dayRedistributionTime) {
        this.dayRedistributionTime = dayRedistributionTime;
    }

    public String getEvid() {
        return evid;
    }

    public void setEvid(String evid) {
        this.evid = evid;
    }

    public String getOrganType() {
        return organType;
    }

    public void setOrganType(String organType) {
        this.organType = organType;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public Integer getChecked() {
        return checked;
    }

    public void setChecked(Integer checked) {
        this.checked = checked;
    }

    public Integer getIdnum() {
        return idnum;
    }

    public void setIdnum(Integer idnum) {
        this.idnum = idnum;
    }

    public String getPeoplenum() {
        return peoplenum;
    }

    public void setPeoplenum(String peoplenum) {
        this.peoplenum = peoplenum;
    }

    public String getOnlyprice() {
        return onlyprice;
    }

    public void setOnlyprice(String onlyprice) {
        this.onlyprice = onlyprice;
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    public String getIscompany() {
        return iscompany;
    }

    public void setIscompany(String iscompany) {
        this.iscompany = iscompany;
    }

    public String getPasscheck() {
        return passcheck;
    }

    public void setPasscheck(String passcheck) {
        this.passcheck = passcheck;
    }
}
