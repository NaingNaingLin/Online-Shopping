package com.mos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mos.domain.Account;
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

}
