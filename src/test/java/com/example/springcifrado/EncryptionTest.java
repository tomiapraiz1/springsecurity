package com.example.springcifrado;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import java.util.HashMap;
import java.util.Map;

public class EncryptionTest {

    /***
     * BCrypt genera su propio salt de 16 bytes
     * El resultado de cifrar con bcrypt sera un string de 60 caracteres:
     *
     * - $a version
     * - $10 fuerza (de 4 a 31, por defecto es 10)
     * - Los 22 siguientes caracteres son el salt generado
     */

    @Test
    void bcryptTest(){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPass = passwordEncoder.encode("admin");
        System.out.println(hashedPass);

        boolean matches = passwordEncoder.matches("admin", hashedPass);
        System.out.println(matches);
    }

    @Test
    void springPasswordEncoder(){
        //default
        String idForEncode = "bcrypt";

        Map<String, PasswordEncoder> encoders = new HashMap<>();
        encoders.put("bcrypt", new BCryptPasswordEncoder());
        /***
         *         encoders.put("pbkdf2", new Pbkdf2PasswordEncoder());
         *         encoders.put("scrypt", new SCryptPasswordEncoder());
         */


        PasswordEncoder passwordEncoder = new DelegatingPasswordEncoder(idForEncode, encoders);
        String hashedPassword = passwordEncoder.encode("admin");
        System.out.println(hashedPassword);
    }
}
