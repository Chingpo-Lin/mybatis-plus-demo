package com.example.mybatisplus.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("banner")
public class BannerDO {

    private Integer id;

    private String img;

    private String url;

    private Integer weight;
}
