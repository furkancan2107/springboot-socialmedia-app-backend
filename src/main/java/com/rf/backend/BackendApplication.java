package com.rf.backend;

import ch.qos.logback.classic.encoder.JsonEncoder;
import com.rf.backend.entity.post.Share;
import com.rf.backend.entity.user.User;
import com.rf.backend.service.post.ShareService;
import com.rf.backend.service.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


// aşağıda security login işlemini iptal ettik
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class BackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }
@Bean
    CommandLineRunner hayaliKullanici(UserService userService, ShareService shareService){
        return  new CommandLineRunner() {
            private PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

            @Override
            public void run(String... args) throws Exception {
                User user=new User();
                Share share=new Share();
                user.setUsername("kral1");
                user.setDisplay("kral1");
                user.setSifre("Ef123456789");
                user.setSifre(this.passwordEncoder.encode(user.getSifre()));
                userService.kaydet(user);
                userService.getAllUsers().add(user);


            }
        };
    }

}
