package com.patika.kredinbizdeservice.model;

import java.math.BigDecimal;
import java.util.List;

public class StandartCreditCard extends CreditCard{

    public StandartCreditCard() {

    }
    public StandartCreditCard(BigDecimal fee, List<Campaign> campaignList) {
        super(fee, campaignList);
    }
    public StandartCreditCard(BigDecimal fee, List<Campaign> campaignList,Bank bank) {
        super(fee, campaignList,bank);
    }
}
