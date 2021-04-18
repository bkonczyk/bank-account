package pl.sda.spring.bankaccount.domain.account;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AddAmountRequest {

    private BigDecimal amount;
}
