package pl.sda.spring.bankaccount.domain.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BankAccountService {

    private final BankAccountRepository repository;

    public void createAccount(CreateBankAccountRequest request) {
        BankAccount account = BankAccountMapper.mapToAccountFromRequest(request);
        repository.save(account);
    }

    public void addToBankAccountBalance(Long id, AddAmountRequest request) {
        BankAccount account = repository.findById(id).orElseThrow(NoSuchElementException::new);
        BigDecimal newBalance = account.getBalance().add(request.getAmount());
        account.setBalance(newBalance);
        repository.save(account);
    }

    public List<AccountListView> getAllActive() {
        return repository.findAllByIsActiveTrue().stream()
            .map(BankAccountMapper::mapToListView)
            .collect(Collectors.toList());
    }

    // 1. Wystawić w kontrolerze metodę, która zwróci nam wszystkie aktywne konta
    // 2. Stworzymy DTO AccountListView(owner i balance)
    // 3. W repo trzeba stworzyć metodę, która nam zwróci wszystkie aktywne accounty
    // 4. W servicie metodę która obsłuży wywołanie na repo, zmapuje odpowiedź na DTO
    // 5. W kontrolerze endpoint, który nam udostępni listę dto
}
