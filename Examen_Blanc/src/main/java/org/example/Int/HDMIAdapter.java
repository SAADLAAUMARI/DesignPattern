package org.example.Int;

public class HDMIAdapter implements Adapter {
    @Override
    public void output(String content) {
        System.out.println("Affichage via HDMI : " + content);
    }
}
