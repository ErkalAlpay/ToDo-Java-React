package com.erkalalpay.todotechcareer.Helper;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "Notification-Service", url = "http://localhost:8081")
public interface MailHelper {
    @GetMapping("/mailservice-register")
    public void serviceRegister(@RequestParam String to);

}
