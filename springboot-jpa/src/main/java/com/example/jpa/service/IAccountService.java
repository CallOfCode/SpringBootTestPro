package com.example.jpa.service;

import com.example.jpa.entity.Account;

import java.util.List;

public interface IAccountService {
    Account add(Account account);

    Account update(Account account);

    void delete(int id);

    Account findAccountById(int id);

    List<Account> findAccountList();
}
