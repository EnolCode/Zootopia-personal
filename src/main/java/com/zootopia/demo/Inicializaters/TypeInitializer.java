package com.zootopia.demo.Inicializaters;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import com.zootopia.demo.entity.Type;
import com.zootopia.demo.repository.TypeRepository;

@Component
public class TypeInitializer implements ApplicationRunner {

    @Autowired
    private TypeRepository typeRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Type> types = Arrays.asList(
            new Type("Lion"),
            new Type("Tiger"),
            new Type("Orangutan"),
            new Type("Iguana"),
            new Type("leopard"),
            new Type("Rhino"),
            new Type("Fox"),
            new Type("Snake"),
            new Type("Bear"),
            new Type("Crocodile"),
            new Type("Wolf"),
            new Type("Jaguar"),
            new Type("Leopard"),
            new Type("Gorilla"),
            new Type("Chimpanzee"),
            new Type("weasel"),
            new Type("jackal"),
            new Type("otter")
         
        );
        typeRepository.saveAll(types);
    }
}