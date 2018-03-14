package com.dotori.example.validation.controller.content;

import com.dotori.example.validation.controller.content.request.ContentRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ContentController {

    /**
     * ex) /categories/it/contents?from=2018020211111
     * */
    @GetMapping("/categories/{category}/contents")
    public String contents(@Valid ContentRequest request) {
        return "success category : " + request.getCategory() + ", from : " + request.getFrom();
    }
}