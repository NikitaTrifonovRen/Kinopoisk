package com.example.kinopoisk.service;

public interface MailService {
    void sendSimpleEmail(String toAddress, String subject, String message);
}
