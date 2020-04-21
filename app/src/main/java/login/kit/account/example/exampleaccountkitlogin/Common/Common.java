package login.kit.account.example.exampleaccountkitlogin.Common;

import login.kit.account.example.exampleaccountkitlogin.Remote.IAccountAPI;
import login.kit.account.example.exampleaccountkitlogin.Remote.RetrofitClient;

public class Common {
    // Common class, if connect from IP server

    public static final String BASE_URL = "http://account.dev-droid.sk/";

    public static IAccountAPI getAPI()
    {
        return RetrofitClient.getClient(BASE_URL).create(IAccountAPI.class);
    }
}
