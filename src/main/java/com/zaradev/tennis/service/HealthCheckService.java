package com.zaradev.tennis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaradev.tennis.ApplicationStatus;
import com.zaradev.tennis.HealthCheck;
import com.zaradev.tennis.repository.HealthCheckRepository;

@Service
public class HealthCheckService {

    @Autowired
    private HealthCheckRepository healthCheckRepository;

    public HealthCheck getHealthCheck() {

        Long activeSession = healthCheckRepository.countApplicationConnections();
        if (activeSession > 0) {
            return new HealthCheck(ApplicationStatus.OK, "Welcom to ZaraDev Tennis!");
        } else {
            return new HealthCheck(ApplicationStatus.KO, "ZaraDev Tennis is not fully functional, please check your configuration.");
        }
    }
}
