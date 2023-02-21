package com.zootopia.demo.Inicializaters;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.zootopia.demo.entity.Country;
import com.zootopia.demo.repository.CountryRepository;

@Component
public class CountryInitializer implements ApplicationRunner {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Country> countries = Arrays.asList(
            new Country("Spain"),
            new Country("French"),
            new Country("Belgium"),
            new Country("Australia"),
            new Country("Canada"),
            new Country("India"),
            new Country("Ireland"),
            new Country("Jamaica"),
            new Country("New Zealand"),
            new Country("Singapore"),
            new Country("South Africa"),
            new Country("United Kingdom"),
            new Country("United States")
        );

        countryRepository.saveAll(countries);
    }

}