package com.assignment.intern_assignment.service;

import com.assignment.intern_assignment.dto.BotCreateRequest;
import com.assignment.intern_assignment.entity.Bot;

public interface IBotService {
    Bot createBot(BotCreateRequest request);
}
