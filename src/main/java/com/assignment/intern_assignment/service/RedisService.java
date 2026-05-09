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
    public boolean tryIncrementBotReplyCount(Long postId, int max) {
        String key = "post:" + postId + ":bot_count";
        Long count = redisTemplate.opsForValue().increment(key);
        if (count != null && count <= max) {
            if (count == 1) {
                redisTemplate.expire(key, java.time.Duration.ofHours(24));
            }
            return true;
        } else {
            redisTemplate.opsForValue().decrement(key);
            return false;
        }
    }
    public boolean isBotHumanCooldownActive(Long botId, Long humanId) {
        String key = "cooldown:bot_" + botId + ":human_" + humanId;
        return Boolean.TRUE.equals(redisTemplate.hasKey(key));
    }

    public void setBotHumanCooldown(Long botId, Long humanId) {
        String key = "cooldown:bot_" + botId + ":human_" + humanId;
        redisTemplate.opsForValue().set(key, "1", java.time.Duration.ofMinutes(10));
    }
    public boolean trySendImmediateNotification(Long userId) {
        String key = "notif_cooldown:user:" + userId;
        if (Boolean.TRUE.equals(redisTemplate.hasKey(key))) {
            return false;
        }
        redisTemplate.opsForValue().set(key, "1", java.time.Duration.ofMinutes(15));
        return true;
    }
    public void addPendingNotification(Long userId, String message) {
        String key = "user:" + userId + ":pending_notifs";
        redisTemplate.opsForList().rightPush(key, message);
    }
}
