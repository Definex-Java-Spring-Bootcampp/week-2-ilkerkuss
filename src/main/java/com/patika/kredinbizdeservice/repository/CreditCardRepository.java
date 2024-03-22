package com.patika.kredinbizdeservice.repository;

import com.patika.kredinbizdeservice.model.CreditCard;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CreditCardRepository {
    private List<CreditCard> creditCardList = new ArrayList<>();

    public void save(CreditCard creditCard) {

            creditCardList.add(creditCard);
    }

    public List<CreditCard> getAll() {
        System.out.println("creditCardList: " + creditCardList);
        return creditCardList;
    }

    public List<CreditCard> findByBankName(String bankName) {
        return creditCardList.stream()
                .filter(creditCard -> creditCard.getBank().getName().equals(bankName))
                .collect(Collectors.toList());

    }

    public List<CreditCard> getcreditCardList() {
        return creditCardList;
    }
}
