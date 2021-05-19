package com.project.bymanagement.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;


@Component
public class SourceMessageUtils {

    @Autowired
    @Qualifier("messageSource")
    private MessageSource msg;

    public String getMessage(String messageId, String... param) {
        return msg.getMessage(messageId, param, Locale.getDefault());
    }

    public String getMessages(String messageId, String... param) {
        return msg.getMessage(messageId, param, Locale.getDefault());
    }

}
