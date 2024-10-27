package com.example.observer;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CoffeeApp extends Application {

    // Liste observable pour stocker les éléments de commande (cafés et suppléments)
    private ObservableList<String> orderItems = FXCollections.observableArrayList();
    // Label pour afficher le total des commandes
    private Label totalLabel = new Label("Total: $0.00");
    // Zone de texte pour afficher la description de la boisson
    private TextArea drinkDescriptionArea = new TextArea();
    // Variable pour suivre le coût total de la commande
    private double totalCost = 0;
    // Variable pour suivre la description actuelle de la boisson
    private String drinkDescription = "";

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Coffee Order App");

        // ListView pour afficher les éléments de la commande en cours
        ListView<String> orderListView = new ListView<>(orderItems);

        // ComboBox pour choisir un type de café
        ComboBox<String> coffeeBox = new ComboBox<>();
        coffeeBox.getItems().addAll("Espresso", "Latte", "Cappuccino");

        // ComboBox pour choisir un supplément
        ComboBox<String> extraBox = new ComboBox<>();
        extraBox.getItems().addAll("Chocolat", "Caramel", "Milkshake");

        // Bouton pour ajouter un café à la commande
        Button addCoffeeButton = new Button("Ajouter Café");
        addCoffeeButton.setOnAction(e -> {
            String selectedCoffee = coffeeBox.getValue();
            if (selectedCoffee != null) {
                // Création d'une instance Coffee avec un prix fixe de 2.5$
                Coffee coffee = new Coffee(selectedCoffee, 2.5);  // Exemple de prix
                // Ajout de la description du café à la commande
                orderItems.add(coffee.getDescription());
                // Mise à jour du coût total de la commande
                totalCost += coffee.getCost();
                // Mise à jour de la description de la boisson sans supplément
                updateDrinkDescription(coffee.getDescription(), false);
                updateTotal();
            }
        });

        // Bouton pour ajouter un supplément à la dernière commande
        Button addExtraButton = new Button("Ajouter Supplément");
        addExtraButton.setOnAction(e -> {
            String selectedExtra = extraBox.getValue();
            if (selectedExtra != null && !orderItems.isEmpty()) {
                // Récupération du dernier élément de commande pour y ajouter le supplément
                String lastOrder = orderItems.get(orderItems.size() - 1);
                // Création d'une instance de café de base
                Coffee baseCoffee = new Coffee(lastOrder, 2.5);  // Exemple de café de base
                // Création du supplément avec un coût additionnel de 0.5$
                Extra extra = new Extra(baseCoffee, selectedExtra, 0.5);  // Prix du supplément
                // Mise à jour de la commande avec le supplément ajouté
                orderItems.set(orderItems.size() - 1, extra.getDescription());
                // Mise à jour du coût total (ajout du supplément)
                totalCost += extra.getCost() - baseCoffee.getCost();  // Ajouter le coût du supplément
                // Mise à jour de la description de la boisson avec le supplément
                updateDrinkDescription(selectedExtra, true);
                updateTotal();
            }
        });

        // Bouton pour supprimer un élément sélectionné de la commande
        Button removeButton = new Button("Supprimer");
        removeButton.setOnAction(e -> {
            int selectedIndex = orderListView.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0) {
                // Suppression de l'élément sélectionné
                String removedItem = orderItems.remove(selectedIndex);
                updateDrinkDescription(removedItem, true);
                // Logique pour ajuster le prix (non incluse dans cet exemple)
                updateTotal();
            }
        });

        // Zone de texte pour afficher la description de la boisson avec son coût total
        drinkDescriptionArea.setEditable(false);
        drinkDescriptionArea.setPrefHeight(100);

        // Interface principale avec agencement vertical (VBox)
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(
                new Label("Sélectionnez un café :"), coffeeBox, addCoffeeButton,
                new Label("Sélectionnez un supplément :"), extraBox, addExtraButton,
                new Label("Commande :"), orderListView, totalLabel,
                new Label("Description de la boisson :"), drinkDescriptionArea, removeButton
        );

        // Configuration de la scène et affichage de la fenêtre principale
        Scene scene = new Scene(layout, 400, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Méthode pour mettre à jour le coût total affiché
    private void updateTotal() {
        totalLabel.setText(String.format("Total: $%.2f", totalCost));
    }

    // Méthode pour mettre à jour la description de la boisson en fonction des ajouts
    private void updateDrinkDescription(String item, boolean isExtra) {
        if (!isExtra) {
            // Si on ajoute un café, on initialise la description
            drinkDescription = item;
        } else {
            // Si on ajoute un supplément, on l'ajoute à la description existante
            drinkDescription += " + " + item;
        }
        // Mise à jour de la zone de texte avec la description et le coût total
        drinkDescriptionArea.setText(drinkDescription + "\nTotal: $" + String.format("%.2f", totalCost));
    }

    public static void main(String[] args) {
        launch(args);
    }   }