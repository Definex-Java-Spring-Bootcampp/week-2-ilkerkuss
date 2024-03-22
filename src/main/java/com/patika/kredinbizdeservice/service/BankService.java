package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.model.Application;
import com.patika.kredinbizdeservice.model.Bank;
import com.patika.kredinbizdeservice.repository.ApplicationRepository;
import com.patika.kredinbizdeservice.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class BankService implements IBankService{

    @Autowired
    private BankRepository bankRepository;

    @Override
    public Bank save(Bank bank) {
        System.out.println("bankRepository: " + bankRepository.hashCode());

        bankRepository.save(bank);

        return bank;
    }

    @Override
    public List<Bank> getAll() {

        System.out.println("bankRepository: " + bankRepository.hashCode());
        return bankRepository.getAll();
    }

    @Override
    public List<Bank> getByName(String name) {
        List<Bank> foundBankList = bankRepository.findByName(name);

        if(foundBankList != null){
            return foundBankList;

        }
        return null;
    }
}
