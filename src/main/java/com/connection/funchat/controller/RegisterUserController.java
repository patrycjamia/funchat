package com.connection.funchat.controller;

import com.connection.funchat.UserBase;
import com.connection.funchat.factories.RandomUUIDFactory;
import com.connection.funchat.model.User;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterUserController {

    @Autowired
    UserBase base;

    @PostMapping
    public String getUuid(@RequestBody String body) throws UnsupportedEncodingException {
        
        String usName = URLDecoder.decode(body, "UTF-8"); 
        usName = usName.substring(0, usName.length()-1);
        System.out.println("[POST] /register body: " + usName);
        String uuid = null;

        do {
            
            uuid = RandomUUIDFactory.generateUUID();
            
        } while (!base.availableUUID(uuid));
        
        User r = new User(usName, uuid);
        
        base.addUser(r);
        
        System.out.println("Add new user: " + r.toString());
        
        return uuid;

    }

}
