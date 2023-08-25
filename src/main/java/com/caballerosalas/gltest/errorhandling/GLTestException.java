package com.caballerosalas.gltest.errorhandling;

public class GLTestException extends RuntimeException {
    public GLTestException() {
        super();
    }

    public GLTestException(String message) {
        super(message);
    }
}
