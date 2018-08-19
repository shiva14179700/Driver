package e.pavanmalisetti.uberdriverapplication.Remote;

import e.pavanmalisetti.uberdriverapplication.Model.FCMResponse;
import e.pavanmalisetti.uberdriverapplication.Model.Sender;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface IFCMService {
    @Headers({
            "Content-Type:application/json",
            "Authorization:key=AAAAMH1qhq0:APA91bG5LsY9hGxqxWbvfqKRn_HdgoMKI8z5yRknwCO2N6uo2Mj8HD-Jl1jrinRHBGjOCiYUafhwT3b3LzGLJFSt2DBH_pj5ruwEmUu1kY24zfwL1qsFPL8-FVwY6mtBs_PLZ5SGwwjLMR_KQoFfirBjIAgCX-n31g"
    })
    @POST("fcm/send")
    Call<FCMResponse> sendMessage(@Body Sender body);
}
