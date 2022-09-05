package com.connection.funchat.model;

public class User {

    private final String name;
    private final String uuid;

    public User(String name, String uuid) {
        this.name = name;
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public String getUuid() {
        return uuid;
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", uuid=" + uuid + '}';
    }

}
