package com.jwang261.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Controller;

/**
 * @author jwang261
 * @date 2020/7/31 8:36 PM
 */
@Controller
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT) //监听输入源
    public void input(Message<String> message){
        System.out.println("Consumer1, serverPort=" + serverPort
                + "\t"
                + "message=" + message.getPayload());
    }

}
