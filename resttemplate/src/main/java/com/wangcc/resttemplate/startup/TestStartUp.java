package com.wangcc.resttemplate.startup;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


/**
 * @Author: BryantCong
 * @Date: 2019/5/26 20:49
 * @Description:
 */
@Component
@Slf4j
public class TestStartUp implements CommandLineRunner {

    private static final String URL = "http://localhost:8080/user/detail";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void run(String... args) throws Exception {
        //对于header，RestTemplate处理的OK，但是对于流的处理
        //这边会把r
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        headers.add("TermTyp","WEB");
        JSONObject postData = new JSONObject();
        postData.put("name", "request for post");

        HttpEntity<String> formEntity = new HttpEntity<String>(postData.toString(), headers);
        String result = restTemplate.postForObject(URL, formEntity, String.class);
        log.info("RESULT:{}", result);
       // ResponseEntity<Resource> entity = restTemplate.postForEntity(URL, postData.toString(), Resource.class);
    }


    private void testPost() {


    }
}
