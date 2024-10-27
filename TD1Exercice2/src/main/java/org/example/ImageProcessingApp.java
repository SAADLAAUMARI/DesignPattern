package org.example;

import java.util.Scanner;

public class ImageProcessingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Créer une image
        int[] imageData = {255, 128, 64, 32}; // Exemples de données d'image
        Image image = new Image(imageData);

        // Choisir le filtre
        System.out.println("Choisissez un filtre (ConcreteFilter1 ou ConcreteFilter2) :");
        String filterClass = scanner.nextLine();

        ImageProcessor processor = new ImageProcessor();
        try {
            Class<?> clazz = Class.forName(filterClass);
            FilterStrategy filter = (FilterStrategy) clazz.getDeclaredConstructor().newInstance();
            processor.setFilterStrategy(filter);
        } catch (Exception e) {
            System.out.println("Erreur lors de la création du filtre : " + e.getMessage());
        }

        // Filtrer l'image
        int[] filteredData = processor.filter(image.getData());
        System.out.println("Données filtrées : " + java.util.Arrays.toString(filteredData));

        // Compression
        SpecificCompressor compressor = new SpecificCompressor();
        int[] compressedData = compressor.compresser(image.getData());
        System.out.println("Données compressées : " + java.util.Arrays.toString(compressedData));

        scanner.close();
    }
}

