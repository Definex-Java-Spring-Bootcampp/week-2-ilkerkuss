package com.patika.kredinbizdeservice.repository;

import com.patika.kredinbizdeservice.model.Campaign;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Repository
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CampaignRepository {

    private List<Campaign> campaignList = new ArrayList<>();

    public List<Campaign> getAll() {
        System.out.println("campaignList: " + campaignList);
        campaignList.sort(Comparator.comparing(Campaign::getCreateDate).reversed());
        return campaignList;
    }

    public List<Campaign> getCampaignList() {
        return campaignList;
    }
}
