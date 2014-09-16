/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Table;

/**
 * This bean represents an Account
 * @author sarm
 */
//@Table(name = "ACCOUNTS")
public class Account {
// 
//    
////The name of the account mapped with column ACCT_NAME
//    @Column(name="ACCT_NAME")
//    private String accountName;
//    
//    //the actual identifier for an account Mapped with ACCT_NUM
//    @Column(name="ACCT_NUM")
//    private Integer accountNumber;
//    //Preferred Curency Enum
//    @Column(name="CURRENCY_TYPE")
//    private Currency preferredCurrency;
//
//    /**
//     * the outstanding payable balance. This is what the account holder needs 
//     * to pay off to the company. BigDecimal is more preferred over Double
//     * due to its precision
//     */
//    @Column(name="OUTSTANDING_BALANCE")
//    private BigDecimal outstandingBalance;
//    
//    /**
//* This is the Balance where the interest is compounded daily and added to it for calculation of interest
//* Everyday a job will be processed to calculate the interest on this value and at the end of the month this value will become the accountBalance.
//*/
//    @Column(name="PROJCTD_EOM_BALANCE")
//BigDecimal projectedEndofmonthBalance ;
///**
//* This is the interest that is accrued over the whole month using the projectedEndofmonthBalance as the balance on which the interest is calculated
//* In essence : accruedInterest added onto the Account Balance should be equal to projectedEndofmonthBalance at the end of month and this value should be added
//* to the accountBalance
//*/
//    @Column(name="ACCRUED_INTREST")
//
//BigDecimal accruedInterest;
///** getter and setter**/
//
//    public String getAccountName() {
//        return accountName;
//    }
//
//    public void setAccountName(String accountName) {
//        this.accountName = accountName;
//    }
//
//    public Integer getAccountNumber() {
//        return accountNumber;
//    }
//
//    public void setAccountNumber(Integer accountNumber) {
//        this.accountNumber = accountNumber;
//    }
//
//    public Currency getPreferredCurrency() {
//        return preferredCurrency;
//    }
//
//    public void setPreferredCurrency(Currency preferredCurrency) {
//        this.preferredCurrency = preferredCurrency;
//    }
//
//    public BigDecimal getOutstandingBalance() {
//        return outstandingBalance;
//    }
//
//    public void setOutstandingBalance(BigDecimal outstandingBalance) {
//        this.outstandingBalance = outstandingBalance;
//    }
//
//    public BigDecimal getProjectedEndofmonthBalance() {
//        return projectedEndofmonthBalance;
//    }
//
//    public void setProjectedEndofmonthBalance(BigDecimal projectedEndofmonthBalance) {
//        this.projectedEndofmonthBalance = projectedEndofmonthBalance;
//    }
//
//    public BigDecimal getAccruedInterest() {
//        return accruedInterest;
//    }
//
//    public void setAccruedInterest(BigDecimal accruedInterest) {
//        this.accruedInterest = accruedInterest;
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 5;
//        hash = 19 * hash + Objects.hashCode(this.accountNumber);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Account other = (Account) obj;
//        if (!Objects.equals(this.accountNumber, other.accountNumber)) {
//            return false;
//        }
//        if (!Objects.equals(this.outstandingBalance, other.outstandingBalance)) {
//            return false;
//        }
//        return true;
//    }
//    
//    
//    
//    
//    
}
