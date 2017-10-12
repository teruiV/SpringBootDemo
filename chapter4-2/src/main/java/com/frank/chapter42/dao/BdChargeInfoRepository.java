package com.frank.chapter42.dao;

import com.frank.chapter42.domain.BdChargeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by jianweilin on 2017/10/11.
 */
public interface BdChargeInfoRepository extends JpaRepository<BdChargeInfo,Integer> {
    BdChargeInfo findByName(String name);

    BdChargeInfo findByNameAndAge(String name,Integer age);

    @Query("select b from BdChargeInfo b where b.name=:name")
    BdChargeInfo findUser(@Param("name") String name);
}
