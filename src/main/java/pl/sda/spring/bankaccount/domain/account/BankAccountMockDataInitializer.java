package pl.sda.spring.bankaccount.domain.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BankAccountMockDataInitializer {

    private final BankAccountService service;

    @PostConstruct
    public void initializeData() {
        List<CreateBankAccountRequest> accounts = createRandomAccounts();
        accounts.forEach(service::createAccount);
    }

    private List<CreateBankAccountRequest> createRandomAccounts() {
        return List.of(
            new CreateBankAccountRequest()
                .setPesel("123456789")
                .setMail("admin@o2.pl")
                .setOwner("Adrian Duda"),
            new CreateBankAccountRequest()
                .setPesel("987456123")
                .setMail("admin@onet.pl")
                .setOwner("Andrzej Duda"),
            new CreateBankAccountRequest()
                .setPesel("666666666")
                .setMail("admin@interia.pl")
                .setOwner("Apoloniusz Kajner")
        );
    }
}
