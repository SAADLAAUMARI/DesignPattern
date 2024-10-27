package org.example;

public class IGRMaroc implements IGRStrategy {
    @Override
    public float calculerIGR(float salaireBrutMensuel) {
        float salaireBrutAnuel = salaireBrutMensuel * 12;
        if (salaireBrutAnuel < 40000) {
            return salaireBrutAnuel * 0.05f;
        } else if (salaireBrutAnuel < 120000) {
            return salaireBrutAnuel * 0.20f;
        } else {
            return salaireBrutAnuel * 0.42f;
        }
    }
}
