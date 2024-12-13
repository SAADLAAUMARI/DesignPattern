package org.example.Int;

import org.example.entities.Transaction;

public interface NotificationStrategy {
    void handleNotification(String agentName, Transaction transaction);
}
