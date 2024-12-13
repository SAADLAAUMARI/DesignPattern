package org.example;

import org.example.Int.HistoryStrategy;
import org.example.Int.ScoringStrategy;
import org.example.entities.Agent;
import org.example.entities.Transaction;
import org.example.enums.Type;

import java.time.LocalDate;
import java.sql.Date;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Agent a1 = new Agent("A1");
        Agent a2 = new Agent("A2");
        Agent a3 = new Agent("A3");
        a1.subscribe(a2);
        a1.subscribe(a3);
        Transaction transaction=new Transaction.Builder()
                .id("Transaction 1")
                .date(Date.valueOf(LocalDate.now()))
                .montant(1000)
                .type(Type.Vente)
                .build();
        System.out.println("transaction: "+transaction+" avec l'id: "+transaction.getId()+" la date: "+transaction.getDate());
        a1.addTransaction(transaction);
        a1.afficherTransactions();
        a2.afficherTransactions();
        a3.afficherTransactions();

        System.out.println("Strategies--------------------------------------------------------\n");
        Agent agent = new Agent("Agent1");

        // Transactions
        Transaction t1=new Transaction.Builder()
                .id("Transaction__1")
                .date(Date.valueOf(LocalDate.now()))
                .montant(1000)
                .type(Type.Vente)
                .build();
        Transaction t2=new Transaction.Builder()
                .id("Transaction 1")
                .date(Date.valueOf(LocalDate.now()))
                .montant(1000)
                .type(Type.Vente)
                .build();
        Transaction t3=new Transaction.Builder()
                .id("Transaction 1")
                .date(Date.valueOf(LocalDate.now()))
                .montant(1000)
                .type(Type.Vente)
                .build();

        // Stratégie par défaut
        System.out.println("=== Utilisation de DefaultStrategy ===");
        agent.addTransaction(t1);

        // Changement de stratégie : Historique
        System.out.println("\n=== Utilisation de HistoryStrategy ===");
        agent.setNotificationStrategy(new HistoryStrategy());
        agent.addTransaction(t2);

        // Changement de stratégie : Scoring
        System.out.println("\n=== Utilisation de ScoringStrategy ===");
        agent.setNotificationStrategy(new ScoringStrategy());
        agent.addTransaction(t3);

        // Afficher les transactions
        System.out.println("\n=== Transactions de l'agent ===");
        agent.afficherTransactions();
    }
}