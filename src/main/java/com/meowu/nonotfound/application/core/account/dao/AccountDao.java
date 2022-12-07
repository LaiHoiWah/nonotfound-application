package com.meowu.nonotfound.application.core.account.dao;

import com.meowu.account.client.entity.response.AccountVo;
import com.meowu.commons.utils.AssertUtils;
import com.meowu.nonotfound.application.core.account.dao.mapper.AccountMapper;
import com.meowu.plugins.mybatis.criteria.Criteria;
import com.meowu.plugins.mybatis.criteria.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDao{

    @Autowired
    private AccountMapper mapper;

    public void saveOrUpdate(AccountVo account){
        AssertUtils.notNull(account, "account: entity must not be null");
        AssertUtils.hasText(account.getId(), "account: id must not be null");

        // if no records then create a new
        // if not then update
        if(existById(account.getId())){
            mapper.save(account);
        }else{
            mapper.update(account);
        }
    }

    public AccountVo getById(String id){
        AssertUtils.hasText(id, "account: id must not be null");

        // conditions
        Criteria criteria = new Criteria();
        criteria.add(Restrictions.eq(AccountVo::getId, id));

        // return
        return mapper.get(criteria);
    }

    public boolean existById(String id){
        AssertUtils.hasText(id, "account: id must not be null");

        // conditions
        Criteria criteria = new Criteria();
        criteria.add(Restrictions.eq(AccountVo::getId, id));

        // count
        Long total = mapper.count(criteria);

        // return
        return (total != null && total > 0);
    }
}
