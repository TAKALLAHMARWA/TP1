package com.example.Service.voiture;

import com.example.Service.voiture.entities.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service-client")
public interface ClientFeignClient
{
    @GetMapping("/clients/{id}")
    Client getClientById(@PathVariable("id") Long id);
}
