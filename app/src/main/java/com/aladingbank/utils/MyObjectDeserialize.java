package com.aladingbank.utils;

import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class MyObjectDeserialize implements Deserializer<Object> {
    @Override
    public void configure(Map<String, ?> map, boolean b) {

    }

    @Override
    public Object deserialize(String s, byte[] bytes) {
        return BeanUtils.byte2Obj(bytes);
    }

    @Override
    public void close() {

    }
}
