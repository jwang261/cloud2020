package com.jwang261.springcloud.controller;

import com.jwang261.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jwang261
 * @date 2020/7/31 8:18 PM
 */
@RestController
public class SendMessageController {
    @Autowired
    private IMessageProvider messageProvider;

    @GetMapping("/sendMessage")
    public String sendMessage(){
        return messageProvider.send();
    }

}
