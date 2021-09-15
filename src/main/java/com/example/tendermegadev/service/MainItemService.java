package com.example.tendermegadev.service;

import com.example.tendermegadev.exception.BadRequestException;
import com.example.tendermegadev.model.MainItem;
import com.example.tendermegadev.payload.PayloadUtil;
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

    // add new main item
    public MainItem addNewMAinItem(MainItem mainItem) throws Exception{

         StringBuilder stringBuilder = PayloadUtil.validateMainItemParameters(mainItem);
         if(stringBuilder !=null){
             throw new BadRequestException(stringBuilder.toString());
         }
         if(!mainItemRepository.existsMainItemByMainItemName(mainItem.getMainItemName())) {
             MainItem mainItem1 = MainItem.builder()
                     .mainItemName(mainItem.getMainItemName())
                     .desc(mainItem.getDesc())
                     .unit(mainItem.getUnit())
                     .build();
             return mainItemRepository.save(mainItem1);
         } else {
             throw new Exception("main items is already exist");
         }
    }


}
