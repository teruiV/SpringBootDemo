package com.frank.chapter42;

import com.alibaba.fastjson.JSON;
import com.frank.chapter42.dao.BdChargeInfoRepository;
import com.frank.chapter42.domain.BdChargeInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter42ApplicationTests {
    private static final Logger logger = LoggerFactory.getLogger(Chapter42ApplicationTests.class);
	@Autowired
    private BdChargeInfoRepository bdChargeInfoRepository;

	@Test
    public void test_001(){
	    bdChargeInfoRepository.save(new BdChargeInfo("AA",10));
	    bdChargeInfoRepository.save(new BdChargeInfo("BB",20));

        logger.info("all size => " + bdChargeInfoRepository.findAll().size());
        logger.info("findbyName => " + JSON.toJSONString(bdChargeInfoRepository.findByName("AA")));
        logger.info("findByNameAndAge => " + JSON.toJSONString(bdChargeInfoRepository.findByNameAndAge("BB",20)));
        logger.info("findUser => " + JSON.toJSONString(bdChargeInfoRepository.findUser("AA")));


    }

}
