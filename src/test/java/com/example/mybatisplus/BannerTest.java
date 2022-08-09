package com.example.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatisplus.mapper.BannerMapper;
import com.example.mybatisplus.model.BannerDO;
import com.example.mybatisplus.service.BannerService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest(classes = MybatisPlusApplication.class)
@Slf4j
class BannerTest {

    @Autowired
	private BannerService bannerService;

    @Autowired
    private BannerMapper bannerMapper;

    /**
     * select by id
     */
    @Test
    public void testSelectById() {

        BannerDO bannerDO = bannerMapper.selectById(1);
        log.info("bannerDO: {}", bannerDO);
    }

    /**
     * select all
     */
    @Test
    public void testBannerList() {
        List<BannerDO> list = bannerService.list();
        log.info("banner list: {}", list);
    }

    /**
     * select id 1 and 2
     */
    @Test
    public void testSelectBatchIds() {
        List<BannerDO> list = bannerMapper.selectBatchIds(Arrays.asList(1, 2));
        log.info("banner list: {}, list");
    }

    /**
     * use select one can select by given type with given value
     */
    @Test
    public void testSelectOne() {
        BannerDO bannerDO = bannerMapper.selectOne(new QueryWrapper<BannerDO>().eq("id", 1));
        log.info("bannerDO: {}", bannerDO);
    }

    /**
     * see count from table
     */
    @Test
    public void testSelectCount() {
        int size = bannerMapper.selectCount(null);
        log.info("bannerDO: {}", size);
    }
}
