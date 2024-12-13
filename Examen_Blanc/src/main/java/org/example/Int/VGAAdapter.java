package org.example.Int;
public class VGAAdapter implements Adapter {
    @Override
    public void output(String content) {
        System.out.println("Affichage via VGA : " + content);
    }
}
