package org.nmefc.tsunmai.service.impl;

import org.nmefc.tsunmai.dao.MenuRepository;
import org.nmefc.tsunmai.entity.MenuEntity;
import org.nmefc.tsunmai.service.inte.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Resource
    MenuRepository menuRepository;
    @Override
    public List<MenuEntity> getAllMenus() {
        List<MenuEntity> list = menuRepository.findAll();
        return list;
    }
}
