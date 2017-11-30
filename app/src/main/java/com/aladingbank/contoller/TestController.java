package com.aladingbank.contoller;

import com.aladingbank.entity.sample.ShopSample;
import com.aladingbank.facde.ProviderDemoFacde;
import com.aladingbank.sample.service.impl.SampleServiceImpl;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class TestController {

    @Autowired
    private SampleServiceImpl sampleService;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Reference(version = "1.0.0")
    private ProviderDemoFacde providerDemoFacde;

    @RequestMapping("/product")
    public ShopSample mqProduct(ShopSample shopSample){
        kafkaTemplate.send("test","sampleInfo", shopSample);
        return shopSample;
    }

    @RequestMapping("/db")
    public ShopSample mybatisShopSample(){
        return this.sampleService.getAll();
    }

    @RequestMapping("/dubbo/consume")
    public String dubboConsume(String content){
        return this.providerDemoFacde.save(content);
    }
}
