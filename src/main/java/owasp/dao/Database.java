package owasp.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.annotation.PostConstruct;
import org.h2.tools.RunScript;
import org.springframework.stereotype.Component;

@Component
public class Database {
    
    private Connection connection;
    
    @PostConstruct
    private void initializeDatabase() throws Exception {
         String databaseAddress = "jdbc:h2:file:./database";
         connection = DriverManager.getConnection(databaseAddress, "sa", "");
         
         try {
            RunScript.execute(connection, new FileReader("sql/database-schema.sql"));
            RunScript.execute(connection, new FileReader("sql/database-import.sql"));
         } catch (Exception e) {
             e.printStackTrace();
         }
    }
    
    public Connection getConnection() {
        return this.connection;
    }
    
}
