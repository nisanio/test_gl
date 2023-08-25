package com.caballerosalas.gltest.errorhandling;

import java.util.UUID;

public class GLUserByEmailNotFoundException  extends RuntimeException{

    public  GLUserByEmailNotFoundException(String email){
        super("User Not Found: " + email);
    }
}
