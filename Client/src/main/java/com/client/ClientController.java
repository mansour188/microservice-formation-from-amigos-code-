package com.client;



import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/client")

public record ClientController(ClientService clentService) {
    @PostMapping

    public void registerClient(@RequestBody ClientRequest clientRequest)  {
        log.info("new Client registration {}",clientRequest);
        clentService.registerClient(clientRequest);
    }
}
