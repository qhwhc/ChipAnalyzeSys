package com.ccc.smse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ccc.smse.dao.ChipDataRepository;
import com.ccc.smse.dao.ChipYieldRepository;
import com.ccc.smse.pojo.ChipData;
import com.ccc.smse.pojo.ChipYield;
import com.ccc.smse.service.ChipDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Temporal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: cyb
 * @Date: 2019-03-18 20:13
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ChipDataTest {
    @Autowired
    private ChipDataRepository chipDataRepository;
    @Autowired
    private ChipYieldRepository chipYieldRepository;
    @Autowired
    private ChipDataService chipDataService;
    @Test
    public void testSave(){
        ChipData chipData = new ChipData();
        chipData.setProductCode("6MTC1204FB");
        chipData.setBatchNumber("U8L2412");
        chipData.setNumberPieces(25);
        chipData.setProcessPeriod("P阱退火");
        chipData.setProcess("P阱退火");
        chipData.setProcessConditions("SDA005");
        chipData.setWorkCenter("ADIFF1");
        chipData.setWorkUnit("D106-3");
        chipData.setOperator("胡航");
        chipData.setStartTime("2018/11/25 11:04:57");
        chipData.setEndTime("2018/11/25 18:31:52");
        ChipYield chipYield = new ChipYield();
        chipYield.setBatchNumber("6MTC1204FBJ");
        chipYield.setNumberPieces(24);
        chipYield.setParticles(10000);
        chipYield.setYield(0.95);
        Set<ChipData> chipDatas = new HashSet<ChipData>();
        chipDatas.add(chipData);


//        ChipData chipData2 = new ChipData();
//        chipData2.setProductCode("6MTC1206B");
//        chipData2.setBatchNumber("U8L4419");
//        chipData2.setNumberPieces(25);
//        chipData2.setProcessPeriod("P阱退火2");
//        chipData2.setProcess("P阱退火2");
//        chipData2.setProcessConditions("SDA0052");
//        chipData2.setWorkCenter("ADIFF2");
//        chipData2.setWorkUnit("D106-32");
//        chipData2.setOperator("胡航航");
//        chipData2.setStartTime("2018/12/10 5:43:43");
//        chipData2.setEndTime("2018/12/10 11:47:12");
//        ChipYield chipYield2 = new ChipYield();
//        chipYield2.setBatchNumber("6MTC1204FBJA5");
//        chipYield2.setNumberPieces(24);
//        chipYield2.setParticles(10000);
//        chipYield2.setYield(0.95);


        chipDataRepository.save(chipData);
        //chipDataRepository.save(chipData2);
        //chipYieldRepository.save(chipYield);
    }

    @Test
    public void testSaveChipYield(){
        ChipYield chipYield = new ChipYield();
        chipYield.setNumberPieces(12345);
        chipYield.setYield(0.70);
        chipYield.setBatchNumber("U8L2412");
        chipYieldRepository.save(chipYield);
    }
    @Test
    public void testDelete(){
        ChipData chipData = new ChipData();
        chipData.setId("1");
        chipDataRepository.delete(chipData);
    }

    @Test
    public void testSql(){
        System.out.println(chipDataRepository.findProductCode());
    }

    @Test
    public void testFind(){
        List<ChipData> chipData = chipDataRepository.findAll();
        for (ChipData c:chipData) {
            System.out.println(c.getChipYield().getYield());
        }
        System.out.println();
    }

    @Test
    public void findBycondition(){
        JSONObject jsonArray = JSON.parseObject("{productCode:\"FB&MT\",operator:\"胡\"}");
        List<ChipData> chipData = chipDataService.findAllByConditions(jsonArray);
        System.out.println(chipData.size());
        for (ChipData c: chipData) {
            System.out.println("-----------");
            System.out.println(c.getOperator());
        }

    }
}
