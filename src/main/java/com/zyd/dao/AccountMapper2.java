package com.zyd.dao;

import com.zyd.pojo.Account;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface AccountMapper2 {
    //添加数据
    @Insert("insert into account (name,money) values(#{name},#{money})")
    public int add(Account account);
    //更新数据
    @Update("update account set name=#{name},money=#{money} where id=#{id}")
    public int update(Account account);
    //删除数据
    @Delete("delete from account where id=#{id}")
    public int delete(Integer id);
    //查询单个对象
    @Select("select id,name,money from account where id=#{id}")
    public Account findAccountById(@Param("id")Integer id);
    //查询所有
    @Select("select id,name,money from account")
    public List<Account> findAccountAll();
}
