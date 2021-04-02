package cn.com.xincan.xincanframework.k8s.server.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("gateway")
public class DiscoveryController {

    private final DiscoveryClient discoveryClient;

    public DiscoveryController(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    /**
     * 返回发现的所有服务
     * @return String
     */
    @GetMapping("/services")
    public JSONObject services() {
        JSONObject service = new JSONObject();
        service.put("time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        service.put("serviceList", this.discoveryClient.getServices());
        return service;
    }

}
