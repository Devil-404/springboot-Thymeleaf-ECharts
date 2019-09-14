package com.zyd.service.impl;

import com.zyd.dao.AccountMapper;
import com.zyd.dao.AccountMapper2;
import com.zyd.pojo.Account;
import com.zyd.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public int add(Account account) {
        return accountMapper.add(account);
    }

    @Override
    public int update(Account account) {
        return accountMapper.update(account);
    }

    @Override
    public int delete(Long id) {
        return accountMapper.delete(id);
    }

    @Override
    public Account findAccountById(Long id) {
        return accountMapper.findAccountById(id);
    }

    @Override
    public List<Account> findAccountAll() {
        return accountMapper.findAccountAll();
    }
}
