package pl.sda.spring.bankaccount.domain.account;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

    List<BankAccount> findAllByIsActiveTrue();
}
