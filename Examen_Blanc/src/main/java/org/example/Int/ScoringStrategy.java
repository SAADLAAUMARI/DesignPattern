package org.example.Int;

import org.example.entities.Transaction;
import org.example.enums.Type;

public class ScoringStrategy implements NotificationStrategy {
    private double solde = 100;

    @Override
    public void handleNotification(String agentName, Transaction transaction) {
        if (Type.Vente.equals(transaction.getType())) {
            solde += transaction.getMontant();
        } else if (Type.Achat.equals(transaction.getType())) {
            solde -= transaction.getMontant();
        }
        System.out.println("Solde mis à jour pour les notifications : " + solde);
    }
}
