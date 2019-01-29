package dao;

import connection.MySqlDbConnection;
import model.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAOImpl implements AccountDAO {


    @Override
    public Account getAccountByName(String firstName){
        Account account = new Account();
        String sql = "Select * From account where first_name=?";
        ResultSet rs =  null;

        try (Connection con= MySqlDbConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)){
             stmt.setString(1,firstName);
             rs =stmt.executeQuery();
            while(rs.next()){
                account.setId(rs.getInt("id"));
                account.setFirstName(rs.getString("first_name"));
                account.setLastName(rs.getString("last_name"));
            }
            return account;
        }catch (SQLException ex){
            System.err.println("Error: "+ ex);
            return null;
        }finally {
            if(rs!=null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    @Override
    public int updateLastName(Account account){
        int accountUpdated = 0;
        String sql = "update account set last_name=? where first_name=?";
        try(Connection con= MySqlDbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1,account.getLastName());
            ps.setString(2,account.getFirstName());
            accountUpdated = ps.executeUpdate();
            return accountUpdated;
        }catch (SQLException ex){
            System.err.println("Error: "+ ex);
            return accountUpdated;
        }
    }

    @Override
    public void updateLastName(String firstName,String newLastName){
        String sql = "update account set last_name=? where first_name=?";
        try(Connection con= MySqlDbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1,newLastName);
            ps.setString(2,firstName);
            ps.executeUpdate();
        }catch (SQLException ex){
            System.err.println("Error: "+ ex);
        }
    }
}
