package com.example.tendermegadev.payload;

import com.example.tendermegadev.model.MainItem;
import com.example.tendermegadev.model.QuantityPrice;
import com.example.tendermegadev.model.SubItemPass;
import org.springframework.http.HttpStatus;

import java.util.List;

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
    public static StringBuilder validateSubItemPassParameters(SubItemPass subItemPass){
        StringBuilder valid = new StringBuilder();
        if(subItemPass.getSubItemName() == null || subItemPass.getSubItemName() == ""){
            valid.append("SubItem name, ");
        }
        if(subItemPass.getPrice() == null || String.valueOf(subItemPass.getPrice()) == ""){
            valid.append("SubItem price, ");
        }
        if(subItemPass.getDesc() == null || String.valueOf(subItemPass.getDesc()) == ""){
            valid.append("SubItem desc, ");
        }if(subItemPass.getUnit() == null || String.valueOf(subItemPass.getUnit()) == ""){
            valid.append("SubItem unit, ");
        }if(subItemPass.getMainItemName() == null || String.valueOf(subItemPass.getMainItemName()) == ""){
            valid.append("main item name, ");
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
    public static  StringBuilder validateQuantityPriceParameter(List<QuantityPrice> quantityPriceList) {
        StringBuilder valid = new StringBuilder();
        quantityPriceList.stream().forEach(q -> {

            //System.out.println(q);
            if(q.getQuantity() == null || String.valueOf(q.getQuantity()) == ""){
                valid.append("subItem quantity, ");
            }
            if(q.getSubItemName() == null || q.getSubItemName() == ""){
                valid.append("subItem name, ");
            }

        });
        if(valid.length() > 0){
            return valid.append("required");
        }
        return null;
    }
}
