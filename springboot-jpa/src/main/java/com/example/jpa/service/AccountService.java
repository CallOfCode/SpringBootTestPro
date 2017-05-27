package com.example.jpa.service;

import com.example.jpa.dao.AccountDao;
import com.example.jpa.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService {
    @Autowired
    AccountDao dao;

    @Override
    public Account add(Account account) {
        return dao.save(account);
    }

    @Override
    public Account update(Account account) {
        return dao.saveAndFlush(account);
    }

    @Override
    public void delete(int id) {dao.delete(id);}

    @Override
    public Account findAccountById(int id) {
        return dao.findOne(id);
    }

    @Override
    public List<Account> findAccountList() {
        return dao.findAll();
    }
}
