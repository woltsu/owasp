package owasp.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import owasp.domain.Account;

@Component
public class AccountDao {
    
    private final String TABLE = "Account";
    
    @Autowired
    private Database database;
    
    public List<Account> getAccounts() {
        List<Account> accounts = new ArrayList<>();
        try {
            ResultSet rs = database.getConnection().createStatement().executeQuery("SELECT * FROM " + TABLE);
            while (rs.next()) {
                accounts.add(new Account(rs.getString("username"), rs.getString("password")));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accounts;
    }
    
    public Account getAccountByUsername(String username) {
        for (Account account : this.getAccounts()) {
            if (account.getUsername().equals(username)) {
                return account;
            }
        }
        return null;
    }
    
}
