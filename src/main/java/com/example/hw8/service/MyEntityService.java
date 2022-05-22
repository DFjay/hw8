package com.example.hw8.service;

import com.example.hw8.entity.MyEntity;
import com.example.hw8.repo.MyRepo;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Slf4j
public class MyEntityService {
    MyRepo repo;

    @Transactional
    public List<MyEntity> getAllEntity() {
        return repo.findAll();
    }

    @Transactional
    public boolean saveEntity(String name, String[] events) {
        MyEntity myEntity = new MyEntity();
        myEntity.setName(name);
        myEntity.setEvents(events);
        try {
            repo.save(myEntity);
            return true;
        } catch (Exception e) {
            log.error("MyEntityService error {}", e.getMessage());
            return false;
        }
    }
}
