package com.zyd.service;

import com.zyd.pojo.Account;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IAccountService {
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
