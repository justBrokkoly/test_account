import dao.AccountDAO;
import model.Account;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.stubbing.Answer;
import service.AccountService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

public class AccountServiceTest {

    @InjectMocks
    private AccountService accountService;

    @Mock private AccountDAO accountDAO;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Test
    public void testFindByNameCall(){
        accountService.findByName("kirill");
        Mockito.verify(accountDAO).getAccountByName("kirill");
    }

    @Test
    public void testFindByName(){
        when(accountDAO.getAccountByName("kirill")).thenReturn(createTestAccount());
        Account actual = accountService.findByName("kirill");
        Assert.assertEquals("kirill",actual.getFirstName());
        Assert.assertEquals("kustov",actual.getLastName());
        Assert.assertEquals(1,actual.getId());
        Mockito.verify(accountDAO).getAccountByName("kirill");
    }

    @Test
    public void testUpdateAccountCall(){
        accountService.updateLastName(createTestAccount());
        Mockito.verify(accountDAO).updateLastName(createTestAccount());

    }

    @Test
    public void testUpdateAccount(){
        Account ac = createTestAccount();
        ac.setLastName("HiHi");
        when(accountDAO.updateLastName(createTestAccount())).thenReturn(1);
        int result=accountDAO.updateLastName(ac);
        Assert.assertEquals(1,result);
        Mockito.verify(accountDAO).updateLastName(ac);

    }

    @Test
    public void testUpdateAccountCall2(){
       accountService.changeLastName(createTestAccount().getFirstName(),"new");
       Mockito.verify(accountDAO).updateLastName(createTestAccount().getFirstName(),"new");

    }

    @Test
    public void testUpdateAccount2(){
   doAnswer((Answer)invocation->{
       Object arg0 = invocation.getArgument(0);
       Object arg1 = invocation.getArgument(1);

       Assert.assertEquals("kirill",arg0);
       Assert.assertEquals("newLastName",arg1);
       return null;
   }).when(accountDAO).updateLastName(any(String.class),any(String.class));
   accountDAO.updateLastName("kirill","newLastName");

    }

    private Account createTestAccount() {
        Account account = new Account();
        account.setFirstName("kirill");
        account.setLastName("kustov");
        account.setId(1);
        return account;
    }

}
