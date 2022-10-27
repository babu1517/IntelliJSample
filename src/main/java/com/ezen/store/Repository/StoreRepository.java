package com.ezen.store.Repository;

import com.ezen.store.Entity.StoreEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface StoreRepository extends CrudRepository<StoreEntity, Long> {
    @Override
    ArrayList<StoreEntity> findAll();
}
