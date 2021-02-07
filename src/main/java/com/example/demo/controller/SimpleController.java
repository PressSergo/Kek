package com.example.demo.controller;

import com.example.demo.domain.model.Transaction;
import com.example.demo.domain.model.loaderServices.ILoaderServies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SimpleController {

    @Autowired
    ILoaderServies loaderServies;

    @GetMapping
    public List<Transaction> get(){
        return loaderServies.loadData();
    }
}
