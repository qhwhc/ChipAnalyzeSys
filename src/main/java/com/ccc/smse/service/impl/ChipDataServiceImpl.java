package com.ccc.smse.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ccc.smse.dao.ChipDataRepository;
import com.ccc.smse.pojo.ChipData;
import com.ccc.smse.service.ChipDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author: cyb
 * @Date: 2019-03-18 20:11
 * @Version 1.0
 */
@Service
public class ChipDataServiceImpl implements ChipDataService {
    @Autowired
    ChipDataRepository chipDataRepository;
    SimpleDateFormat fm=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
    @Override
    public List<ChipData> findAll() {
        return chipDataRepository.findAll();
    }

    @Override
    public List<ChipData> findAllByConditions(JSONObject jsonObject) {
        Specification<ChipData> spec = new Specification<ChipData>() {
            @Override
            public Predicate toPredicate(Root<ChipData> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> params = new ArrayList<>();
                for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
//                    时间处理
                    try {
                        if("start".equals(entry.getKey())) {
                            System.out.println(entry.getValue());
                            params.add(criteriaBuilder.greaterThanOrEqualTo(root.get("startTime").as(String.class), fm.format(sdf.parse(entry.getValue().toString()))));
                            continue;
                        }
                        if("end".equals(entry.getKey())) {
                            params.add(criteriaBuilder.lessThanOrEqualTo(root.get("endTime").as(String.class), fm.format(sdf.parse(entry.getValue().toString()))));
                            continue;
                        }

                        if("q".equals(entry.getKey())) {
                            params.add(criteriaBuilder.like(root.get("batchNumber"), "%" + entry.getValue().toString()+ "%"));
                            continue;
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
//                    其他条件拼接
                    if(entry.getValue().toString().indexOf("&") > 0) {
                        String[] strs = entry.getValue().toString().split("&");
                        Predicate[] pres = new Predicate[strs.length];
                        for (int i = 0; i < strs.length; i++) {
                            pres[i] = criteriaBuilder.equal(root.get(entry.getKey()),strs[i]);
                        }
                        params.add(criteriaBuilder.or(pres));
                    }else {
                        params.add(criteriaBuilder.equal(root.get(entry.getKey()),entry.getValue()));
                    }

                }
                Predicate[] arr = new Predicate[params.size()];
                return criteriaBuilder.and(params.toArray(arr));
            }
        };
        return  chipDataRepository.findAll(spec);
    }

    @Override
    public void save(ChipData chipData) {
        chipDataRepository.save(chipData);
    }
}
