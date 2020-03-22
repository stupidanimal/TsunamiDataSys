package org.nmefc.tsunmai.service.impl;

import org.nmefc.tsunmai.dao.StationInfoRepository;
import org.nmefc.tsunmai.entity.StationInfoEntity;
import org.nmefc.tsunmai.service.inte.StationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: evase
 * \* Date: 2020/3/22
 * \* Time: 20:31
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Service
public class StationServiceImpl implements StationService {
    @Resource
    private StationInfoRepository stationInfoRepository;

    @Override
    public List<StationInfoEntity> getAllList() {
        return stationInfoRepository.findAll();
    }
}
