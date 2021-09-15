package com.example.tendermegadev.repository;

import com.example.tendermegadev.model.MainItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainItemRepository extends JpaRepository<MainItem,Long> {
    MainItem findByMainItemName(String name);
    boolean existsMainItemByMainItemName(String name);

}
