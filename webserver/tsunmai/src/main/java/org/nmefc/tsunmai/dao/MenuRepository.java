package org.nmefc.tsunmai.dao;

import org.nmefc.tsunmai.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MenuRepository  extends JpaSpecificationExecutor<MenuEntity>, JpaRepository<MenuEntity, Long> {

}
