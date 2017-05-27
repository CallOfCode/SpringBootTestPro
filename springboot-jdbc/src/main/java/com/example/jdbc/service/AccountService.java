package com.example.jdbc.service;

import com.example.jdbc.dao.IAccountDAO;
import com.example.jdbc.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService {
    @Autowired
    IAccountDAO dao;

    @Override
    public int add(Account account) {
        return dao.add(account);
    }

    @Override
    public int update(Account account) {
        return dao.update(account);
    }

    @Override
    public int delete(int id) {
        return dao.delete(id);
    }

    @Override
    public Account findAccountById(int id) {
        return dao.findAccountById(id);
    }

    @Override
    public List<Account> findAccountList() {
        return dao.findAccountList();
    }
}
