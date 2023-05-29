package com.montos.http.service;

import com.montos.http.util.HttpUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

@Service
public class HelloService {

    @Autowired
    private HttpClient httpClient;


    public String sendPost(String uri, Map<String, String> jsonMap) {

//        ResponseEntity<String> apiResponse = restTemplate.postForEntity(uri, HttpUtil.generatePostJson(jsonMap), String.class);
//        if (apiResponse.getStatusCode().value() >= 400 && apiResponse.getStatusCode().value() < 500) {
//        }
//        return apiResponse.getBody();
        return null;
    }

    public String sendGet(String uri, Map<String, String> uriMap) throws IOException {
        HttpGet uriRequest = new HttpGet("http://127.0.0.1:8080/get/params?id=121212&name=montos");
        HttpResponse execute = httpClient.execute(uriRequest);
        return execute.toString();
    }

}
