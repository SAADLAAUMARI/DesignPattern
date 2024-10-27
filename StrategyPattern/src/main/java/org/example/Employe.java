package org.example;

public class Employe {
    private String cin;
    private float salaireBrutMensuel;
    private IGRStrategy igrStrategy; // Ajout de la stratégie

    public Employe(String cin, float salaireBrutMensuel, IGRStrategy igrStrategy) {
        this.cin = cin;
        this.salaireBrutMensuel = salaireBrutMensuel;
        this.igrStrategy = igrStrategy;
    }

    // Délégation du calcul de l'IGR à la stratégie
    public float calculerIGR() {
        return igrStrategy.calculerIGR(salaireBrutMensuel);
    }

    public float getSalaireNetMensuel() {
        float igr = calculerIGR();
        float salaireNetAnuel = salaireBrutMensuel * 12 - igr;
        return salaireNetAnuel / 12;
    }

    // Getters et Setters
    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public float getSalaireBrutMensuel() {
        return salaireBrutMensuel;
    }

    public void setSalaireBrutMensuel(float salaireBrutMensuel) {
        this.salaireBrutMensuel = salaireBrutMensuel;
    }

    public void setIGRStrategy(IGRStrategy igrStrategy) {
        this.igrStrategy = igrStrategy;
    }
}
