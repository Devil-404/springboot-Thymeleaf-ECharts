package com.zyd.controller;

import com.zyd.pojo.Account;
import com.zyd.service.IAccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 此类为测试swagger2:
 * (坑)
 * 使用swagger2的时候注意，
 * 因为swagger-annotations、swagger-models默认使用的是1.5.20版本，
 * 使用@ApiImplicitParam的时候会导致类型转换错误，需要手动将这两个依赖
 * 升级到1.5.21版本，如下：
 *
 *      //先在springfox-swagger2禁用swagger-annotations、swagger-models
 *      <dependency>
 *       <groupId>io.springfox</groupId>
 *       <artifactId>springfox-swagger2</artifactId>
 *       <version>2.9.2</version>
 *       <exclusions>
 *         <exclusion>
 *           <groupId>io.swagger</groupId>
 *           <artifactId>swagger-annotations</artifactId>
 *         </exclusion>
 *         <exclusion>
 *           <groupId>io.swagger</groupId>
 *           <artifactId>swagger-models</artifactId>
 *         </exclusion>
 *       </exclusions>
 *     </dependency>
 *
 *     //手动添加swagger-annotations、swagger-models的1.5.21版本的依赖
 *     <dependency>
 *       <groupId>io.swagger</groupId>
 *       <artifactId>swagger-annotations</artifactId>
 *       <version>1.5.21</version>
 *     </dependency>
 *     <dependency>
 *       <groupId>io.swagger</groupId>
 *       <artifactId>swagger-models</artifactId>
 *       <version>1.5.21</version>
 *     </dependency>
 *
 */
@RestController
@RequestMapping(value = "/Account")
@Api(value = "USER",description = "Account的增删改查")
public class AccountController {

    @Autowired
    private IAccountService iAccountService;

    @ApiOperation(value="查询所有用户",notes="查询所有用户信息")
    @PostMapping(value = "/AccountList")
    public List<Account> list(){
        return iAccountService.findAccountAll();
    }

    @ApiOperation(value="获取指定id用户信息",notes="根据Account的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Long")
    @PostMapping(value = "/AccountList/{id}")
    public Account list(@PathVariable(value = "id") Long id){
        return iAccountService.findAccountById(id);
    }

    @ApiOperation(value="更新用户信息",notes="根据id更新用户信息")
    @PostMapping(value = "/AccountUpdate")
    public int update(Account account){
        return iAccountService.update(account);
    }

    @ApiOperation(value="删除用户",notes="根据id删除用户信息")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Long")
    @PostMapping(value = "/AccountDelete/{id}")
    public int delete(@PathVariable(value = "id")Long id){
        return iAccountService.delete(id);
    }


    @ApiOperation(value="创建用户",notes="根据Account对象创建用户")
    @PostMapping(value = "/AccountAdd")
    public int add(Account account){
        return iAccountService.add(account);
    }

    @ApiOperation(value="测试",notes="测试Controller")
    @PostMapping(value = "/abc")
    public String a(){
        return "123321";
    }






}
