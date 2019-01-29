import dao.AccountDAO;
import dao.AccountDAOImpl;
import model.Account;
import service.AccountService;

public class Main {

    public static void main(String[] args) {
        AccountService accountService = new AccountService(new AccountDAOImpl());
        Account account =accountService.findByName("kirill");
        System.out.println(account);
        accountService.changeLastName("kirill","brober");
        Account account2 =accountService.findByName("kirill");
        System.out.println(account2);
    }
}
