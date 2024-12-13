package org.example.Int;

public class VGAtoHDMIAdapter implements Adapter {
    private final Adapter vgaAdapter;

    public VGAtoHDMIAdapter(Adapter vgaAdapter) {
        this.vgaAdapter = vgaAdapter;
    }

    @Override
    public void output(String content) {
        System.out.println("Adaptation de VGA à HDMI...");
        vgaAdapter.output(content); // Délègue l'affichage au VGA
    }
}