package com.connection.funchat;

import com.connection.funchat.model.User;
import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class UserBase {

    private final List<User> users = new LinkedList<>();

    public void addUser(User u) {
        users.add(u);
    }

    public String getUserNameForUUID(String uuid) {
        for (User user : users) {
            if (user.getUuid().equals(uuid)) {
                return user.getName();
            }
        }
        return "Anonymous";
    }
    
    public boolean availableUUID(String uuid){
        for (User user : users) {
            if (user.getUuid().equals(uuid)) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }
}
