package com.example.observer;

import java.util.ArrayList;
import java.util.List;

public class Extra implements OrderCommand {
    private OrderCommand baseOrder;  // La commande de base (ex. un café)
    private String description;  // La description du supplément (ex. "Chocolat")
    private double cost;  // Le coût du supplément
    private static List<String> orderHistory = new ArrayList<>(); // Historique des commandes

    // Constructeur pour initialiser la commande de base, la description et le coût du supplément
    public Extra(OrderCommand baseOrder, String description, double cost) {
        this.baseOrder = baseOrder;
        this.description = description;
        this.cost = cost;
    }

    @Override
    public void execute() {
        // Ajouter le supplément à l'historique des commandes
        String orderWithExtra = getDescription() + " - $" + getCost();
        orderHistory.add(orderWithExtra);
        System.out.println("Supplément ajouté : " + description);
    }

    @Override
    public void undo() {
        // Annuler le supplément de l'historique des commandes
        if (!orderHistory.isEmpty()) {
            String lastOrder = orderHistory.remove(orderHistory.size() - 1);
            System.out.println("Supplément annulé : " + lastOrder);
        } else {
            System.out.println("Aucun supplément à annuler.");
        }
    }

    @Override
    public double getCost() {
        // Retourner le coût total (café + supplément)
        return baseOrder.getCost() + cost;
    }

    @Override
    public String getDescription() {
        // Retourner la description de la commande avec le supplément
        return baseOrder.getDescription() + " + " + description;
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

