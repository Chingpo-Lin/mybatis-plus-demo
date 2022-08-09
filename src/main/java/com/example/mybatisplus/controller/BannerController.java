package com.example.mybatisplus.controller;

import com.example.mybatisplus.model.BannerDO;
import com.example.mybatisplus.service.BannerService;
import com.example.mybatisplus.util.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/banner")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @RequestMapping("list")
    public JsonData list() {

        List<BannerDO> list = bannerService.list();

        return JsonData.buildSuccess(list);
    }

}
