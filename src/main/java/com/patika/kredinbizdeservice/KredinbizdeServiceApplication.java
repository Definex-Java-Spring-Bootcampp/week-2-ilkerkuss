package com.patika.kredinbizdeservice;

import com.patika.kredinbizdeservice.controller.UserController;
import com.patika.kredinbizdeservice.model.Application;
import com.patika.kredinbizdeservice.model.ConsumerLoan;
import com.patika.kredinbizdeservice.model.User;
import com.patika.kredinbizdeservice.repository.ApplicationRepository;
import com.patika.kredinbizdeservice.service.IUserService;
import com.patika.kredinbizdeservice.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@SpringBootApplication
public class KredinbizdeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(KredinbizdeServiceApplication.class, args);

//        Application app1= new Application(new ConsumerLoan(new BigDecimal(100000),12,2.78),new User("ilker","kuş","ilker@mail.com","password","5422123456",true), LocalDateTime.now());
//        Application app2= new Application(new ConsumerLoan(new BigDecimal(200000),18,3.59),new User("ahmet","kuş","ilker@mail.com","password","5422123456",true), LocalDateTime.now());
//        Application app3= new Application(new ConsumerLoan(new BigDecimal(300000),24,3.20),new User("ayşe","kuş","ilker@mail.com","password","5422123456",true), LocalDateTime.now());
//
//        ApplicationRepository.getInstance().save(app1);
//        ApplicationRepository.getInstance().save(app2);
//        ApplicationRepository.getInstance().save(app3);
//        System.out.println(ApplicationRepository.getInstance().hashCode());
//        System.out.println(ApplicationRepository.getInstance().getApplicationList());





        //IUserService userService = new UserService();

        //IUserService userService2 = new UserService2();

        //UserController userController = new UserController(userService);
       // userController.create(new User());
    }

    /*
    @Bean
    @Scope("prototype")
    public IUserService userService() {
        return new UserService();
    }*/

}
