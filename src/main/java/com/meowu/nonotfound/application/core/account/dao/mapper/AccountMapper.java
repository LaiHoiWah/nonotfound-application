package com.meowu.nonotfound.application.core.account.dao.mapper;

import com.meowu.account.client.entity.response.AccountVo;
import com.meowu.plugins.mybatis.criteria.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AccountMapper{

    void save(AccountVo account);

    void update(AccountVo account);

    AccountVo get(@Param("params") Criteria criteria);

    Long count(@Param("params") Criteria criteria);
}
