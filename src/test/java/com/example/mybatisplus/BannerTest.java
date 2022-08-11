package com.example.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.mapper.BannerMapper;
import com.example.mybatisplus.model.BannerDO;
import com.example.mybatisplus.service.BannerService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * test add
     */
    @Test
    public void testAdd() {
        BannerDO bannerDO = new BannerDO();
        bannerDO.setImg("xxx");
        bannerDO.setUrl("xxx.com");

        bannerMapper.insert(bannerDO);
        log.info("img {}", bannerDO);
    }

    /**
     * test delete
     */
    @Test
    public void testDeleteId() {
        int rows = bannerMapper.deleteById(4);
        log.info("rows:{}", rows);
    }

    /**
     * test delete
     */
    @Test
    public void testDeleteByMap() {

        Map<String, Object> columnMap = new HashMap<>();
        columnMap.put("weight", 12);
        columnMap.put("url", "bbb");

        int rows = bannerMapper.deleteByMap(columnMap);
        log.info("rows:{}", rows);
    }

    /**
     * test update
     */
    @Test
    public void testUpdate() {

        BannerDO bannerDO = new BannerDO();
        bannerDO.setUrl("taobao.com");

        int rows = bannerMapper.update(bannerDO, new QueryWrapper<BannerDO>().eq("id", 1).eq("weight", 1));
        log.info("rows:{}", rows);
    }

    /**
     * update by updatewrapper
     */
    @Test
    public void testUpdateWrapper() {

        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.set("url", "ababa.com");
        updateWrapper.eq("id", 1);

        int rows = bannerMapper.update(null, updateWrapper);
        log.info("rows:{}", rows);
    }

    /**
     * test paging
     */
    @Test
    public void testPage() {
        QueryWrapper<BannerDO> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("weight", 4);

        // first page, 4 in each page
        Page<BannerDO> page = new Page<>(1, 4);
        IPage<BannerDO> iPage = bannerMapper.selectPage(page, null);

        log.info("total: {}", iPage.getTotal());
        log.info("page: {}", iPage.getPages());
        log.info("data: {}", iPage.getRecords());
    }
}
