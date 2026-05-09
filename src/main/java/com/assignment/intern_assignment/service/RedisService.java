package com.assignment.intern_assignment.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class RedisService {

    private final RedisTemplate<String , String> redisTemplate;

    public void incrementViralityScore(Long postId, int points){

        String key = "post:" + postId + ":virality_score";
        log.info("📈 Incrementing Redis key: {} by {}", key, points);
        Long newValue = redisTemplate.opsForValue().increment(key , points);
        log.info("💾 New Redis value: {}", newValue);
    }
    public Integer getViralityScore(Long postId) {
        String key = "post:" + postId + ":virality_score";
        String value = redisTemplate.opsForValue().get(key);
        return value != null ? Integer.parseInt(value) : 0;
    }
}
