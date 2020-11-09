package be.pxl.ja.streamingservice.model;

import java.time.LocalDate;

public class PaymentInfo {
    private CreditCardNumber cardNumber;
    private CreditCardType type;
    private String firstName;
    private String lastName;
    private LocalDate expirationDate;
    private int securityCode;

    public PaymentInfo() {
    }

    public void setCardNumber(CreditCardNumber cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setType(CreditCardType type) {
        this.type = type;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSecurityCode(int securityCode) {
        this.securityCode = securityCode;
    }

    public CreditCardNumber getCardNumber() {
        return cardNumber;
    }

    public CreditCardType getType() {
        return type;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public int getSecurityCode() {
        return securityCode;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        if (LocalDate.now().plusMonths(1).isAfter(expirationDate)){
            throw new InvalidDateException(expirationDate,"expirationDate","Must be valid for at least 1 month.");
        }
        this.expirationDate = expirationDate;
    }
}