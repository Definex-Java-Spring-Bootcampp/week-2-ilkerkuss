package com.patika.kredinbizdeservice.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.math.BigDecimal;
import java.util.List;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        // Maps "type": "standart" to the StandartCreditCard class
        @JsonSubTypes.Type(name = "standart", value = StandartCreditCard.class),
        // Maps "type": "gold" to the GoldCreditCard class
        @JsonSubTypes.Type(name = "gold", value = GoldCreditCard.class)
})
public class CreditCard implements Product{

    private BigDecimal fee;
    private List<Campaign> campaignList;
    private Bank bank;

    public CreditCard() {

    }

    public CreditCard(BigDecimal fee, List<Campaign> campaignList) {
        this.fee = fee;
        this.campaignList = campaignList;
    }
    public CreditCard(BigDecimal fee, List<Campaign> campaignList,Bank bank) {
        this.fee = fee;
        this.campaignList = campaignList;
        this.bank = bank;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public List<Campaign> getCampaignList() {
        return campaignList;
    }

    public void setCampaignList(List<Campaign> campaignList) {
        this.campaignList = campaignList;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
    @Override
    public BigDecimal getProductAmount() {
        return getFee();
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "fee=" + fee +
                ", campaignList=" + campaignList +
                ", bank=" + bank +
                '}';
    }

}
