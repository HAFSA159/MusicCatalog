package com.example.musiccatalog.Exception;

public class MusicNotFoundException extends RuntimeException {

    public MusicNotFoundException(String message) {
        super(message);
    }
}
