package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDbConnection {
    private static final String HOST="jdbc:mysql://localhost:3306";
    private static final String DBNAME="test_account";
    private static final String URL=HOST+"/"+DBNAME;
    private static final String USER="root";
    private static final String PASS="llirik2";
    private static Connection con;

    public static Connection getConnection() throws SQLException{
            if (con==null || con.isClosed()){
          con= DriverManager.getConnection(URL, USER, PASS);}
          return con;

    }

}
