package com.connection.funchat.conventer;

import com.connection.funchat.model.MessageInput;
import com.connection.funchat.model.MessageOutput;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class MessageConventer {
    
    private static String pattern = "[ d MMMM - HH:mm ]";
    private static SimpleDateFormat format = new SimpleDateFormat(pattern);

    public static MessageOutput convert(MessageInput input, String userName) {
        MessageOutput out = new MessageOutput();
        out.setDate(format.format(new Date()));
        out.setFromUUID(input.getFrom());
        out.setFromName(userName);
        out.setMessage(input.getMessage());
        out.setLetterAvatar(userName.toUpperCase().charAt(0));

        return out;
    }

}
