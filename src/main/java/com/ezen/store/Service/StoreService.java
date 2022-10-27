package com.ezen.store.Service;

import com.ezen.store.Entity.StoreEntity;

import java.util.ArrayList;

public interface StoreService {
    void save(StoreEntity entity);

    ArrayList<StoreEntity> findAll();

    public StoreEntity findById(long id);

    void delete(StoreEntity entity);


}
