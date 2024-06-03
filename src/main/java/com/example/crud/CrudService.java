package com.example.crud;

import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firestore.v1.Document;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;

@Service
public class CrudService {
    
    // Create
    public String createUser(User entity) throws ExecutionException, InterruptedException{
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = db.collection("users").document(entity.getId()).set(entity);
        return "User created successfully at "+collectionApiFuture.get().getUpdateTime().toString();
    }

    // Read
    public User getUser(String id) throws ExecutionException, InterruptedException{
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference docRef = db.collection("users").document(id);
        ApiFuture<DocumentSnapshot> future = docRef.get();
        DocumentSnapshot document = future.get();
        User user;
        if(document.exists()){
            user = document.toObject(User.class);
            return user;
        }
        return null;
    }

    // Update
    public String updateUser(User entity) throws ExecutionException, InterruptedException{
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = db.collection("users").document(entity.getId()).set(entity);
        return "User upadated sucessfully at " + collectionApiFuture.get().getUpdateTime().toString();
    }

    // Delete
    public String deleteUser(String id) {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = db.collection("users").document(id).delete();
        return "Successfully deleted document with id: " + id;
    }

}
