package com.patika.kredinbizdeservice.service;


import com.patika.kredinbizdeservice.model.Application;
import com.patika.kredinbizdeservice.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ApplicationService implements IApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public Application save(Application application) {
        System.out.println("applicationRepository: " + applicationRepository.hashCode());

        applicationRepository.save(application);

        return application;
    }

    @Override
    public List<Application> getAll() {
        System.out.println("applicationRepository: " + applicationRepository.hashCode());
        return applicationRepository.getAll();
    }

    @Override
    public List<Application> getByEmail(String email) {
        List<Application> foundApplicationList = applicationRepository.findByEmail(email);

        if(foundApplicationList != null){
            return foundApplicationList;

        }
        return null;
    }

}
