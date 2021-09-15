package com.example.tendermegadev.repository;

import com.example.tendermegadev.model.SubItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubItemRepository extends JpaRepository<SubItem,Long> {
    List<SubItem> findAllByMainItemMainItemId(Long id);
//    boolean existsSubItemBySubItemNameExistsMainItemMainItemName(String subName,String MainName );
//    boolean existsBySubItemNameExistsAndMainItem_MainItemName(String subname,String mainName);
    boolean existsBySubItemNameAndMainItem_MainItemName(String subName,String mainName);

}
