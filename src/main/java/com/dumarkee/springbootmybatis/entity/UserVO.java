package com.dumarkee.springbootmybatis.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: 杜威
 * @Date: 2019/01/15 0:01
 * @Description:
 */
public class UserVO implements Serializable{
    private Long id;
    private String name;
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
