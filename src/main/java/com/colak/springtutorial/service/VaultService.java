package com.colak.springtutorial.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class VaultService {

    @Value("${my_age}")
    public String age;

    public String getAge(){
        return String.format("I am %s years old",age);
    }

}
