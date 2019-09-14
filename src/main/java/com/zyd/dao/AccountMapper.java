package com.zyd.dao;

import com.zyd.pojo.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AccountMapper {

    //添加数据
    public int add(Account account);

    //更新数据
    public int update(Account account);
    //删除数据
    public int delete(Long id);

    //查询单个对象
    public Account findAccountById(Long id);

    //查询所有
    public List<Account> findAccountAll();

}
