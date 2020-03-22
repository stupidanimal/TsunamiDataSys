package org.nmefc.tsunmai.controller;

import org.nmefc.tsunmai.entity.StationInfoEntity;
import org.nmefc.tsunmai.service.inte.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedList;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: evase
 * \* Date: 2020/3/22
 * \* Time: 20:33
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
@RequestMapping("/station")
public class StationController {

    @Autowired
    private StationService stationService;

    @ResponseBody
    @GetMapping(value = "/all")
    public List<StationInfoEntity> getAllStationList() {
        List<StationInfoEntity> list = new LinkedList<>();
        list = stationService.getAllList();
        return list;
    }
}
