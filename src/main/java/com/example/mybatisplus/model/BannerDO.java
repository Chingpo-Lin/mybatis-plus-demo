package com.example.mybatisplus.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("banner")
public class BannerDO {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String img;

    private String url;

    @TableField("weight")
    private Integer weight;

    @TableField(exist = false)
    private Date createTime;
}
