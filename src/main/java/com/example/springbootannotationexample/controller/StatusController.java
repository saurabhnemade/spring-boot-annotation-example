package com.example.springbootannotationexample.controller;

import com.example.springbootannotationexample.ResponseObjects.Status;
import com.example.springbootannotationexample.aop.LogTime;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

    @GetMapping("/status")
    @LogTime
    public ResponseEntity getStatus() {
        Status responseStatus = new Status();
        responseStatus.setStatus("success");
        responseStatus.setMessage("Service is up and running.");
        return ResponseEntity.ok(responseStatus);
    }

    @GetMapping("/timeConsumingEndpoint")
    @LogTime
    public String getTimeConsumingEndpoint() throws InterruptedException {
        Thread.sleep(4000);
        return "After 4000";
    }
}
