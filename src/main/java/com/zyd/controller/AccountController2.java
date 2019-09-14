package com.zyd.controller;

import com.zyd.pojo.Account;
import com.zyd.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 此类为测试thymeleaf和echarts:
 * (坑)
 * 使用RestController返回值显示在页面上
 * 使用Controller返回值为相对页面地址
 * (坑2)
 * 使用thymeleaf时需要在配置文件写入：
 *   mvc:
 *     #配置静态文件(坑)，其中/static为静态文件路径
 *     static-path-pattern: /static/**
 * 否则前端页面将无法访问js、css静态资源等
 */
@Controller
@RequestMapping(value = "/Account2")
public class AccountController2 {

    @Autowired
    private IAccountService iAccountService;


    @GetMapping(value = "/AccountList")
    public List<Account> list(){
        return iAccountService.findAccountAll();
    }

    @GetMapping(value = "/AccountList/{id}")
    public Account list(@PathVariable(value = "id") Long id){
        return iAccountService.findAccountById(id);
    }

    @GetMapping(value = "/AccountUpdate")
    public int update(Account account){
        return iAccountService.update(account);
    }

    @GetMapping(value = "/AccountDelete/{id}")
    public int delete(@PathVariable(value = "id")Long id){
        return iAccountService.delete(id);
    }


    @GetMapping(value = "/AccountAdd")
    public int add(Account account){
        return iAccountService.add(account);
    }

    @GetMapping(value = "/abc")
    public String a(){
        return "123321";
    }


    @GetMapping(value = "/a")
    public ModelAndView pu(){
        ModelAndView mv = new ModelAndView();
        Account account = new Account();
        account.setName("bug");
        account.setMoney(123456);
        mv.addObject("account",account);
        mv.setViewName("/show.html");
        return mv;
    }

    @GetMapping(value = "/c")
    public String c(){

        return "/index";
    }

    @GetMapping(value = "/b")
    public String b(){
        return "/demo";
    }

    @RequestMapping("/echarts")
    public String myECharts(Model model){

        String skirt = "裙子";
        int nums = 30;

        model.addAttribute("skirt", skirt);
        model.addAttribute("nums", nums);

        return "/demo";
    }




}
