package com.assignment.intern_assignment.controller;

import com.assignment.intern_assignment.dto.BotCreateRequest;
import com.assignment.intern_assignment.entity.Bot;
import com.assignment.intern_assignment.service.BotService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bots")
@RequiredArgsConstructor
public class BotController {

    private final BotService botService;

    @PostMapping
    public ResponseEntity<Bot> createBot(@Valid @RequestBody BotCreateRequest request){
        Bot bot = botService.createBot(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(bot);
    }
}
