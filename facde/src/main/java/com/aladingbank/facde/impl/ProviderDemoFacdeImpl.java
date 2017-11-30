package com.aladingbank.facde.impl;

import com.aladingbank.facde.ProviderDemoFacde;
import com.alibaba.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public class ProviderDemoFacdeImpl implements ProviderDemoFacde{

    @Override
    public String save(String content) {
        return content.concat("====");
    }
}
