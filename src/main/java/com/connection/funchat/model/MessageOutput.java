package com.connection.funchat.model;

import java.time.LocalDateTime;

public class MessageOutput {

    private String fromUUID;
    private String fromName;
    private String message;
    private String date;
    private char letterAvatar;

    public String getFromUUID() {
        return fromUUID;
    }

    public void setFromUUID(String fromUUID) {
        this.fromUUID = fromUUID;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public char getLetterAvatar() {
        return letterAvatar;
    }

    public void setLetterAvatar(char letterAvatar) {
        this.letterAvatar = letterAvatar;
    }

}
