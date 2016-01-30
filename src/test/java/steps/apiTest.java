package steps;

import api.RestService;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by wamika on 1/29/16.
 */
public class apiTest {

    @Test
    public void shouldRetrieveUserData() {
        RestService service = new RestService();
        service.getUserData("1");

    }

    @Test
    public void shouldAddNewUser() {
        RestService service = new RestService();
        service.addNewUser("lukaszroslonek", "www.google.com");
    }

}
