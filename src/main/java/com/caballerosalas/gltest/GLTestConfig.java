package com.caballerosalas.gltest;

import com.caballerosalas.gltest.gluser.GLUser;
import com.caballerosalas.gltest.gluser.GLUserRepository;
import com.caballerosalas.gltest.phone.Phone;
import com.caballerosalas.gltest.phone.PhoneRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Configuration
public class GLTestConfig {

    @Bean
    CommandLineRunner commandLineRunner(GLUserRepository userRepository, PhoneRepository phoneRepository) {
        return args -> {
            GLUser paloma = new GLUser(
                    "Paloma",
                    "paloma@gmail.com",
                    "palo123"

            );

            GLUser mery = new GLUser(
                    "Mery",
                    "mery@gmail.com",
                    "6969!"
            );

            GLUser geraldine = new GLUser(
                    "Geraldine",
                    "geraldine@gmail.com",
                    "hace2002!"
            );


            userRepository.saveAll(Arrays.asList(paloma, mery, geraldine));
            Optional<GLUser> refresh_paloma = userRepository.findUserByEmail("paloma@gmail.com");
            if (refresh_paloma.isPresent()){
                List<Phone> phones = Arrays.asList(
                        new Phone( 123654, "01", "02", refresh_paloma.get()),
                        new Phone(654123, "03", "04", refresh_paloma.get()),
                        new Phone(987465, "05", "06", refresh_paloma.get())
                );
                phoneRepository.saveAll(phones);
            }


            // userRepository.saveAllList.of(paloma, mery, geraldine)); after java 9
        };
    }
}
