package com.patika.kredinbizdeservice.model;

import java.math.BigDecimal;
import java.util.List;

public class GoldCreditCard extends CreditCard {
    public GoldCreditCard() {

    }
    public GoldCreditCard(BigDecimal fee, List<Campaign> campaignList) {
        super(fee, campaignList);
    }
    public GoldCreditCard(BigDecimal fee, List<Campaign> campaignList,Bank bank) {
        super(fee, campaignList,bank);
    }
}
