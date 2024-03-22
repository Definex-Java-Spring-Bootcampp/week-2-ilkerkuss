package com.patika.kredinbizdeservice.controller;

import com.patika.kredinbizdeservice.model.Bank;
import com.patika.kredinbizdeservice.model.CreditCard;
import com.patika.kredinbizdeservice.service.ICreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/creditcards")
public class CreditCardController {

    @Autowired
    private ICreditCardService creditCardService;

    @Autowired
    public CreditCardController(ICreditCardService creditCardService){
        this.creditCardService = creditCardService;
    }

    // create creditCards
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreditCard create(@RequestBody CreditCard creditCard) {
        System.out.println("creditCardService: " + creditCardService.hashCode());
        return creditCardService.save(creditCard);
    }

    @GetMapping
    public List<CreditCard> getAll() {
        return creditCardService.getAll();
    }

    @GetMapping("/{bankname}")
    public List<CreditCard> getByBankName(@PathVariable String bankname) {

        return creditCardService.getByBankName(bankname);
    }

}
