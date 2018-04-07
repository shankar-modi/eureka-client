package com.sk.learn.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.websocket.server.PathParam;

/**
 * @author shankarmodi
 * 07/04/18
 */

@RestController
@RequestMapping("/api")
public class Controller {


    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/product/{productName}")
    public String getProduct(@PathVariable String productName){

      ResponseEntity responseEntity= restTemplate.exchange("http://db-server/db/products/"+productName, HttpMethod.GET, null, String.class);

        return  ((String) responseEntity.getBody()).toString();
    }
}
