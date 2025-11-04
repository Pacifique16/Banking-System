package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.BankAccount;

/**
 *
 * @author Pacifique Harerimana
 */
public class BankAccountDao {
    // JDBC Properties
    private String jdbcUrl = "jdbc:postgresql://localhost:5432/java_thursday_2025";
    private String dbUsername = "postgres";
    private String dbPassword = "postgres";
    
    // CREATE Operation
    
// CREATE
public Integer createBankAccount(BankAccount accountObj) {
    try (Connection con = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword)) {
        String sql = "INSERT INTO bank_account (account_number, account_name, account_type, amount) VALUES (?, ?, ?, ?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, accountObj.getAccountNumber());
        pst.setString(2, accountObj.getAccountName());
        pst.setString(3, accountObj.getAccountType());
        pst.setDouble(4, accountObj.getAmount());
        return pst.executeUpdate();

    } catch (org.postgresql.util.PSQLException ex) {
        String sqlState = ex.getSQLState();

        if ("23505".equals(sqlState)) {
            // Unique or primary key constraint violation
            JOptionPane.showMessageDialog(null,
                "An account with this number already exists!",
                "Duplicate Account",
                JOptionPane.WARNING_MESSAGE);

        } else if ("23502".equals(sqlState)) {
            // Not-null constraint violation
            JOptionPane.showMessageDialog(null,
                "Please fill in all required fields before saving.",
                "Missing Data",
                JOptionPane.WARNING_MESSAGE);

        } else if ("22P02".equals(sqlState)) {
            // Invalid text representation (e.g., wrong number format)
            JOptionPane.showMessageDialog(null,
                "Invalid data type entered — please check numeric fields.",
                "Invalid Input",
                JOptionPane.WARNING_MESSAGE);

        } else {
            // Other PostgreSQL error
            JOptionPane.showMessageDialog(null,
                "Database error: " + ex.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }

        return 0;

    } catch (Exception ex) {
        // Catch any non-SQL error (e.g., null pointer, driver issue)
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null,
            "Unexpected error: " + ex.getMessage(),
            "Error",
            JOptionPane.ERROR_MESSAGE);
        return 0;
    }
}

    
    
    // READ (Search by account_number)
    public BankAccount searchBankAccount(String accountNumber) {
        try (Connection con = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword)) {
            System.out.println("Searching for account: [" +accountNumber+"]");
            
            String sql = "SELECT * FROM bank_account WHERE account_number = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, accountNumber);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                System.out.println("Account found");
                return new BankAccount(
                    rs.getString("account_name"),
                    rs.getString("account_number"),
                    rs.getString("account_type"),
                    rs.getDouble("amount")
                );
            }else {
                System.out.println("No results returned from database.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    // UPDATE
    public Integer updateBankAccount(BankAccount accountObj) {
        try (Connection con = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword)) {
            String sql = "UPDATE bank_account SET account_name=?, account_type=?, amount=? WHERE account_number=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, accountObj.getAccountName());
            pst.setString(2, accountObj.getAccountType());
            pst.setDouble(3, accountObj.getAmount());
            pst.setString(4, accountObj.getAccountNumber());
            return pst.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    // DELETE
    public Integer deleteBankAccount(String accountNumber) {
        try (Connection con = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword)) {
            String sql = "DELETE FROM bank_account WHERE account_number = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, accountNumber);
            return pst.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    // RETRIEVE (All)
    public List<BankAccount> retrieveAll() {
        List<BankAccount> list = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword)) {
            String sql = "SELECT * FROM bank_account ORDER BY account_number";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                list.add(new BankAccount(
                    rs.getString("account_name"),
                    rs.getString("account_number"),
                    rs.getString("account_type"),
                    rs.getDouble("amount")
                ));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
}


