package org.example.Int;

import org.example.entities.Transaction;

public class ScoringStrategy implements NotificationStrategy {
    private double solde = 0;

    @Override
    public void handleNotification(String agentName, Transaction transaction) {
        if ("Vente".equals(transaction.getType())) {
            solde += transaction.getMontant();
        } else if ("Achat".equals(transaction.getType())) {
            solde -= transaction.getMontant();
        }
        System.out.println("Solde mis à jour pour les notifications : " + solde);
    }
}
