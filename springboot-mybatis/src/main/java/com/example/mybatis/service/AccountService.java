package com.example.mybatis.service;

import com.example.mybatis.dao.AccountMapper;
import com.example.mybatis.entity.Account;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountMapper accountMapper;

    public int add(String name,double money){
        return accountMapper.add(name,money);
    }

    public int addAll(List<Account> list){
        return accountMapper.addAll(list);
    }

    public int update(String name, double money, int id) {
        return accountMapper.update(name, money, id);
    }
    public int delete(int id) {
        return accountMapper.delete(id);
    }
    public Account findAccount(int id) {
        return accountMapper.findAccount(id);
    }
//    public List<Account> findAccountList() {
//        return accountMapper.findAccountList();
//    }

    public List<Account> findAccountList(String name,Double money){
        return accountMapper.findAccountList(name,money);
    }


    public List<Account> findAccountPageList(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return accountMapper.findAccountPageList();
    }
}
