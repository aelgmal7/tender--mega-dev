package com.example.tendermegadev.service;

import com.example.tendermegadev.exception.BadRequestException;
import com.example.tendermegadev.model.MainItem;
import com.example.tendermegadev.model.QuantityPrice;
import com.example.tendermegadev.payload.PayloadUtil;
import com.example.tendermegadev.payload.ReturnedResult;
import com.example.tendermegadev.repository.MainItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
             String remark = mainItem.getRemark() != null  ? mainItem.getRemark() :  "";
             MainItem mainItem1 = MainItem.builder()
                     .mainItemName(mainItem.getMainItemName())
                     .desc(mainItem.getDesc())
                     .unit(mainItem.getUnit())
                     .remark(remark)
                     .build();
             return mainItemRepository.save(mainItem1);
         } else {
             throw new Exception("main items is already exist");
         }
    }


    public Float calculateMainItemTotalPrice(List<QuantityPrice> quantityPriceList) {
        Float totalPrice;
        StringBuilder stringBuilder =PayloadUtil.validateQuantityPriceParameter(quantityPriceList);
        if(stringBuilder !=null){
            throw new BadRequestException(stringBuilder.toString());
        }
        return null;
    }

}
