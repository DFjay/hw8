package com.example.hw8.service;

import com.example.hw8.entity.EventEntity;
import com.example.hw8.entity.MyEntity;
import com.example.hw8.repo.MyRepo;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
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
    public boolean saveEntity(String name, List<String> events) {
        MyEntity myEntity = new MyEntity();
        List<EventEntity> listEvents = new ArrayList<>();
        EventEntity event1 = new EventEntity();
        EventEntity event2 = new EventEntity();
        EventEntity event3 = new EventEntity();
        event1.setName(events.get(0));
        event2.setName(events.get(1));
        event3.setName(events.get(2));
        listEvents.add(event1);
        listEvents.add(event2);
        listEvents.add(event3);
        myEntity.setEvents(listEvents);
        try {
            repo.save(myEntity);
            return true;
        } catch (Exception e) {
            log.error("MyEntityService error {}", e.getMessage());
            return false;
        }
    }
}
