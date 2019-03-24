package com.ccc.smse.dao;

import com.ccc.smse.pojo.ChipData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Author: cyb
 * @Date: 2019-03-18 20:09
 * @Version 1.0
 */
public interface ChipDataRepository extends JpaRepository<ChipData,Integer> {
    @Query(value = "select distinct product_code from chip_data",nativeQuery = true)
    List<String> findProductCode();
    @Query(value = "select distinct process_period from chip_data",nativeQuery = true)
    List<String> findProcessPeriod();
    @Query(value = "select distinct process from chip_data",nativeQuery = true)
    List<String> findProcess();
    @Query(value = "select distinct process_conditions from chip_data",nativeQuery = true)
    List<String> findProcessConditions();
    @Query(value = "select distinct work_center from chip_data",nativeQuery = true)
    List<String> findWorkCenter();
    @Query(value = "select distinct work_unit from chip_data",nativeQuery = true)
    List<String> findWorkUnit();
    @Query(value = "select distinct operator from chip_data",nativeQuery = true)
    List<String> findOperator();

}
