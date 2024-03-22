package com.patika.kredinbizdeservice.controller;

import com.patika.kredinbizdeservice.model.Application;
import com.patika.kredinbizdeservice.model.Bank;
import com.patika.kredinbizdeservice.service.IBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/banks")

public class BankController {

    @Autowired
    private IBankService bankService;

    @Autowired
    public BankController(IBankService bankService) {
        this.bankService = bankService;
    }

    // create Banks
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Bank create(@RequestBody Bank bank) {
        System.out.println("bankService: " + bankService.hashCode());
        return bankService.save(bank);
    }


    //get all Applications

    @GetMapping
    public List<Bank> getAll() {
        return bankService.getAll();
    }

    @GetMapping("/{name}")
    public List<Bank> getByName(@PathVariable String name) {

        return bankService.getByName(name);
    }

}
