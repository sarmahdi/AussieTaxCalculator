///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package com.sarm.aussiepayslipgenerator.common;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// *
// * @author sarm
// */
//
//public enum BankingManager {
//instance;
///* find a list of all accounts */
//public List<Account> findAllAccounts() { return new ArrayList<>(); }
//
///* find a list of all accounts for a customer */
//public List<Account> findAccounts(Customer c) { return new ArrayList<>(); }
//
///* find an account by name -- what should the ??? be? */
//public Account findAccountByName(String accountName) { return new Account(); }
//
///* find an account by account number -- what should the ??? be? */
//public Account findAccountByNumber(Integer accountNumber) { return new Account();  }
//
///* save an Account to the persistent store */
//public void persist(Account account) {  }
//
///* convert an amount from one currency to another */
//public double convert(double amount, Currency fromCurrency, Currency toCurrency) { return new Double(10.00);}
//
//
///**
// * This method is called from a batch process like a one developed on 
// * Spring Batch with the interest rate. It's job is to calculate the daily 
// * interest rate at the end of each day.
// * Here an object of AccountDao is created, for simplicity. In Ideal scenario the AccountDao 
// * will be AutoWired to the BankingManager as well.
// * @param interestRate 
// */
////public void processEndOfDay(BigDecimal interestRate){
////AccountDao accountDao = new AccountDao();
////accountDao.processAccounts(interestRate);
////}
//
//}