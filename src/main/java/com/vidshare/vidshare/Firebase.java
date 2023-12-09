package com.vidshare.vidshare;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import java.io.FileInputStream;
import java.io.IOException;

public class Firebase {

    private final FirebaseAuth auth;

    public Firebase() throws IOException {
        // Initialize Firebase
        FileInputStream serviceAccount = new FileInputStream("src/main/resources/com/vidshare/vidshare/key.json");
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://vidshare-496ed-default-rtdb.firebaseio.com")
                .build();
        FirebaseApp.initializeApp(options);
        auth = FirebaseAuth.getInstance();
    }

    public void createAccount(String email, String password) throws FirebaseAuthException {
        UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                .setEmail(email)
                .setPassword(password);
        UserRecord userRecord = auth.createUser(request);
    }

    public void signIn(String email, String password) throws FirebaseAuthException {
        UserRecord userRecord = auth.getUserByEmail(email);
        UserRecord.UpdateRequest request = new UserRecord.UpdateRequest(userRecord.getUid())
                .setPassword(password);
        auth.updateUser(request);
    }

    public String getUserToken(String email, String password) throws FirebaseAuthException {
        UserRecord userRecord = auth.getUserByEmail(email);
        UserRecord.UpdateRequest request = new UserRecord.UpdateRequest(userRecord.getUid())
                .setPassword(password);
        auth.updateUser(request);
        return auth.createCustomToken(userRecord.getUid());
    }

    public void verifyIdToken(String idToken) throws FirebaseAuthException {
        auth.verifyIdToken(idToken);
    }

    public void deleteUser(String uid) throws FirebaseAuthException {
        auth.deleteUser(uid);
    }
}
