package com.alticci.controllers;

import com.alticci.services.AlticciService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/alticci", produces = MediaType.APPLICATION_JSON_VALUE)
public class AlticciController {

    private final AlticciService service;

    public AlticciController(AlticciService service) {
        this.service = service;
    }

    @GetMapping("/{n}")
    public Long getAlticciSequence(@PathVariable() Integer n) {
        return this.service.getAlticciSequence(n);
    }

}
