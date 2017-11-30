package com.aladingbank.config;

import com.aladingbank.entity.sample.ShopSample;
import com.aladingbank.sample.service.SampleService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

public class KafkaConsumerListener {

    private Logger logger = LoggerFactory.getLogger(KafkaConsumerListener.class);

    @Autowired
    private SampleService sampleService;

    @KafkaListener(topics = {"test"})
    public void listen(ConsumerRecord<?, ?> record) {
        logger.info("kafka的key: " + record.key());
        logger.info("kafka的value: " + record.value().toString());
        logger.info("消息入库:"+this.sampleService.getAll());
        if(record.value() instanceof ShopSample){
            logger.info("kafka object:"+((ShopSample) record.value()).getSampleName());
        }
    }
}
