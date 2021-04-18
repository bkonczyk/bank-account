package pl.sda.spring.bankaccount.domain.account;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BankAccountMapper {

    public static BankAccount mapToAccountFromRequest(CreateBankAccountRequest request) {
        return new BankAccount()
            .setPesel(request.getPesel())
            .setOwner(request.getOwner())
            .setMail(request.getMail())
            .setIsActive(Boolean.TRUE)
            .setBalance(BigDecimal.ZERO);
    }

    public static AccountListView mapToListView(BankAccount bankAccount) {
        return new AccountListView(bankAccount.getOwner(), bankAccount.getBalance());
    }
}
