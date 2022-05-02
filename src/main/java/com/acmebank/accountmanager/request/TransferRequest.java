package com.acmebank.accountmanager.request;


import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

@Validated
public class TransferRequest {

    @Pattern(regexp = "^\\d{8}$", message = "Invalid account id pattern.")
    private String accountFromId;

    @Pattern(regexp = "^\\d{8}$", message = "Invalid account id pattern.")
    private String accountToId;

    @DecimalMin(value = "0.0", inclusive = false, message = "Amount must be greater than zero.")
    @Digits(integer = 19, fraction = 6)
    private BigDecimal amount;

    @Pattern(regexp = "^HKD$", message = "Currency must be HKD.")
    private String currency;

    public String getAccountFromId() {
        return accountFromId;
    }

    public void setAccountFromId(String accountFromId) {
        this.accountFromId = accountFromId;
    }

    public String getAccountToId() {
        return accountToId;
    }

    public void setAccountToId(String accountToId) {
        this.accountToId = accountToId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
