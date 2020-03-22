package org.nmefc.tsunmai.service.inte;

import org.nmefc.tsunmai.entity.StationInfoEntity;

import java.util.List;

public interface StationService {

    /**
     * @return :
     * @Author : evaseemefly
     * @Description : 获取全部的 station 集合
     * @params :
     * @Date : 2020/3/22 20:30
     */
    List<StationInfoEntity> getAllList();
}
