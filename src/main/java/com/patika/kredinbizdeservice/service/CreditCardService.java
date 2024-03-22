package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.model.Bank;
import com.patika.kredinbizdeservice.model.CreditCard;
import com.patika.kredinbizdeservice.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CreditCardService implements ICreditCardService {
    @Autowired
    private CreditCardRepository creditCardRepository;

    @Override
    public CreditCard save(CreditCard creditCard) {
        System.out.println("creditCardRepository: " + creditCardRepository.hashCode());

        creditCardRepository.save(creditCard);

        return creditCard;
    }

    @Override
    public List<CreditCard> getAll() {
        System.out.println("creditCardRepository: " + creditCardRepository.hashCode());
        return creditCardRepository.getAll();
    }

    @Override
    public List<CreditCard> getByBankName(String bankName) {
        List<CreditCard> foundCreditCardList = creditCardRepository.findByBankName(bankName);

        if(foundCreditCardList != null){
            return foundCreditCardList;

        }
        return null;
    }
}
