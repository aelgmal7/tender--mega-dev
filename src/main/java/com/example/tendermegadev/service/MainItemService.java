package com.example.tendermegadev.service;

import com.example.tendermegadev.model.MainItem;
import com.example.tendermegadev.repository.MainItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainItemService {
    @Autowired
    private MainItemRepository mainItemRepository;

    //get all main items
    public List<MainItem> getAllMainItems(){
        return mainItemRepository.findAll();
    }


}
