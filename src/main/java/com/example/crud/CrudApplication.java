package com.example.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.auth.oauth2.GoogleCredentials;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.Objects;

@SpringBootApplication
public class CrudApplication {

    public static void main(String[] args) throws IOException {
        ClassLoader cl = CrudApplication.class.getClassLoader();

        File file = new File(Objects.requireNonNull(cl.getResource("servicekey.json")).getFile());
        FileInputStream serviceAccount = new FileInputStream(file.getAbsolutePath());

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        FirebaseApp.initializeApp(options);
        SpringApplication.run(CrudApplication.class, args);
    }
}
