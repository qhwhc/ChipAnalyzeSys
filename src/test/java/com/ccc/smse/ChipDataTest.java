package com.ccc.smse;

import com.ccc.smse.dao.ChipDataRepository;
import com.ccc.smse.dao.ChipYieldRepository;
import com.ccc.smse.pojo.ChipData;
import com.ccc.smse.pojo.ChipYield;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
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
    @Test
    public void testSave(){
        ChipData chipData = new ChipData();
        chipData.setBatchNumber("6MTC1204FBJA5");
        chipData.setNumberPieces(25);
        chipData.setProcessPeriod("P阱退火");
        chipData.setProcess("P阱退火");
        chipData.setProcessConditions("SDA005");
        chipData.setWorkCenter("ADIFF");
        chipData.setWorkUnit("D106-3");
        chipData.setOperator("吴文刚");
        chipData.setStartTime("2018/11/25 11:04:57");
        chipData.setEndTime("2018/11/25 18:31:52");

        ChipYield chipYield = new ChipYield();
        chipYield.setBatchNumber("6MTC1204FBJA5");
        chipYield.setNumberPieces(24);
        chipYield.setParticles(10000);
        chipYield.setYield(0.95);

        Set<ChipData> chipDatas = new HashSet<ChipData>();
        chipDatas.add(chipData);
        chipYield.setChipDataSet(chipDatas);

        chipYieldRepository.save(chipYield);
    }
}
