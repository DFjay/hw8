package com.example.hw8.repo;


import com.example.hw8.entity.MyEntity;
import lombok.NonNull;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface MyRepo extends CrudRepository<MyEntity, UUID> {
    @NonNull
    List<MyEntity> findAll();
}
