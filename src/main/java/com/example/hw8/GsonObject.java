package com.example.hw8;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@FieldDefaults(level= AccessLevel.PRIVATE)
public class GsonObject {
    String name;
    List<String> events;
}
