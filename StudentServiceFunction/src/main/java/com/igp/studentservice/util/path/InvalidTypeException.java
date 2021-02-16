package com.igp.studentservice.util.path;

public class InvalidTypeException extends RuntimeException {

    public InvalidTypeException(Throwable t) {
        super(t);
    }

    public InvalidTypeException(String message) {
        super(message);
    }

    public InvalidTypeException(Object obj1, Class<?> obj2) {
        super("Cannot cast " + obj1.getClass().getSimpleName() + " to " + obj2.getSimpleName() + "!");
    }
}
