package com.example.jdbc.service;

import com.example.jdbc.entity.Account;

import java.util.List;

public interface IAccountService {
    int add(Account account);

    int update(Account account);

    int delete(int id);

    Account findAccountById(int id);

    List<Account> findAccountList();
}
