package org.example.exception;

public class NegativeNumberException extends RuntimeException {
    public NegativeNumberException(int age)
    {
        super("Number cannot be negative: " + age);
    }
}
