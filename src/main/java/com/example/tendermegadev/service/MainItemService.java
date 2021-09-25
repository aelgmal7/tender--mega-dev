package com.example.tendermegadev.service;

import com.example.tendermegadev.exception.BadRequestException;
import com.example.tendermegadev.model.MainItem;
import com.example.tendermegadev.model.QuantityPrice;
import com.example.tendermegadev.model.SubItem;
import com.example.tendermegadev.payload.PayloadUtil;
import com.example.tendermegadev.repository.MainItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainItemService {
    @Autowired
    private MainItemRepository mainItemRepository;
    @Autowired
    private SubItemService subItemService;
    private float totalPrice;

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


    public Double calculateMainItemTotalPrice(List<QuantityPrice> quantityPriceList,String mainItemName) throws Exception {
        Double finalTotalPrice = null;
        boolean mainItemExist = mainItemRepository.existsMainItemByMainItemName(mainItemName);
        if(!mainItemExist){
            throw new Exception("main item not found");
        }
        totalPrice = 0.0F;
        StringBuilder stringBuilder =PayloadUtil.validateQuantityPriceParameter(quantityPriceList);
        if(stringBuilder !=null){
            throw new BadRequestException(stringBuilder.toString());
        }
        quantityPriceList.stream().forEach(sub -> {
            try {
                SubItem subItem = subItemService.getSubItem(sub.getSubItemName(),mainItemName);
                totalPrice+= subItem.getPrice() * sub.getQuantity();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        finalTotalPrice = totalPrice / 0.7 ;
        return finalTotalPrice;
    }

}
