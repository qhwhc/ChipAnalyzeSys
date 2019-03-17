package com.ccc.smse.service.impl;

import com.ccc.smse.dao.WebMenuRepository;
import com.ccc.smse.pojo.WebMenu;
import com.ccc.smse.service.WebMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
@Service
public class WebMenuServiceImpl implements WebMenuService {
    @Autowired
    WebMenuRepository webMenuRepository;

    @Override
    public List<WebMenu> findAll() {
        return webMenuRepository.findAll();
    }
}
