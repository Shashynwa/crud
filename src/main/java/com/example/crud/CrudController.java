package com.example.crud;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
public class CrudController {

    private final CrudService crudService;

    public CrudController(CrudService crudService) {
        this.crudService = crudService;
    }

    // Create
    @PostMapping("/create")
    public String createUser(@RequestBody User entity) throws InterruptedException, ExecutionException {
        return crudService.createUser(entity);
    }

    // Read
    @GetMapping("/get/{id}")
    public User getUser(@PathVariable String id) throws InterruptedException, ExecutionException {
        return crudService.getUser(id);
    }

    // Update
    @PutMapping("/update")
    public String updateUser(@RequestBody User entity) throws InterruptedException, ExecutionException {
        return crudService.updateUser(entity);
    }

    // Delete
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable String id) throws InterruptedException, ExecutionException {
        return crudService.deleteUser(id);
    }

    //test
    @GetMapping("/test")
    public ResponseEntity<String> testGetEndpoint() {
        return ResponseEntity.ok("Test GET endpoint is working");
    }
}