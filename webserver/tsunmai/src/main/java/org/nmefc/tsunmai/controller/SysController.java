package org.nmefc.tsunmai.controller;

import org.nmefc.tsunmai.entity.MenuEntity;
import org.nmefc.tsunmai.service.inte.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedList;
import java.util.List;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
@RequestMapping("/sys")
public class SysController {
    @Autowired
    private MenuService menuService;

    @ResponseBody
    @GetMapping(value="/getMenus")
    public List<MenuEntity> getMenus(){
        List<MenuEntity> list = new LinkedList<>();
        list = menuService.getAllMenus();
        return list;
    }
}
