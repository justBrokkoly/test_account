package dao;

import model.Account;

public interface AccountDAO {

    Account getAccountByName(String firstName);
    int updateLastName(Account account);
    void updateLastName(String firstName,String newLastName);
}
