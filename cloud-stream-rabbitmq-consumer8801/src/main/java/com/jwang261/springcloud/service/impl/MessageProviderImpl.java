package com.jwang261.springcloud.service.impl;

import com.jwang261.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import java.util.UUID;

/**
 * @author jwang261
 * @date 2020/7/31 8:06 PM
 */

@EnableBinding(Source.class) //定义消费生产者的发送管道 -> output
@Slf4j
public class MessageProviderImpl implements IMessageProvider {

    @Autowired
    private MessageChannel output; //消息发送管道

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        log.info("****** serial: " + serial);
        return null;
    }
}
