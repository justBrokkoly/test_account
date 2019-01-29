package service;

import dao.AccountDAO;
import model.Account;

public class AccountService {
    private AccountDAO accountDAO;

    public AccountService(AccountDAO accountDAO){
        this.accountDAO=accountDAO;
    }

    public Account findByName(String firstName){
        return accountDAO.getAccountByName(firstName);
    }

    //Измененный объект получаем из формы post запроса и нам нужно обновить его в бд?
    public void updateLastName(Account account){
        accountDAO.updateLastName(account);
    }

    //второй вариант?7
    public void changeLastName(String firstName,String newLastName){

        accountDAO.updateLastName(firstName,newLastName);


    }
}
