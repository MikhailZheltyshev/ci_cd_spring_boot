package com.mike.ci_cd_spring_boot.services;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class DateMessageService implements IMessageService {

    @Override
    public String getMessage() {
        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        final LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
}
