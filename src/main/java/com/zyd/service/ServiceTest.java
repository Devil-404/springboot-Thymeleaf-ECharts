package com.zyd.service;

import com.zyd.dao.AccountMapper;
import com.zyd.pojo.Account;
import com.zyd.service.impl.AccountServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ServiceTest {
    IAccountService iAccountService = new AccountServiceImpl();

    @Test
    public void all(){
        System.out.println(123);
        System.out.println(iAccountService.findAccountAll());
    }
}
