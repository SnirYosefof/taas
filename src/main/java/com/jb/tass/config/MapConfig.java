package com.jb.tass.config;

import com.jb.tass.security.Information;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

//Created by sniryosefof on 30 יוני
@Configuration
public class MapConfig {
    @Bean
    public Map<UUID, Information> map() {
        return new HashMap<>();
    }
}
