package com.example.BaiTap2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.BaiTap2.Model.Account;

public interface AccountRepositpry extends JpaRepository<Account, Integer> {

    Optional<Account> findByLoginName(String loginName);

}
