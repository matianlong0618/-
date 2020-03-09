package com.baomidou.mybatisplus.samples.generator.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 实体类
 * </p>
 *
 * @author ML
 * @since 2020-03-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Users对象", description="")
public class Users extends Model<Users> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户id，索引")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户姓名")
    private String name;

    @ApiModelProperty(value = "手机号")
    private String mobile;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "头像URL")
    private String avator;

    @ApiModelProperty(value = "简介")
    private String introduction;

    @ApiModelProperty(value = "last_token")
    private String lastToken;

    @ApiModelProperty(value = "用户是否注销:0-未注销，1-已注销")
//    @TableField("IS_DELETE")
    @TableLogic(value="0",delval="1")
    private Boolean isDelete;

    @ApiModelProperty(value = "数据创建时间 ")
    private LocalDateTime createdAt;

    @ApiModelProperty(value = "数据最后更新时间    ")
    private LocalDateTime updatedAt;

    public Users(String name) {
        this.name = name;
    }
//    get
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public String getPassword() {
        return password;
    }

    public String getAvator() {
        return avator;
    }

    public String getIntroduction() {
        return introduction;
    }

    public String getLastToken() {
        return lastToken;
    }

    public Boolean getDelete() {
        return isDelete;
    }

//    set


    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAvator(String avator) {
        this.avator = avator;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public void setLastToken(String lastToken) {
        this.lastToken = lastToken;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
