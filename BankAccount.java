
package model;

/**
 *
 * @author Pacifique Harerimana
 */
public class BankAccount {
    private String accountName;
    private String accountNumber;
    private String accountType;
    private Double amount;

    public BankAccount() {
    }

    public BankAccount(String accountName, String accountNumber, String accountType, Double amount) {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.amount = amount;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
    
    
}
