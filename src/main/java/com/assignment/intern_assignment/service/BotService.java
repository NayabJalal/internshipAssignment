package com.assignment.intern_assignment.service;

import com.assignment.intern_assignment.dto.BotCreateRequest;
import com.assignment.intern_assignment.entity.Bot;
import com.assignment.intern_assignment.repository.BotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BotService implements IBotService{

    private final BotRepository botRepository;

    @Override
    public Bot createBot(BotCreateRequest request) {
        Bot bot = Bot.builder()
                .name(request.getName())
                .personaDescription(request.getPersonaDescription())
                .build();
        return botRepository.save(bot);
    }
}
