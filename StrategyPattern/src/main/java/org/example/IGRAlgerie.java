package org.example;

public class IGRAlgerie implements IGRStrategy {
    @Override
    public float calculerIGR(float salaireBrutMensuel) {
        float salaireBrutAnuel = salaireBrutMensuel * 12;
        return salaireBrutAnuel * 0.35f;
    }
}