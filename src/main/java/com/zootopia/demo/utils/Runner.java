package com.zootopia.demo.utils;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.zootopia.demo.entity.Authority;
import com.zootopia.demo.entity.User;
import com.zootopia.demo.repository.AuthorityRepository;
import com.zootopia.demo.repository.UserRepository;

@Component
public class Runner implements  CommandLineRunner{

    private final UserRepository userRepository;

    private final AuthorityRepository authorityRepository;

    

    public Runner(UserRepository userRepository, AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
    }



    @Override
    public void run(String... args) throws Exception{
        if(this.authorityRepository.count() == 0) {
            this.authorityRepository.saveAll(List.of(
                new Authority(AuthorityName.ADMIN),
                new Authority(AuthorityName.READ),
                new Authority(AuthorityName.WRITE)
            ));
        }

        if(this.userRepository.count()==0){
            this.userRepository.saveAll(List.of(
                new User("uncledave", "UncleDave123", List.of(this.authorityRepository.findByName(AuthorityName.ADMIN).get())),
                new User("user01", "User01123", List.of(this.authorityRepository.findByName(AuthorityName.READ).get())),
                new User("user02", "User02123", List.of(this.authorityRepository.findByName(AuthorityName.WRITE).get()))
            ));
    
        }
    }

    
}
