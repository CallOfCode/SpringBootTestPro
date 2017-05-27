package com.example.jpa.dao;

import com.example.jpa.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDao extends JpaRepository<Account,Integer>{

}
