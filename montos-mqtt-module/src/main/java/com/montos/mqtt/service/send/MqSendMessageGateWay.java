package com.montos.mqtt.service.send;


import com.montos.mqtt.config.MqttConfig;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

/**
 * @author : MentosL
 * @date : 2023/4/29 20:02
 */
@Component
@MessagingGateway(defaultRequestChannel = MqttConfig.CHANNEL_NAME_OUT)
public interface MqSendMessageGateWay {
    /**
     * 默认的消息机制
     * @param data
     */
    void sendToMqtt(String data);

    /**
     * 发送消息 向mqtt指定topic发送消息
     * @param topic
     * @param payload
     */
    void sendToMqtt(@Header(MqttHeaders.TOPIC) String topic, String payload);

    /**
     * 发送消息 向mqtt指定topic发送消息
     * @param topic
     * @param qos
     * @param payload
     */
    void sendToMqtt(@Header(MqttHeaders.TOPIC) String topic, @Header(MqttHeaders.QOS) int qos, String payload);
}
