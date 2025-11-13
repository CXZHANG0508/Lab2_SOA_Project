package org.csu.petstore.user.Configuration;

import org.csu.petstore.user.utils.JwtBlacklist;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BlacklistCleanupTask {

    @Scheduled(fixedRate = 3600000) // 每小时执行一次
    public void cleanBlacklist() {
        JwtBlacklist.cleanExpiredTokens();
    }
}
