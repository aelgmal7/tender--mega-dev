package com.example.tendermegadev.service;

import com.example.tendermegadev.exception.ItemNotFoundException;
import com.example.tendermegadev.model.SubItem;
import com.example.tendermegadev.payload.PayloadUtil;
import com.example.tendermegadev.repository.MainItemRepository;
import com.example.tendermegadev.repository.SubItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubItemService {
    @Autowired
    private  MainItemRepository mainItemRepository;
    @Autowired
    private SubItemRepository subItemRepository;
    public List<SubItem> getAllSubItemPerMainItem(Long id) throws ItemNotFoundException {
        mainItemRepository.findById(id).orElseThrow(
                () -> new ItemNotFoundException("main item not found")
        );
        return subItemRepository.findAllByMainItemMainItemId(id);
    }
}
