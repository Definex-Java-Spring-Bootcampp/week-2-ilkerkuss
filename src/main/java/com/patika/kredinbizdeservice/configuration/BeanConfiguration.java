package com.patika.kredinbizdeservice.configuration;

import com.patika.kredinbizdeservice.enums.SectorType;
import com.patika.kredinbizdeservice.model.*;
import com.patika.kredinbizdeservice.repository.ApplicationRepository;
import com.patika.kredinbizdeservice.repository.BankRepository;
import com.patika.kredinbizdeservice.repository.CampaignRepository;
import com.patika.kredinbizdeservice.repository.CreditCardRepository;
import com.patika.kredinbizdeservice.service.IUserService;
import com.patika.kredinbizdeservice.service.UserService;
import com.patika.kredinbizdeservice.service.UserService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.ArrayList;

@Configuration
public class BeanConfiguration {

    @Autowired
    private ApplicationRepository applicationRepository;
    @Autowired
    private BankRepository bankRepository;
    @Autowired
    private CreditCardRepository creditCardRepository;
    @Autowired
    private CampaignRepository campaignRepository;

    private final List<Campaign>akBankCampaignList = new ArrayList<>();
    private final List<Campaign> garantiCampaignList = new ArrayList<>();
    private final List<Campaign> finansCampaignList = new ArrayList<>();

    @Bean
    public IUserService userService4() {
        return new UserService2();
    }



    @Bean
    public List<Bank> predefinedBanks() {

        Bank garantiBank = new Bank("Garanti");
        Bank akBank = new Bank("AkBank");
        Bank finansBank = new Bank("FinansBank");
        Bank qnbBank = new Bank("QNB Bank");

        bankRepository.save(garantiBank);
        bankRepository.save(akBank);
        bankRepository.save(finansBank);
        bankRepository.save(qnbBank);

        return bankRepository.getBankList();
    }

    @Bean
    public List<Campaign> predefinedCampaigns() {

        Campaign campaign1 = new Campaign("Şimdi Axess'li Ol 2.600 TL'ye Varan Chip-para Kazan!", "Axess Content", LocalDate.of(2024, Month.AUGUST, 29), LocalDate.of(2024, Month.JANUARY, 1), LocalDate.of(2024, Month.MAY, 15), SectorType.OTHERS);
        Campaign campaign2 = new Campaign("Ayda 7.000 TL'ye Varan Bonus!", "Garanti Content", LocalDate.of(2024, Month.DECEMBER, 29), LocalDate.of(2024, Month.FEBRUARY, 1), LocalDate.of(2024, Month.MAY, 15), SectorType.OTHERS);
        Campaign campaign3 = new Campaign("villareyonu.com'da 1.000 TL Bonus!", "Garanti Content", LocalDate.of(2024, Month.NOVEMBER, 29), LocalDate.of(2024, Month.MARCH, 1), LocalDate.of(2024, Month.MAY, 15), SectorType.TRAVELS);
        Campaign campaign4 = new Campaign("2024 Ramazan Bayramı Kampanyası!", "Garanti Content", LocalDate.of(2024, Month.AUGUST, 29), LocalDate.of(2024, Month.JANUARY, 1), LocalDate.of(2024, Month.MAY, 15), SectorType.MARKET);
        Campaign campaign5 = new Campaign("CardFinans GO ile 500 TL ParaPuan!", "Finans Content", LocalDate.of(2024, Month.AUGUST, 29), LocalDate.of(2024, Month.MAY, 1), LocalDate.of(2024, Month.MAY, 15), SectorType.OTHERS);
        Campaign campaign6 = new Campaign("Yuvanızı Isıtacak Ücretsiz, Faizsiz 3 Taksit Fırsatı!", "Finans Content", LocalDate.of(2024, Month.AUGUST, 29), LocalDate.of(2024, Month.MARCH, 1), LocalDate.of(2024, Month.MAY, 15), SectorType.OTHERS);

        akBankCampaignList.add(campaign1);
        garantiCampaignList.add(campaign2);
        garantiCampaignList.add(campaign3);
        garantiCampaignList.add(campaign4);
        finansCampaignList.add(campaign5);
        finansCampaignList.add(campaign6);

        campaignRepository.getCampaignList().addAll(akBankCampaignList);
        campaignRepository.getCampaignList().addAll(garantiCampaignList);
        campaignRepository.getCampaignList().addAll(finansCampaignList);

        return campaignRepository.getCampaignList();

    }
    @Bean
    public List<CreditCard> predefinedCreditCards() {
        CreditCard creditCard1 = new StandartCreditCard(new BigDecimal(0), akBankCampaignList, bankRepository.getBankList().stream().filter(bank -> bank.getName().equals("AkBank")).findFirst().get());
        CreditCard creditCard2 = new StandartCreditCard(new BigDecimal(100), garantiCampaignList, bankRepository.getBankList().stream().filter(bank -> bank.getName().equals("Garanti")).findFirst().get());
        CreditCard creditCard3 = new StandartCreditCard(new BigDecimal(200), finansCampaignList, bankRepository.getBankList().stream().filter(bank -> bank.getName().equals("FinansBank")).findFirst().get());

        CreditCard creditCard4 = new GoldCreditCard(new BigDecimal(400), akBankCampaignList, bankRepository.getBankList().stream().filter(bank -> bank.getName().equals("AkBank")).findFirst().get());
        CreditCard creditCard5 = new GoldCreditCard(new BigDecimal(400), garantiCampaignList, bankRepository.getBankList().stream().filter(bank -> bank.getName().equals("Garanti")).findFirst().get());
        CreditCard creditCard6 = new GoldCreditCard(new BigDecimal(550), finansCampaignList, bankRepository.getBankList().stream().filter(bank -> bank.getName().equals("FinansBank")).findFirst().get());


        creditCardRepository.save(creditCard1);
        creditCardRepository.save(creditCard2);
        creditCardRepository.save(creditCard3);
        creditCardRepository.save(creditCard4);
        creditCardRepository.save(creditCard5);
        creditCardRepository.save(creditCard6);

        return creditCardRepository.getcreditCardList();
    }

    @Bean
    public List<Application> predefinedApplications() {

        Application app1 = new Application(new ConsumerLoan(new BigDecimal(100000), 12, 2.78), new User("ilker", "kuş", "ilker@mail.com", "password", "5422123456", true), LocalDateTime.now());
        Application app2 = new Application(new HouseLoan(new BigDecimal(200000), 18, 3.59), new User("ahmet", "kuş", "ahmet@mail.com", "password", "564651213", true), LocalDateTime.now());
        Application app3 = new Application(new VechileLoan(new BigDecimal(300000), 24, 3.20), new User("ayşe", "kuş", "ayse@mail.com", "password", "553461276", true), LocalDateTime.now());
        Application app4 = new Application(creditCardRepository.getcreditCardList().stream().filter(creditCard -> creditCard.getBank().getName().equals("Garanti")).findFirst().get(),new User("ilker", "kuş", "ilker@mail.com", "password", "5422123456", true),LocalDateTime.now());
        Application app5 = new Application(creditCardRepository.getcreditCardList().stream().filter(creditCard -> creditCard.getBank().getName().equals("AkBank")).findFirst().get(),new User("ilker", "kuş", "ilker@mail.com", "password", "5422123456", true),LocalDateTime.now());


        applicationRepository.getApplicationList().add(app1);
        applicationRepository.getApplicationList().add(app2);
        applicationRepository.getApplicationList().add(app3);
        applicationRepository.getApplicationList().add(app4);
        applicationRepository.getApplicationList().add(app5);



        return applicationRepository.getApplicationList();
    }
}
