package com.example.tendermegadev.controller;

import com.example.tendermegadev.payload.PayloadUtil;
import com.example.tendermegadev.payload.ReturnedResult;
import com.example.tendermegadev.service.MainItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
