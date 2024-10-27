package org.example;

public class ImageProcessor {
    private FilterStrategy filterStrategy;

    public void setFilterStrategy(FilterStrategy filterStrategy) {
        this.filterStrategy = filterStrategy;
    }

    public int[] filter(int[] data) {
        if (filterStrategy != null) {
            return filterStrategy.apply(data);
        }
        return data;
    }

    public int[] compresser(int[] data) {
        // Méthode de compression (Template Method)
        return compressData(data);
    }

    protected int[] compressData(int[] data) {
        // Implémentation par défaut de la compression
        return data; // Modifier selon l'algorithme de compression
    }
}

