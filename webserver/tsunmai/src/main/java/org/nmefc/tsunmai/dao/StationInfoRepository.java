package org.nmefc.tsunmai.dao;

import org.nmefc.tsunmai.entity.StationInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StationInfoRepository extends JpaSpecificationExecutor<StationInfoEntity>, JpaRepository<StationInfoEntity, Long> {

}
