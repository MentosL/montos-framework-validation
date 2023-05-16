package com.montos.mqtt.controller;

import com.montos.mqtt.service.send.MqSendMessageGateWay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



/**
 * @author : MentosL
 * @date : 2023/4/28 22:15
 */
@RestController
@RequestMapping("/mqtt")
public class MqttController {

    @Autowired
    private MqSendMessageGateWay mqSendMessageGateWay;

    @RequestMapping("/send")
    @ResponseBody
    private ResponseEntity<String> send(){
        String data = "我是springboot发送的数据";
        mqSendMessageGateWay.sendToMqtt(data);
        // return R.ok("OK");
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
    /**
     * 动态增加主题
     * @param
     * @param
     */
    @ResponseBody
    @RequestMapping("/sendToTopic")
    private ResponseEntity<String> sendToTopic(){
        String topic = "topic";
        String data = "这是出的主题";
        mqSendMessageGateWay.sendToMqtt(topic,data);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }


}

