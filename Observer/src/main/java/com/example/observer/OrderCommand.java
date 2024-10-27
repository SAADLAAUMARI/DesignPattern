package com.example.observer;

public interface OrderCommand {
    void execute();  // Exécuter la commande (ajout d'un café ou supplément)
    void undo();     // Annuler la commande (suppression d'un café ou supplément)
    double getCost();  // Retourner le coût total de la commande
    String getDescription();  // Retourner la description de la commande
}

