package ns.tests;

import ns.base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class PlaceOrderTest extends BaseTest {
    @Test(dataProvider = "loginData")
    public void order(HashMap<String, String> map){
        String id =map.get("email");
        String p =map.get("password");
        String s = landingPage
                .login(id, p)
                .addItemToCart()
                .doCheckout()
                .placeOrder()
                .getOrderId();
        System.out.println(s);

    }


    @Test(dependsOnMethods = { "order" }, enabled = true)
    public void validateOrder(){

        landingPage.login("123@xyz.con", "123456q.Q").clickOrdersLink().validateProduct();
    }



    @DataProvider(parallel = true)
    public Object[][] loginData() throws IOException {
        List<HashMap<String, String>> list = getJsonData();
        return new Object[][]{
                {list.get(0)}
//                {list.get(1)},
//                {list.get(2)}
        };
//        return new Object[][] {
//                {"123@xyz.con", "123456q.Q"},
//                {"123@xyz.con2", "123456q.Q"},
//                {"123@xyz.con", "123456q.Q11"}
//        };
    }
}
