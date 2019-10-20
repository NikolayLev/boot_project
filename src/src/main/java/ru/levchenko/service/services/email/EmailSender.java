package ru.levchenko.service.services.email;

public interface EmailSender {

    void send(String emailTo, String subject, String message);

}
