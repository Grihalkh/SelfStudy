package org.stepik.module4.bigtask3_2;

/*
Класс, в котором скрыта логика настоящей почты
*/
public class RealMailService implements MailService {
    
    @Override
    public Sendable processMail(Sendable mail) {
        // Здесь описан код настоящей системы отправки почты.
        return mail;
    }
}