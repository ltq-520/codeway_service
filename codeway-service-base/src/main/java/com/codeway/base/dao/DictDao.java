package com.codeway.base.dao;

import com.codeway.pojo.base.Dict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DictDao extends JpaRepository<Dict, String>, JpaSpecificationExecutor<Dict>, QuerydslPredicateExecutor<Dict> {

    @Modifying
    @Query("delete from Dict where id in (:ids)")
    void deleteBatch(@Param("ids") List<String> ids);

    List<Dict> findAllByType(String type);

    List<Dict> findByParentId(String parentId);
}
