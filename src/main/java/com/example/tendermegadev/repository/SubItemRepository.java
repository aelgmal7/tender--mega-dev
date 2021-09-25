package com.example.tendermegadev.repository;

import com.example.tendermegadev.model.SubItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubItemRepository extends JpaRepository<SubItem,Long> {
    List<SubItem> findAllByMainItemMainItemId(Long id);
    boolean existsBySubItemNameAndMainItem_MainItemName(String subName,String mainName);
    Optional<SubItem> findSubItemByMainItem_MainItemNameAndSubItemName(String mainItem, String subItem);
    SubItem findBySubItemName(String subItemName);

    SubItem findTopBySubItemName(String subItemName);
}
