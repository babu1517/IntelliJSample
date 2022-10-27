package com.ezen.store.Service;

import com.ezen.store.Entity.StoreEntity;
import com.ezen.store.Repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StoreServiceImpl implements StoreService{

    @Autowired
    StoreRepository storeRepository;

    @Override
    public void save(StoreEntity entity) {
        storeRepository.save(entity);
    }

    @Override
    public ArrayList<StoreEntity> findAll() {
        ArrayList<StoreEntity> list2 = storeRepository.findAll();
        return list2;
    }

    @Override
    public StoreEntity findById(long id) {
        return storeRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(StoreEntity entity) {
        storeRepository.delete(entity);
    }




}
