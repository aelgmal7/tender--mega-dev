package com.example.tendermegadev.repository;

import com.example.tendermegadev.model.SubItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubItemRepository extends JpaRepository<SubItem,Long> {
    List<SubItem> findAllByMainItemMainItemId(Long id);
}
