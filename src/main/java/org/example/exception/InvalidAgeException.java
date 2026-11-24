package org.example.exception;

public class InvalidAgeException extends Exception {
    public InvalidAgeException(int age) {

      super("You too young for that?: " + age);
    }
}
