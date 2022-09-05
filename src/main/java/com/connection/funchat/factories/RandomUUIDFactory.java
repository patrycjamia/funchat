package com.connection.funchat.factories;

import java.util.UUID;

public class RandomUUIDFactory {

    public static String generateUUID() {
        return UUID.randomUUID().toString();
    }

}
