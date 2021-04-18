package pl.sda.spring.bankaccount.domain.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class CreateBankAccountRequest {

    private String pesel;
    private String owner;
    private String mail;
}
