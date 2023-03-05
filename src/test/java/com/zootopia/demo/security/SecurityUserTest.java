package com.zootopia.demo.security;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
// import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
// import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
// @ExtendWith(SpringExtension.class)
@ContextConfiguration
@WebAppConfiguration
public class SecurityUserTest {
    
    // @Autowired
    // private WebApplicationContext context;
    
    // private MockMvc mvc;

    // @BeforeEach
    // public void setup(){
    //     mvc = MockMvcBuilders
    //             .webAppContextSetup(context)
    //             .apply(SecurityMockMvcConfigurers.SpringSecurity())
    //             .build();
    // }
}
