package org.example.Int;

import org.example.entities.Transaction;

import java.util.ArrayList;
import java.util.List;

public class HistoryStrategy implements NotificationStrategy {
    private final List<Transaction> historique = new ArrayList<>();

    @Override
    public void handleNotification(String agentName, Transaction transaction) {
        historique.add(transaction);
        System.out.println("Historique mis à jour avec la transaction : " + transaction);
    }

    public List<Transaction> getHistorique() {
        return historique;
    }
}
