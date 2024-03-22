package com.patika.kredinbizdeservice.repository;

import com.patika.kredinbizdeservice.model.Application;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ApplicationRepository {

//    private static ApplicationRepository applicationRepositoryInstance;

    private List<Application> applicationList = new ArrayList<>();

    public void save(Application application) {
        applicationList.add(application);
    }

    public List<Application> getAll() {
        System.out.println("ApplicationList" + applicationList);
        return applicationList;
    }

    public List<Application> findByEmail(String email) {
        return applicationList.stream()
                .filter(application -> application.getUser().getEmail().equals(email))
                .collect(Collectors.toList());

    }

//    public static synchronized ApplicationRepository getInstance() {
//        if (applicationRepositoryInstance == null) {
//            applicationRepositoryInstance = new ApplicationRepository();
//        }
//        return applicationRepositoryInstance;
//
//    }

    // GETTER SETTER


    public List<Application> getApplicationList() {
        return applicationList;
    }

    public void setApplicationList(List<Application> applicationList) {
        this.applicationList = applicationList;
    }
}
