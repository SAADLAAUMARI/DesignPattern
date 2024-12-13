package org.example.entities;

import org.example.enums.Type;

import java.util.Date;

public class Transaction {
    private final String id;
    private final String date;
    private final double montant;
    private final Type type; // "Vente" ou "Achat"

    private Transaction(Builder builder) {
        this.id = builder.id;
        this.date = builder.date;
        this.montant = builder.montant;
        this.type = builder.type;
    }

    public static class Builder {
        private String id;
        private String date;
        private double montant;
        private Type type;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder date(String date) {
            this.date = date;
            return this;
        }

        public Builder montant(double montant) {
            this.montant = montant;
            return this;
        }

        public Builder type(Type type) {
            this.type = type;
            return this;
        }

        public Transaction build() {
            return new Transaction(this);
        }
    }

    public String getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public Double getMontant() {
        return montant;
    }

    public Type getType() {
        return type;
    }
}

