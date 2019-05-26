package com.wangcc.resttemplate.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: BryantCong
 * @Date: 2019/5/26 21:56
 * @Description:
 */

@RestController
@Slf4j
public class RestTemplateController {
    private static final String URL = "http://localhost:8080/user/detail";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/test")
    public void test(HttpServletRequest request) throws Exception {

        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        headers.add("TermTyp", "WEB");
        HttpEntity<Resource> resoureHttpEntity = new HttpEntity(request.getInputStream(), headers);
        String result = restTemplate.postForObject(URL, resoureHttpEntity, String.class);
        log.info("RESULT:{}", result);
    }
}
