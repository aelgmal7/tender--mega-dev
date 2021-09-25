package com.example.tendermegadev.controller;

import com.example.tendermegadev.exception.BadRequestException;
import com.example.tendermegadev.model.MainItem;
import com.example.tendermegadev.model.QuantityPrice;
import com.example.tendermegadev.payload.PayloadUtil;
import com.example.tendermegadev.payload.ReturnedResult;
import com.example.tendermegadev.service.MainItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/mainItem")
public class MainItemController {
    @Autowired
    private MainItemService mainItemService;
    //get all
    @GetMapping("all")
    public ResponseEntity<ReturnedResult> mainItems(){
    ReturnedResult result = null;
    try {
        result = PayloadUtil.fillResult(HttpStatus.OK,true,mainItemService.getAllMainItems());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }catch (Exception e) {
        result = PayloadUtil.fillResult(HttpStatus.INTERNAL_SERVER_ERROR,
                false, e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
    }
    }
    @PostMapping("/add")
    public  ResponseEntity<ReturnedResult> addNewMainItem(@RequestBody MainItem mainItem){
    ReturnedResult result =null;
    try {
         result = PayloadUtil.fillResult(HttpStatus.OK,true,mainItemService.addNewMAinItem(mainItem));
         return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    catch (Exception e) {
        HttpStatus status = e instanceof BadRequestException ? HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.ALREADY_REPORTED;
        result = PayloadUtil.fillResult(status, false,
                e.getMessage());
        return ResponseEntity.status(status).body(result);
      }
    }
    @GetMapping("/totalprice/{mainItemName}")
    public ResponseEntity<ReturnedResult> getMainItemTotalPrice(@RequestBody List<QuantityPrice> quantityPriceList,
                                                                @PathVariable("mainItemName") String mainItemName
                                                                ){
        System.out.println(quantityPriceList + mainItemName);
        ReturnedResult result =null;
        try {
            result = PayloadUtil.fillResult(HttpStatus.OK,true,mainItemService.calculateMainItemTotalPrice(quantityPriceList,mainItemName));
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (Exception e) {
            HttpStatus status = e instanceof BadRequestException ? HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.ALREADY_REPORTED;
            result = PayloadUtil.fillResult(status, false,
                    e.getMessage());
            return ResponseEntity.status(status).body(result);

        }

    }

}
