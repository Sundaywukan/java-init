/**
 * 
 * @version 1.0
 * @date Mon Nov 20 09:43:50 CST 2017
 * Copyright 杭州奇石信息科技有限公司 All Rights Reserved
 * http://innosoft.cc/ 
 */ 
package cc.innosoft.thirdchat.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户表
 * @author wuk
 *
 */
public class User {
    /**
     * id
     */ 
    private Integer id;

    /**
     * 用户名
     */ 
    private String userName;

    /**
     * 密码
     */ 
    private String password;

    /**
     * 昵称
     */ 
    private String nickName;

    /**
     * 是否是vip
     */ 
    private Integer isVip;

    /**
     * 手机号
     */ 
    private String mobile;

    /**
     * 微信名
     */ 
    private String wechatName;

    /**
     * 微信号
     */ 
    private String wechatId;

    /**
     * 邀请人id
     */ 
    private Integer inviteId;

    /**
     * 金额
     */ 
    private BigDecimal money;

    /**
     * 性别 0未设置 1男 2女
     */ 
    private Integer sex;

    /**
     * 生日
     */ 
    private Date birthday;

    /**
     * 头像
     */ 
    private Long headPic;

    /**
     * 添加时间
     */ 
    private Date createTime;

    /**
     * 状态(1正常 2冻结)
     */ 
    private Integer status;

    /**
     * id
     */
    public Integer getId() {
        return id;
    }

    /**
     * id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * 是否是vip
     */
    public Integer getIsVip() {
        return isVip;
    }

    /**
     * 是否是vip
     */
    public void setIsVip(Integer isVip) {
        this.isVip = isVip;
    }

    /**
     * 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 微信名
     */
    public String getWechatName() {
        return wechatName;
    }

    /**
     * 微信名
     */
    public void setWechatName(String wechatName) {
        this.wechatName = wechatName == null ? null : wechatName.trim();
    }

    /**
     * 微信号
     */
    public String getWechatId() {
        return wechatId;
    }

    /**
     * 微信号
     */
    public void setWechatId(String wechatId) {
        this.wechatId = wechatId == null ? null : wechatId.trim();
    }

    /**
     * 邀请人id
     */
    public Integer getInviteId() {
        return inviteId;
    }

    /**
     * 邀请人id
     */
    public void setInviteId(Integer inviteId) {
        this.inviteId = inviteId;
    }

    /**
     * 金额
     */
    public BigDecimal getMoney() {
        return money;
    }

    /**
     * 金额
     */
    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    /**
     * 性别 0未设置 1男 2女
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 性别 0未设置 1男 2女
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 生日
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 生日
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 头像
     */
    public Long getHeadPic() {
        return headPic;
    }

    /**
     * 头像
     */
    public void setHeadPic(Long headPic) {
        this.headPic = headPic;
    }

    /**
     * 添加时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 添加时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 状态(1正常 2冻结)
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态(1正常 2冻结)
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}