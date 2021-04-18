package pl.sda.spring.bankaccount.domain.account;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bank-accounts")
@RequiredArgsConstructor
@Slf4j
public class BankAccountController {

    private final BankAccountService service;

    @PutMapping("/add/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addAmount(@PathVariable Long id, @RequestBody AddAmountRequest amountRequest) {
        log.info("Received request to add money to account id {}", id);
        service.addToBankAccountBalance(id, amountRequest);
    }

    @GetMapping
    public List<AccountListView> getAllActiveAccounts() {
        log.info("Received request to get all active accounts");
        return service.getAllActive();
    }
}
