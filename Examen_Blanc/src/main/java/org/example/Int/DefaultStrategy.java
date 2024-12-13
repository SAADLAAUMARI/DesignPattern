package org.example.Int;

import org.example.entities.Transaction;

public class DefaultStrategy implements NotificationStrategy {
    @Override
    public void handleNotification(String agentName, Transaction transaction) {
        System.out.println("Notification reçue de l'agent : " + agentName);
        System.out.println("Transaction : " + transaction);
    }
}
