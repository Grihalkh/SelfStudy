package org.stepik.module4.bigtask3_2;

import java.util.logging.*;

public class Task{
    public static final String AUSTIN_POWERS = "Austin Powers";
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";
    
    public static class UntrustworthyMailWorker implements MailService{
        
        private MailService[] otherServices;
        
        private RealMailService realMailService;
        
        public UntrustworthyMailWorker(MailService[] otherPeople){
            this.otherServices = otherPeople;
            realMailService = new RealMailService();
        }
        
        @Override
        public Sendable processMail(Sendable mail) {
            Sendable result = mail;
            if (otherServices.length > 0) {
                for (int i = 0; i < otherServices.length; i++) {
                    result = otherServices[i].processMail(result);
                }
            }
            
            result = realMailService.processMail(result);
            
            return result;
        }
        
        public RealMailService getRealMailService() {
            return realMailService;
        }
    }
    
    public static class Spy implements MailService{
        
        private Logger logger;
        
        public Spy(Logger logger) {
            this.logger = logger;
        }
        
        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailMessage) {
                MailMessage message = (MailMessage) mail;
                
                if (message.getFrom().equals(AUSTIN_POWERS) || message.getTo().equals(AUSTIN_POWERS)) {
                    logger.log(Level.WARNING, "Detected target mail correspondence: from {0} to {1} \"{2}\"",
                            new Object[] {message.getFrom(), message.getTo(), message.getMessage()});
                }
                else {
                    logger.log(Level.INFO, "Usual correspondence: from {0} to {1}",
                            new Object[] {message.getFrom(), message.getTo()});
                }
            }
            
            return mail;
        }
    }
    
    public static class Thief implements MailService{
        
        private int minSum;
        
        private int totalSumStolen;
        
        public Thief(int minSum){
            this.minSum = minSum;
            totalSumStolen = 0;
        }
        
        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailPackage) {
                Package content = ((MailPackage) mail).getContent();
                
                if (content.getPrice() >= minSum) {
                    totalSumStolen += content.getPrice();
                    Package newPackage = new Package("stones instead of " + content.getContent(), 0);
                    mail = new MailPackage(mail.getFrom(), mail.getTo(), newPackage);
                }
            }
            return mail;
        }
        
        public int getStolenValue() {
            return totalSumStolen;
        }
    }
    
    public static class Inspector implements MailService{
        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailPackage) {
                String content = ((MailPackage) mail).getContent().getContent();
                if (content.equals(WEAPONS) || content.equals(BANNED_SUBSTANCE)) {
                    throw new IllegalPackageException();
                }
                if (content.contains("stones")) {
                    throw new StolenPackageException();
                }
            }
            return mail;
        }
    }
    
    public static class IllegalPackageException extends java.lang.RuntimeException {
        @Override
        public String getMessage() {
            return "This package contains illegal contents";
        }
    }
    
    public static class StolenPackageException extends java.lang.RuntimeException {
        @Override
        public String getMessage() {
            return "This package was stolen";
        }
    }
}
