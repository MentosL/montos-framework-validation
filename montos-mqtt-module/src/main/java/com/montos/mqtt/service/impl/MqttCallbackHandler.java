package com.montos.mqtt.service.impl;


import org.springframework.stereotype.Service;

/**
 * @author : MentosL
 * @date : 2023/4/29 20:03
 */
@Service
public class MqttCallbackHandler {

    public void handle(String topic, String payload){
        // 根据topic分别进行消息处理。
        System.out.println("MqttCallbackHandle:" + topic + "|"+ payload);
    }
}
