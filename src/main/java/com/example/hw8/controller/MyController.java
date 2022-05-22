package com.example.hw8.controller;

import com.example.hw8.GsonObject;
import com.example.hw8.entity.MyEntity;
import com.example.hw8.service.MyEntityService;
import com.google.gson.Gson;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class MyController {
    MyEntityService myEntityService;

    @PostMapping(value = "/createEntity", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> createEntity(@RequestBody String body) {
        Gson g = new Gson();
        GsonObject my = g.fromJson(body, GsonObject.class);
        if (myEntityService.saveEntity(my.getName(), my.getEvents())) {
            List<MyEntity> allEntity = myEntityService.getAllEntity();
            return new ResponseEntity<>(g.toJson(allEntity), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
