package com.example.mybatis;

import com.example.mybatis.entity.Account;
import com.example.mybatis.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/account")
public class AccountCountroller {

    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Account> getAccounts(){
        return accountService.findAccountList();
    }

    @RequestMapping(value = "/pagelist",method = RequestMethod.GET)
    public List<Account> getPageAccounts(@RequestParam(value = "pageNum",required = true) int pageNum, @RequestParam(value = "pageSize",required = true)int pageSize){
        return accountService.findAccountPageList(pageNum,pageSize);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public  Account getAccountById(@PathVariable("id") int id){
        return accountService.findAccount(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public  String updateAccount(@PathVariable("id")int id , @RequestParam(value = "name",required = true)String name,
                                 @RequestParam(value = "money" ,required = true)double money){
        int t=accountService.update(name,money,id);
        if(t==1){
            return "success";
        }else {
            return "fail";
        }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public  String deleteAccount(@PathVariable("id")int id ){
        int t=accountService.delete(id);
        if(t==1){
            return "success";
        }else {
            return "fail";
        }
    }


    @RequestMapping(value = "",method = RequestMethod.POST)
    public  String postAccount( @RequestParam(value = "name")String name,
                                @RequestParam(value = "money" )double money){
        int t= accountService.add(name,money);
        if(t==1){
            return "success";
        }else {
            return "fail";
        }

    }

    @RequestMapping(value = "/some",method = RequestMethod.POST)
    public  String postSomeAccount(){
        List<Account> list = new ArrayList<>();
        Account account1 = new Account("batch1",123);
        Account account2 = new Account("batch2",123);
        Account account3 = new Account("batch3",123);
        list.add(account1);
        list.add(account2);
        list.add(account3);


        int t= accountService.addAll(list);
        if(t==1){
            return "success";
        }else {
            return "fail";
        }

    }

}
