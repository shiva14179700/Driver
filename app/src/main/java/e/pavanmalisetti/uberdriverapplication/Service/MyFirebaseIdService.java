package e.pavanmalisetti.uberdriverapplication.Service;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import e.pavanmalisetti.uberdriverapplication.Common.Common;
import e.pavanmalisetti.uberdriverapplication.Model.Token;

public class MyFirebaseIdService extends FirebaseInstanceIdService {
    public void onTokenRefresh(){
        super.onTokenRefresh();
        String refreshedToken= FirebaseInstanceId.getInstance().getToken();
        updateTokenToServer(refreshedToken); //when we refresh token,we need to update it to firebase database

    }

    private void updateTokenToServer(String refreshedToken) {
        FirebaseDatabase db=FirebaseDatabase.getInstance();
        DatabaseReference tokens=db.getReference(Common.token_tbl);

        Token token=new Token(refreshedToken);
        if(FirebaseAuth.getInstance().getCurrentUser()!=null)//if already login,must update tokem
        {
            tokens.child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                    .setValue(token);
        }
    }
}
