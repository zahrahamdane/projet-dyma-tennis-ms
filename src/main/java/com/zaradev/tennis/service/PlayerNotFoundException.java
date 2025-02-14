package com.zaradev.tennis.service;

public class PlayerNotFoundException extends RuntimeException {

    public PlayerNotFoundException(String lsatName) {
        super("Player with last name " + lsatName + " not found");
    }
}
