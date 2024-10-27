package com.example.observer;

import java.util.ArrayList;
import java.util.List;

public class Coffee implements OrderCommand {
    private String description;  // La description du café (ex. "Espresso", "Latte")
    private double cost;  // Le coût du café
    private static List<String> orderHistory = new ArrayList<>(); // Historique des commandes

    // Constructeur pour initialiser la description et le coût d'un café
    public Coffee(String description, double cost) {
        this.description = description;
        this.cost = cost;
    }

    @Override
    public void execute() {
        // Ajouter un café à l'historique des commandes
        orderHistory.add(getDescription() + " - $" + getCost());
        System.out.println("Commande ajoutée : " + getDescription());
    }

    @Override
    public void undo() {
        // Annuler la commande de café (fonctionnalité à implémenter si nécessaire)
        if (!orderHistory.isEmpty()) {
            String lastOrder = orderHistory.remove(orderHistory.size() - 1);
            System.out.println("Commande annulée : " + lastOrder);
        } else {
            System.out.println("Aucune commande à annuler.");
        }
    }

    @Override
    public double getCost() {
        // Retourner le coût du café
        return cost;
    }

    @Override
    public String getDescription() {
        // Retourner la description du café
        return description;
    }

    // Méthode pour afficher l'historique des commandes
    public static void showOrderHistory() {
        if (orderHistory.isEmpty()) {
            System.out.println("Aucune commande dans l'historique.");
        } else {
            System.out.println("Historique des commandes :");
            for (String order : orderHistory) {
                System.out.println(order);
            }
        }
    }
}

