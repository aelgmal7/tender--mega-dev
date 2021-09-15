package com.example.tendermegadev.payload;

import com.example.tendermegadev.model.MainItem;
import com.example.tendermegadev.model.SubItemPass;
import org.springframework.http.HttpStatus;

public class PayloadUtil {

    public static ReturnedResult fillResult(HttpStatus status , Boolean succeeded , Object object){
        return ReturnedResult.builder()
                .status(status)
                .succeeded(succeeded)
                .result(object)
                .build();
    }

    public static StringBuilder validateSubItemParameters(SubItemPass subItemPass){
        StringBuilder valid = new StringBuilder();
        if(subItemPass.getSubItemName() == null || subItemPass.getSubItemName() == ""){
            valid.append("SubItem name, ");
        }
        if(subItemPass.getPrice() == null || String.valueOf(subItemPass.getPrice()) == ""){
            valid.append("SubItem price, ");
        }

        if(valid.length() > 0){
            return valid.append("required");
        }
        return null;
    }

    public static StringBuilder validateMainItemParameters(MainItem mainItem){
        StringBuilder valid = new StringBuilder();
        if(mainItem.getMainItemName() == null || mainItem.getMainItemName() == ""){
            valid.append("MainItem name, ");
        }
        if(mainItem.getUnit() == null || mainItem.getUnit() == ""){
            valid.append("MainItem unit, ");
        }
        if(mainItem.getDesc() == null || mainItem.getDesc() == ""){
            valid.append("MainItem desc, ");
        }

        if(valid.length() > 0){
            return valid.append("required");
        }
        return null;
    }
}
