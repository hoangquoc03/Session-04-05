package org.example.bankingdockercompose.repository;


import org.example.bankingdockercompose.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}