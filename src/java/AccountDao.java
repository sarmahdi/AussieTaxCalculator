/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 * This class is the AccountManager just like BankingManager, but it is not a
 * singleton. BankingManager will in turn call/use this to perform the below
 * functions. I have tried to implement the functions using JDBC as well as used
 * more contemporary approach like Spring/Hibernate
 *
 * Repository annotation identifies this as a Spring Service so that Spring's
 * HibernateTemplate can be used as well
 *
 * @author sarm
 */
//@Repository
public class AccountDao {

//    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//    String connectionURL = "jdbc:mysql://localhost:3306/myDB";
//    static final String USER = "username";
//    static final String PASS = "password";
//
//    /**
//     * This is a Hibernate Session factory object and is injected using Spring's
//     * core Dependency Injection. This will be injected by using and defining
//     * the session factory in the Spring bean configuration xml file.
//     *
//     * It is used for hibernate operations either through hibernate directly or
//     * using spring's hibernateTemplate support.
//     */
//    @Autowired
//    private SessionFactory sessionFactory;
//
//    /**
//     * A customer provides an account name and wishes to make a payment to their
//     * account. This is the implementation if we were using Spring and
//     * hibernate, with a commented out example where you would want to use the
//     * Internal HibernateTemplate support provided by Spring.
//     *
//     * @param accountName
//     * @param payment
//     * @return - true if the payment is processed successfully - false if there
//     * was any exception during the payment process.
//     */
//    public boolean payByAccountName(String accountName, BigDecimal payment) {
//        try {
//            Account account = BankingManager.instance.findAccountByName(accountName);
//            BigDecimal outStandingBalance = account.getOutstandingBalance();
//            //If the payment is greater than the outstanding balance the new balance will be negative.
//            account.setOutstandingBalance(outStandingBalance.subtract(payment));
//
//            this.sessionFactory.getCurrentSession().update(account);
//            /**
//             * Alternatively : you can use HibernateTemplate which is a
//             * hibernate Support by Spring.
//             */
//            // new HibernateTemplate(sessionFactory).saveOrUpdate(account);
//            return true;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return false;
//        }
//
//    }
//
//    /**
//     * A customer provides an account name and wishes to make a payment to their
//     * account. This is the same method as before, It uses JDBC for persisting
//     * the new balance.
//     *
//     * @param accountName
//     * @param payment
//     * @return
//     * @throws ClassNotFoundException - thrown by Class.forName
//     * @throws InstantiationException - thrown by Class.forName().newInstance()
//     * @throws IllegalAccessException - thrown by Class.forName().newInstance()
//     */
//    public boolean payByAccountNameJDBC(String accountName, BigDecimal payment) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
//        Account account = BankingManager.instance.findAccountByName(accountName);
//        BigDecimal outStandingBalance = account.getOutstandingBalance();
//        //If the payment is greater than the outstanding balance the new balance will be negative.
//        account.setOutstandingBalance(outStandingBalance.subtract(payment));
//        Class.forName("com.mysql.jdbc.Driver").newInstance();
//        String sql = "UPDATE ACCOUNTS "
//                + "SET OUTSTANDING_BALANCE = ? WHERE ACCT_NAME = ?";
//        try (Connection conn = DriverManager.getConnection(connectionURL, USER, PASS);
//                PreparedStatement ps = conn.prepareStatement(sql);) {
//
//            ps.setBigDecimal(1, account.getOutstandingBalance());
//            ps.setString(2, accountName);
//            ps.executeUpdate();
//            return true;
//        } catch (SQLException se) {
//
//            se.printStackTrace();
//            return false;
//        } catch (Exception e) {
//
//            e.printStackTrace();
//            return false;
//        } finally {
//            // no need to clsoe resources as Try-With-Resources will close them.
//
//        }
//
//    }
//
//    /**
//     * The company wants to know the balance of an account identified by account
//     * number.
//     *
//     * @param accountName
//     * @param payment
//     * @return
//     */
//    public BigDecimal getBalanceByAccountName(String accountName, BigDecimal payment) {
//        Account account = BankingManager.instance.findAccountByName(accountName);
//        BigDecimal outStandingBalance = account.getOutstandingBalance();
//        return outStandingBalance;
//
//    }
//
//    /**
//     * The company wants to set the balance of an account identified by account
//     * number.
//     *
//     * It retrieves the account by using the singleton BankingManager's method
//     * findAccountByNumber(). It also uses the hibernate session factory to
//     * update the balance on the account.
//     *
//     * @param accountNumber
//     * @param newBalance
//     * @return - true if the update is successful - false if the the process
//     * threw an exception at any point
//     */
//    public boolean setBalanceByAccountName(Integer accountNumber, BigDecimal newBalance) {
//
//        try {
//
//            Account account = BankingManager.instance.findAccountByNumber(accountNumber);
//            account.setOutstandingBalance(newBalance);
//            this.sessionFactory.getCurrentSession().update(account);
//            return true;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return false;
//        }
//
//    }
//
//    /**
//     * The company wants to set the balance of an account identified by account
//     * number. It retrieves the account by using the singleton BankingManager's
//     * method findAccountByNumber(). This method uses a JDBC connection and a
//     * prepared statement to update the account balance.
//     *
//     * @param accountNumber
//     * @param newBalance
//     * @return - true if the update is done successfully - false if the process
//     * throws an exception at any point.
//     */
//    public boolean setBalanceByAccountNameJDBC(Integer accountNumber, BigDecimal newBalance) {
//
//        try {
//
//            Account account = BankingManager.instance.findAccountByNumber(accountNumber);
//            account.setOutstandingBalance(newBalance);
//
//            Class.forName("com.mysql.jdbc.Driver").newInstance();
//            String sql = "UPDATE ACCOUNTS "
//                    + "SET OUTSTANDING_BALANCE = ? WHERE ACCT_NAME = ?";
//            try (Connection conn = DriverManager.getConnection(connectionURL, USER, PASS);
//                    PreparedStatement ps = conn.prepareStatement(sql);) {
//
//                ps.setBigDecimal(1, account.getOutstandingBalance());
//                ps.setInt(2, accountNumber);
//                ps.executeUpdate();
//                return true;
//
//            } catch (SQLException se) {
//
//                se.printStackTrace();
//                return false;
//            } catch (Exception e) {
//
//                e.printStackTrace();
//                return false;
//            } finally {
//                // no need to close resources as Try-With-Resources will close them.
//
//            }
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return false;
//        }
//
//    }
//
//    /**
//     * This method processes all accounts and calculates the daily interest
//     * rate, adds the rate to the accrued interest, adds the interest to
//     * projecttedEndOfMonthBalance. At the end calls the processForEndOfMonth()
//     * method for end of month where the accrued interest is added into the
//     * actual balance. As we are calculating daily interest and storing it I do
//     * not see the need to calculate it through the usual formula interest =()
//     *
//     * The transactional annotation will make sure that the transaction is
//     * atomic and rolled back in case of any issue during the process
//     * 
//     * @param interestRate
//     */
//    @org.springframework.transaction.annotation.Transactional
//    public void processAccounts(BigDecimal interestRate) {
//        List<Account> accounts = BankingManager.instance.findAllAccounts();
//
//        for (Account account : accounts) {
//            BigDecimal actualBalance = account.getOutstandingBalance();
//            BigDecimal dailyInterest = actualBalance.multiply(interestRate.divide(new BigDecimal(100)));
//            account.setAccruedInterest(dailyInterest.add(account.getAccruedInterest()));
//            account.setProjectedEndofmonthBalance(account.getProjectedEndofmonthBalance().add(dailyInterest));
//            //this.sessionFactory.getCurrentSession().save(account);
//            new HibernateTemplate(sessionFactory).saveOrUpdate(account);
//            processForEndOfMonth();
//
//        }
//    }
//
//    /**
//     *
//     * @param actualBalance
//     * @param interestRate
//     * @param compoundtimes
//     * @return - BigDecimal dailyInterest
//     */
//    BigDecimal calculateInterest(BigDecimal actualBalance, BigDecimal interestRate, int compoundtimes) {
//
//        return null;
//    }
///**
// * This method updates the outstanding balance with the accrued interest over the month
// * it compares the last day of the month with today and if they are equal 
// */
//    private void processForEndOfMonth() {
////        int lastDateOfMonth = Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH);
//        Calendar lastDayOfMonth = Calendar.getInstance();
//        lastDayOfMonth.setTime(new Date());
//        lastDayOfMonth.set(Calendar.DAY_OF_MONTH, lastDayOfMonth.getActualMaximum(Calendar.DAY_OF_MONTH));
//
//        Calendar today = Calendar.getInstance();
//        today.set(Calendar.HOUR_OF_DAY, 0);
//
//        if (today.compareTo(lastDayOfMonth) == 0) {
//            List<Account> accounts = BankingManager.instance.findAllAccounts();
//
//            for (Account account : accounts) {
//                account.setOutstandingBalance(account.getAccruedInterest().add(account.getOutstandingBalance()));
//                //as the accrued interest is only for the month so it is reset for the next month.
//                account.setAccruedInterest(BigDecimal.ZERO);
//
//                if (account.getOutstandingBalance().equals(account.getProjectedEndofmonthBalance())) {
//                    //the calculations have beed right 
//                }
//            }
//        }
//    }
//    
//    public static void main(String args[]){
//    Calendar lastDayOfMonth = Calendar.getInstance();
//        lastDayOfMonth.setTime(new Date());
//        lastDayOfMonth.set(Calendar.DAY_OF_MONTH, lastDayOfMonth.getActualMaximum(Calendar.DAY_OF_MONTH));
//System.out.println("lastDayOfMonth"+lastDayOfMonth.toString() ) ;
//
//System.out.println("lastDayOfMonth  is in time  "+lastDayOfMonth.getTime() ) ;
//        Calendar today = Calendar.getInstance();
//        today.set(Calendar.HOUR_OF_DAY, 0);
//        
//        System.out.println("today is"+ today.toString());
//        
//         System.out.println("today is in time "+ today.getTime());
//
//        if (today.compareTo(lastDayOfMonth) == 0) {
//        System.out.print("today is not the last day of the month");
//        }
//    }

}
