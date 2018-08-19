package e.pavanmalisetti.uberdriverapplication.Common;

import e.pavanmalisetti.uberdriverapplication.Remote.IGoogleAPI;
import e.pavanmalisetti.uberdriverapplication.Remote.RetrofitClient;

public class Common {

    public static final String baseURL="https://maps.googleapis.com";
    public static IGoogleAPI getGoogleAPI()
    {
        return RetrofitClient.getClient(baseURL).create(IGoogleAPI.class);
    }
}
