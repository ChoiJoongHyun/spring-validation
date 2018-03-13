package com.dotori.example.validation.controller.content;

import com.dotori.example.validation.controller.content.request.ContentRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/contents")
@RestController
public class ContentController {

    @GetMapping
     public String contents(@Valid ContentRequest request) {
        return "success";
     }
}