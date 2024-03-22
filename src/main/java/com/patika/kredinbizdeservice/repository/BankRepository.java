package com.patika.kredinbizdeservice.repository;

import com.patika.kredinbizdeservice.model.Application;
import com.patika.kredinbizdeservice.model.Bank;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class BankRepository {
    private List<Bank> bankList = new ArrayList<>();

    public void save(Bank bank) {
        if(bankList.stream().filter(bnk -> bnk.getName().equals(bank.getName())).findFirst().isEmpty()){
            bankList.add(bank);
        }else {
            System.out.println("Eklemeye Çalışılan Banka Daha Önce Eklenmiş!");
        }
    }

    public List<Bank> getAll() {
        System.out.println("BankList: " + bankList);
        return bankList;
    }

    public List<Bank> findByName(String name) {
        return bankList.stream()
                .filter(bank -> bank.getName().equals(name))
                .collect(Collectors.toList());

    }

    public List<Bank> getBankList() {
        return bankList;
    }
}
