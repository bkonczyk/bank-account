package pl.sda.spring.bankaccount.domain.account;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Accessors(chain = true)
public class BankAccount {

    @Id
    @GeneratedValue
    private Long id;

    private String pesel;

    private String owner;

    private String mail;

    private BigDecimal balance;

    private Boolean isActive;

    @CreationTimestamp
    private LocalDateTime creationDateTime;

    @UpdateTimestamp
    private LocalDateTime updateDateTime;
}
