package com.example.tendermegadev.service;

import com.example.tendermegadev.exception.BadRequestException;
import com.example.tendermegadev.exception.ItemNotFoundException;
import com.example.tendermegadev.model.MainItem;
import com.example.tendermegadev.model.SubItem;
import com.example.tendermegadev.model.SubItemPass;
import com.example.tendermegadev.payload.PayloadUtil;
import com.example.tendermegadev.repository.MainItemRepository;
import com.example.tendermegadev.repository.SubItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubItemService {
    @Autowired
    private  MainItemRepository mainItemRepository;
    @Autowired
    private SubItemRepository subItemRepository;
    // gwt all subitems by main item
    public List<SubItem> getAllSubItemPerMainItem(Long id) throws ItemNotFoundException {
        mainItemRepository.findById(id).orElseThrow(
                () -> new ItemNotFoundException("main item not found")
        );
        return subItemRepository.findAllByMainItemMainItemId(id);
    }
    // add new sub item
    public SubItem addNewSubItem(SubItemPass subItemPass) throws Exception{
        StringBuilder stringBuilder = PayloadUtil.validateSubItemPassParameters(subItemPass);
       boolean flag =  subItemRepository.existsBySubItemNameAndMainItem_MainItemName(subItemPass.getSubItemName(),subItemPass.getMainItemName()) ;
        if(flag){
            throw  new Exception("subItem is already exist");
        }
        if(stringBuilder !=null) {
            throw  new BadRequestException(stringBuilder.toString());
        } else {
            String remark = subItemPass.getRemark() != null  ? subItemPass.getRemark() :  "";
           MainItem mainItem= mainItemRepository.findByMainItemName(subItemPass.getMainItemName());
           SubItem subItem = SubItem.builder()
                    .subItemName(subItemPass.getSubItemName())
                    .price(subItemPass.getPrice())
                    .desc(subItemPass.getDesc())
                    .unit(subItemPass.getUnit())
                    .mainItem(mainItem)
                   .remark(remark)
                    .build();
           return subItemRepository.save(subItem);
        }

    }

    public SubItem getSubItem(String subItemName ,String mainIemName) throws Exception {
        SubItem subItem =null;
        Optional<SubItem> subItemTemp = subItemRepository.findSubItemByMainItem_MainItemNameAndSubItemName(mainIemName,subItemName);
        MainItem mainItem = mainItemRepository.findByMainItemName(mainIemName);
        if (subItemTemp.isPresent())
        {
            return subItemTemp.get();
        }
       else  {
                  SubItem temp = subItemRepository.findTopBySubItemName(subItemName);
                   SubItemPass subItemPass = SubItemPass.builder()
                           .subItemName(temp.getSubItemName())
                           .price(temp.getPrice())
                           .unit(temp.getUnit())
                           .remark(temp.getRemark())
                           .desc(temp.getDesc())
                           .mainItemName(mainItem.getMainItemName())
                           .build();
                   subItem = addNewSubItem(subItemPass);
                   return subItem;
               }
           }
}
