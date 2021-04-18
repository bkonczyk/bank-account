package pl.sda.spring.bankaccount.domain.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountListView {

    private String owner;

    private BigDecimal balance;
}
