package com.example.crud;

import lombok.Getter;
import lombok.Setter;
import java.util.Map;

@Getter
@Setter
public class User {
    private String id;
    private String name;
    private Map<String, Integer> subjectMarks;
}
