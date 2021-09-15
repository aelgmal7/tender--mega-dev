package com.example.tendermegadev.controller;

import com.example.tendermegadev.exception.BadRequestException;
import com.example.tendermegadev.payload.PayloadUtil;
import com.example.tendermegadev.payload.ReturnedResult;
import com.example.tendermegadev.service.SubItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/subItem")
public class SubItemController {
    @Autowired
    private SubItemService subItemService;

    @GetMapping("/all/{id}")
    public ResponseEntity<ReturnedResult> subItemsPerMainItems(@PathVariable("id") Long id){
        ReturnedResult result = null;
        try {
            result = PayloadUtil.fillResult(HttpStatus.OK,true,subItemService.getAllSubItemPerMainItem(id));
            return ResponseEntity.status(HttpStatus.OK).body(result);

        } catch (Exception e) {
            HttpStatus status = e instanceof BadRequestException ? HttpStatus.BAD_REQUEST : HttpStatus.NOT_FOUND;

            result = PayloadUtil.fillResult(HttpStatus.NOT_FOUND, false,
                    e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }

    }
}
