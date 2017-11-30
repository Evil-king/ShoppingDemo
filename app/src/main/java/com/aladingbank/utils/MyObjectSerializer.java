package com.aladingbank.utils;

import org.apache.kafka.common.serialization.Serializer;

import java.io.Serializable;
import java.util.Map;


public class MyObjectSerializer implements Serializer<Object> {

    @Override
    public void configure(Map configs, boolean isKey) {

    }
    @Override
    public byte[] serialize(String topic, Object data) {
        return BeanUtils.bean2Byte(data);
    }
    /*
     * producer调用close()方法是调用
     */
    @Override
    public void close() {
        System.out.println("EncodeingKafka is close");
    }
}
